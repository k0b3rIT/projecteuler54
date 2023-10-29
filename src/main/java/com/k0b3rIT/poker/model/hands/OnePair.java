package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OnePair extends RankComparableHand<OnePair> {

    private Rank rank;
    private Rank high;

    public OnePair(Rank rank, Rank high) {
        this.rank = rank;
        this.high = high;
    }

    public OnePair() {
    }

    protected Optional<OnePair> extract(List<Card> cards) {

        List<Rank> ranks = cards.stream().map(card -> card.getRank()).collect(Collectors.toList());
        List<Rank> pairs = ranks.stream().distinct().filter((rank)->Collections.frequency(ranks, rank) == 2).collect(Collectors.toList());

        if (pairs.size() == 1) {
            Rank highest = ranks.stream().filter(rank1 -> rank1 != pairs.get(0)).sorted(Comparator.comparing((rank1 -> rank1.ordinal()))).collect(Collectors.toList()).get(0);
            return Optional.of(new OnePair(pairs.get(0), highest));
        }

        return Optional.empty();
    }


    public OnePair(Rank rank) {
        this.rank = rank;
    }


    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Rank getHigh() {
        return high;
    }
}
