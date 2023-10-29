package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TwoPair extends Hand<TwoPair> {

    private Rank rank;
    private Rank rank1;
    private Rank high;

    public TwoPair(Rank rank, Rank rank1, Rank high) {
        this.rank = rank;
        this.rank1 = rank1;
        this.high = high;
    }

    public TwoPair() {
    }

    protected Optional<TwoPair> extract(List<Card> cards) {

        List<Rank> ranks = cards.stream().map(card -> card.getRank()).collect(Collectors.toList());
        List<Rank> pairs = ranks.stream().distinct().filter((rank)-> Collections.frequency(ranks, rank) == 2).collect(Collectors.toList());

        if (pairs.size() == 2) {
            Rank highest = ranks.stream().filter(rank1 -> rank1 != pairs.get(0) && rank1 != pairs.get(1)).sorted(Comparator.comparing((rank1 -> rank1.ordinal()))).collect(Collectors.toList()).get(0);
            return Optional.of(new TwoPair(pairs.get(0), pairs.get(1), highest));
        }

        return Optional.empty();
    }

    @Override
    public int compareTo(TwoPair playerB) {
        if (greaterThanAll(this.rank, playerB.rank, playerB.rank1) || greaterThanAll(this.rank1, playerB.rank, playerB.rank1)) {
            return 1;
        } else if (greaterThanAll(playerB.rank, this.rank, this.rank1) || greaterThanAll(playerB.rank1, this.rank, this.rank1)) {
            return -1;
        } else {
            return compareHighCard(this.high, playerB.high);
        }
    }

    private boolean greaterThanAll(Rank a, Rank... ranks) {
        for (Rank rank : ranks) {
            if (rank.ordinal() > a.ordinal()) {
                return false;
            }
        }
        return true;
    }
}
