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

        players = players.stream().sorted((a,b)-> compare(a,b)*-1).collect(Collectors.toList());

        System.out.println("\n###### WINNER ######");
        System.out.println(players.get(0));

    }


    private int compare(Player playerA, Player playerB) {
        HandRanking pa = HandRanking.getByClass(playerA.getCurrentHand().getClass());
        HandRanking pb = HandRanking.getByClass(playerB.getCurrentHand().getClass());
        if (pa.ordinal() < pb.ordinal()) {
            return 1;
        } else if (pb.ordinal() < pa.ordinal()) {
            return -1;
        } else {
            return playerA.getCurrentHand().compareTo(playerB.getCurrentHand());
        }
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