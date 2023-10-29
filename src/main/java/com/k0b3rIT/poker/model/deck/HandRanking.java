package com.k0b3rIT.poker.model.deck;

import com.k0b3rIT.poker.model.hands.Flush;
import com.k0b3rIT.poker.model.hands.FourOfKind;
import com.k0b3rIT.poker.model.hands.FullHouse;
import com.k0b3rIT.poker.model.hands.Hand;
import com.k0b3rIT.poker.model.hands.HighCard;
import com.k0b3rIT.poker.model.hands.OnePair;
import com.k0b3rIT.poker.model.hands.RoyalFlush;
import com.k0b3rIT.poker.model.hands.Straight;
import com.k0b3rIT.poker.model.hands.StraightFlush;
import com.k0b3rIT.poker.model.hands.ThreeOfKind;
import com.k0b3rIT.poker.model.hands.TwoPair;

import java.util.Arrays;

public enum HandRanking {
    ROYAL_FLUSH(RoyalFlush.class),
    STRAIGHT_FLUSH(StraightFlush.class),
    FOR_OF_A_KIND(FourOfKind.class),
    FULL_HOUSE(FullHouse.class),
    FLUSH(Flush.class),
    STRAIGHT(Straight.class),
    THREE_OF_A_KIND(ThreeOfKind.class),
    TWO_PAIRS(TwoPair.class),
    ONE_PAIR(OnePair.class),
    HIGH_CARD(HighCard.class);

    public Class<? extends Hand> clazz;

    HandRanking(Class<? extends Hand> clazz) {
        this.clazz = clazz;
    }

    public static HandRanking getByClass(Class<? extends Hand> clazz) {
        return Arrays.stream(values()).filter(handRanking -> handRanking.clazz.equals(clazz)).findFirst().orElseThrow(()->new IllegalArgumentException("Not found handrank!"));
    }
}
