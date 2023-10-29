package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.List;
import java.util.Optional;

public class RoyalFlush extends Hand<RoyalFlush>{

    public RoyalFlush() {
    }

    protected Optional<RoyalFlush> extract(List<Card> cards) {
        if (isStraight(cards) && cards.get(4).getRank() == Rank.RA && isFlush(cards)) {
            return Optional.of(new RoyalFlush());
        }

        return Optional.empty();
    }

    @Override
    public int compareTo(RoyalFlush playerB) {
        return 0;
    }
}
