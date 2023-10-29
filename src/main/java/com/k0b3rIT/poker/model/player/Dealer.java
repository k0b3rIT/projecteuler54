package com.k0b3rIT.poker.model.player;

import com.k0b3rIT.poker.model.deck.Deck;

import java.util.List;

public class Dealer {

    public Dealer() {
    }

    public void deal(Deck deck, List<Player> players) {
        deck.shuffle();
        for (Player player : players) {
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
        }
    }
}
