package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.List;
import java.util.Optional;

public class StraightFlush extends Hand<StraightFlush> {

    private Rank high;

    public StraightFlush(Rank high) {
        this.high = high;
    }

    public StraightFlush() {
    }

    protected Optional<StraightFlush> extract(List<Card> cards) {
        if (isStraight(cards) && cards.get(4).getRank() != Rank.RA && isFlush(cards)) {
            return Optional.of(new StraightFlush(cards.get(4).getRank()));
        }

        return Optional.empty();
    }

    @Override
    public int compareTo(StraightFlush playerB) {
        return compareHighCard(this.high, playerB.high);
    }
}
