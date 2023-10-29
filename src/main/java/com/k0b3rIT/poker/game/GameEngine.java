package com.k0b3rIT.poker.game;

import com.k0b3rIT.poker.model.deck.Deck;
import com.k0b3rIT.poker.model.deck.Desk;
import com.k0b3rIT.poker.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEngine {

    protected void printState(Deck deck, List<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }

//        System.out.println(deck.getCards().size());
    }
    protected void printState(Deck deck, Desk desk, List<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }

        System.out.println(desk);
        System.out.println(deck.getCards().size());
    }

    protected ArrayList<Player> initPLayers(int countOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < countOfPlayers; i++) {
            players.add(new Player(i+"_Player"));
        }
        return players;
    }

}
