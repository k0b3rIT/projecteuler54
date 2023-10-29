package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Rank;

public interface RankComparable<T> extends Comparable<T> {
    public Rank getRank();
    public Rank getHigh();
}
