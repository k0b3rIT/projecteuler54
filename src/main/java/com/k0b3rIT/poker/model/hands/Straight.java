package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.List;
import java.util.Optional;

public class Straight extends Hand<Straight> {

    private Rank high;

    public Straight(Rank high) {
        this.high = high;
    }

    public Straight() {
    }

    protected Optional<Straight> extract(List<Card> cards) {
        if (isStraight(cards)) {
            return Optional.of(new Straight(cards.get(4).getRank()));
        }
        return Optional.empty();
    }


    @Override
    public int compareTo(Straight playerB) {
        return compareHighCard(this.high, playerB.high);
    }
}
