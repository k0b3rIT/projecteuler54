package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;

import java.util.List;
import java.util.Optional;

public class HighCard extends Hand<HighCard> {

    private Rank rank;

    public HighCard(Rank rank) {
        this.rank = rank;
    }

    public HighCard() {
    }

    protected Optional<HighCard> extract(List<Card> cards) {

        return Optional.of(new HighCard(cards.get(4).getRank()));


    }

    @Override
    public int compareTo(HighCard b) {
        return compareHighCard(this.rank, b.rank);
    }
}
