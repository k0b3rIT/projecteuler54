package com.k0b3rIT.poker.model.deck;

public enum Suit {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }
}
