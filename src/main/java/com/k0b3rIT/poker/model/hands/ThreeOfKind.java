package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ThreeOfKind extends RankComparableHand<ThreeOfKind> implements RankComparable<ThreeOfKind> {

    private Rank rank;
    private Rank high;

    public ThreeOfKind(Rank rank, Rank high) {
        this.rank = rank;
        this.high = high;
    }

    public ThreeOfKind() {
    }

    protected Optional<ThreeOfKind> extract(List<Card> cards) {

        List<Rank> ranks = cards.stream().map(card -> card.getRank()).collect(Collectors.toList());
        Optional<Rank> threeOfKind = ranks.stream().distinct().filter((rank) -> Collections.frequency(ranks, rank) == 3).findFirst();

        if (threeOfKind.isPresent()) {
            Rank high = ranks.stream().filter(rank -> rank != threeOfKind.get()).sorted(Comparator.comparing((rank)->rank.ordinal())).collect(Collectors.toList()).get(0);
            return Optional.of(new ThreeOfKind(threeOfKind.get(), high));
        }

        return Optional.empty();
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
