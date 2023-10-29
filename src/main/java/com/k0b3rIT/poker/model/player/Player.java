package com.k0b3rIT.poker.model.player;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.hands.Hand;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int credit;
    private List<Card> cards = new ArrayList<>();
    private Hand currentHand;

    public Player(String name) {
        this.name = name;
        this.cards = cards;
    }

    public int getCredit() {
        return credit;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCardToThehand(Card card) {
        cards.add(card);
    }

    public void clearHand() {
        cards.clear();
    }

    public Hand getCurrentHand() {
        return currentHand;
    }

    public void setCurrentHand(Hand currentHand) {
        this.currentHand = currentHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------["+ name +"] (" + cards.size()+")-------\n");
        sb.append(cards.toString());
//        for (Card card : hand) {
//            sb.append(card.toString());
//            sb.append("\n");
//        }
        return sb.toString();
    }
}
