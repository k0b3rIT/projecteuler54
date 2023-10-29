package com.k0b3rIT.poker.test;

import com.k0b3rIT.poker.game.RankingEngine;
import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;
import com.k0b3rIT.poker.model.deck.Suit;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RankingTest {

    @Test
    public void test() {
        RankingEngine rankingEngine = RankingEngine.create();

        Card[] customCards = new Card[]{
                new Card(Rank.R10, Suit.CLUBS),
                new Card(Rank.RJ, Suit.CLUBS),
                new Card(Rank.RQ, Suit.CLUBS),
                new Card(Rank.RK, Suit.CLUBS),
                new Card(Rank.RA, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R9, Suit.CLUBS),
                new Card(Rank.R10, Suit.CLUBS),
                new Card(Rank.RJ, Suit.CLUBS),
                new Card(Rank.RQ, Suit.CLUBS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R4, Suit.SPADES),
                new Card(Rank.R4, Suit.HEARTS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R4, Suit.SPADES),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.R5, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.RK, Suit.CLUBS),
                new Card(Rank.R5, Suit.CLUBS),
                new Card(Rank.RA, Suit.CLUBS),
                new Card(Rank.R7, Suit.CLUBS),
                new Card(Rank.R8, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.R6, Suit.DIAMONDS),
                new Card(Rank.R7, Suit.CLUBS),
                new Card(Rank.R8, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R4, Suit.SPADES),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R5, Suit.SPADES),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R4, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R6, Suit.SPADES),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));

        customCards = new Card[]{
                new Card(Rank.R2, Suit.CLUBS),
                new Card(Rank.R4, Suit.DIAMONDS),
                new Card(Rank.R6, Suit.SPADES),
                new Card(Rank.R5, Suit.HEARTS),
                new Card(Rank.RK, Suit.CLUBS)
        };

        System.out.println(rankingEngine.getRanking(Arrays.asList(customCards)));
    }
}
