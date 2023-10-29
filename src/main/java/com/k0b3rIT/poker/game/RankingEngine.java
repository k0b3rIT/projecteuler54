package com.k0b3rIT.poker.game;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.HandRanking;
import com.k0b3rIT.poker.model.hands.Hand;
import com.k0b3rIT.poker.model.player.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RankingEngine {

    private RankingEngine() {
    }

    private static RankingEngine rankingEngine;

    public static RankingEngine create() {
        if (rankingEngine == null) {
            rankingEngine = new RankingEngine();
        }
        return rankingEngine;
    }

    public Player selectTheWinner(List<Player> players) {
        return players.stream().sorted((a,b)-> compare(a,b)*-1).collect(Collectors.toList()).stream().findFirst().get();
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


    public Hand getRanking(List<Card> cards) {
        List<HandRanking> rankings = Arrays.stream(HandRanking.values()).sorted(Comparator.comparing(HandRanking::ordinal)).collect(Collectors.toList());
        for (HandRanking ranking : rankings) {
            try {
                Hand hand1 = ranking.clazz.getDeclaredConstructor().newInstance();
                Optional<Hand> optionalHand = hand1.extractValue(cards);
                if (optionalHand.isPresent()) {
                    return optionalHand.get();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        throw new IllegalStateException("We have not found any matching hand!");
    }
}
