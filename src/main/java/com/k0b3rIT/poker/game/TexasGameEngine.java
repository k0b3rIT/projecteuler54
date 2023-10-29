package com.k0b3rIT.poker.game;

import com.k0b3rIT.poker.model.deck.Deck;
import com.k0b3rIT.poker.model.deck.Desk;
import com.k0b3rIT.poker.model.player.Player;

import java.util.ArrayList;

public class TexasGameEngine extends GameEngine {

    public void start() {
        Deck deck = new Deck();

        deck.shuffle();

        ArrayList<Player> players = initPLayers(10);
        Desk desk = new Desk();

        deal(deck, players);
        burnCard(deck);
        flop(deck, desk);
        burnCard(deck);
        turn(deck, desk);
        burnCard(deck);
        river(deck, desk);

        printState(deck, desk, players);

    }

    private void burnCard(Deck deck) {
        deck.draw();
    }

    public void deal(Deck deck, ArrayList<Player> players) {
        for (Player player : players) {
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
        }
    }

    public void flop(Deck deck, Desk desk) {
        desk.addCard(deck.draw());
        desk.addCard(deck.draw());
        desk.addCard(deck.draw());
    }

    public void turn(Deck deck, Desk desk) {
        desk.addCard(deck.draw());
    }

    public void river(Deck deck, Desk desk) {
        desk.addCard(deck.draw());
    }
}
