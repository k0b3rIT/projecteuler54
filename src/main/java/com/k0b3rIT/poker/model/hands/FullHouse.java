package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FullHouse extends Hand<FullHouse> {

    private Rank threeOfKindRank;
    private Rank pairRank;

    public FullHouse(Rank threeOfKindRank, Rank pairRank) {
        this.threeOfKindRank = threeOfKindRank;
        this.pairRank = pairRank;
    }

    public FullHouse() {
    }

    protected Optional<FullHouse> extract(List<Card> cards) {

        List<Rank> ranks = cards.stream().map(card -> card.getRank()).collect(Collectors.toList());
        Optional<Rank> threeOfKind = ranks.stream().distinct().filter(rank -> Collections.frequency(ranks, rank) == 3).findFirst();
        Optional<Rank> pair = ranks.stream().distinct().filter(rank -> Collections.frequency(ranks, rank) == 2).findFirst();

        if (threeOfKind.isPresent() && pair.isPresent()) {
           return Optional.of(new FullHouse(threeOfKind.get(), pair.get()));
        }
        return Optional.empty();
    }

    @Override
    public int compareTo(FullHouse playerB) {
        if (this.threeOfKindRank.ordinal() > playerB.threeOfKindRank.ordinal()) {
            return 1;
        } else if (playerB.threeOfKindRank.ordinal() > this.threeOfKindRank.ordinal()) {
            return -1;
        } else {
            return compareByPair(playerB);
        }
    }

    public int compareByPair(FullHouse playerB) {
        if (this.pairRank.ordinal() > playerB.pairRank.ordinal()) {
            return 1;
        } else if (playerB.pairRank.ordinal() > this.pairRank.ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }

}
