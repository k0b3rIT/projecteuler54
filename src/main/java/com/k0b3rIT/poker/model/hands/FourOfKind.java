package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FourOfKind extends RankComparableHand<FourOfKind> {

    private Rank rank;
    private Rank high;

    public FourOfKind(Rank rank, Rank high) {
        this.rank = rank;
        this.high = high;
    }

    public FourOfKind() {
    }

    public Optional<FourOfKind> extract(List<Card> cards) {

        List<Rank> ranks = cards.stream().map(card -> card.getRank()).collect(Collectors.toList());
        Optional<Rank> fourOfKind = ranks.stream().distinct().filter((rank) -> Collections.frequency(ranks, rank) == 4).findFirst();

        if (fourOfKind.isPresent()) {
            Rank high = ranks.stream().filter(rank -> rank != fourOfKind.get()).collect(Collectors.toList()).get(0);
            return Optional.of(new FourOfKind(fourOfKind.get(), high));
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
