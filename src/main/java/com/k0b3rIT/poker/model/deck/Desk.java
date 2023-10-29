package com.k0b3rIT.poker.model.deck;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private List<Card> cards = new ArrayList<>();
    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------[DESK] (" + cards.size()+")-------\n");
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
