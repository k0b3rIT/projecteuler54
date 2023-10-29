package com.k0b3rIT.poker.model.hands;

public abstract class RankComparableHand<T extends RankComparable<T>> extends Hand<T> implements RankComparable<T> {

    @Override
    public int compareTo(T playerB) {
        if (this.getRank().ordinal() > playerB.getRank().ordinal()) {
            return 1;
        } else if (playerB.getRank().ordinal() > this.getRank().ordinal()) {
            return -1;
        } else {
            return compareHighCard(this.getHigh(), playerB.getHigh());
        }
    }
}
