package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.List;
import java.util.Optional;

public class Flush extends RankComparableHand<Flush> {

    private Rank rank;

    public Flush(Rank rank) {
        this.rank = rank;
    }

    public Flush() {
    }

    public Optional<Flush> extract(List<Card> cards) {
        if (isFlush(cards)) {
            return Optional.of(new Flush(cards.get(4).getRank()));
        }
        return Optional.empty();
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Rank getHigh() {
        return Rank.R2; //NO High
    }
}
