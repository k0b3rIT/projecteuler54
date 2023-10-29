package com.k0b3rIT.poker.game;

import com.k0b3rIT.poker.model.deck.Deck;
import com.k0b3rIT.poker.model.deck.HandRanking;
import com.k0b3rIT.poker.model.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FiveHandGameEngine extends GameEngine {

    RankingEngine rankingEngine = RankingEngine.create();

    public void start() {
        List<Player> players = initPLayers(10);
        Deck deck = new Deck();
        deck.shuffle();

        deal(deck, players);

        for (Player player : players) {
            player.setCurrentHand(rankingEngine.getRanking(player.getCards()));
            System.out.println(player);
            System.out.println("\033[0;31m" + player.getCurrentHand() + "\033[0m");
        }



        Player winner = rankingEngine.selectTheWinner(players);

        System.out.println("\n###### WINNER ######");
        System.out.println(winner);

    }




    private void burnCard(Deck deck) {
        deck.draw();
    }

    public void deal(Deck deck, List<Player> players) {
        for (Player player : players) {
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
            player.addCardToThehand(deck.draw());
        }
    }
}