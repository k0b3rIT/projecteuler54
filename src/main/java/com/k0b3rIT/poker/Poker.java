package com.k0b3rIT.poker;

import com.k0b3rIT.poker.game.RankingEngine;
import com.k0b3rIT.poker.model.deck.Deck;
import com.k0b3rIT.poker.model.player.Dealer;
import com.k0b3rIT.poker.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Poker {

    public static void main(String[] args) {
        RankingEngine rankingEngine = RankingEngine.create();
        Dealer dealer = new Dealer();

        List<Player> players = initPLayers(10);
        Deck deck = new Deck();
        dealer.deal(deck, players);

        for (Player player : players) {
            player.setCurrentHand(rankingEngine.getRanking(player.getCards()));
            System.out.println(player);
            System.out.println("\033[0;31m" + player.getCurrentHand() + "\033[0m");
        }

        Player winner = rankingEngine.selectTheWinner(players);

        System.out.println("\n###### WINNER ######");
        System.out.println(winner);
    }

    public static ArrayList<Player> initPLayers(int countOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < countOfPlayers; i++) {
            players.add(new Player(i+"_Player"));
        }
        return players;
    }
}
