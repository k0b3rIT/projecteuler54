package com.k0b3rIT.poker.model.deck;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards = new Stack<>();

    public Deck() {
        init();
    }

    private void init() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void reset() {
        cards.clear();
        init();
    }

    public Card draw() {
        return cards.pop();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        shuffle(new SecureRandom());
    }

    public void shuffle(int seed) {
        shuffle(new SecureRandom(String.valueOf(seed).getBytes()));
    }

    private void shuffle(Random generator) {
        Stack<Card> originalStack = new Stack<>();
        originalStack.addAll(cards);
        cards = new Stack<>();

        while (originalStack.size() > 0) {
            int id = (int) Math.round(generator.nextDouble() * (originalStack.size()-1));
            cards.push(originalStack.get(id));
            originalStack.remove(id);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------["+cards.size()+"]-------\n");
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
