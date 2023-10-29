package com.k0b3rIT.poker.model.hands;

import com.k0b3rIT.poker.model.deck.Card;
import com.k0b3rIT.poker.model.deck.Rank;
import com.k0b3rIT.poker.model.deck.Suit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Hand<T> implements Comparable<T> {

    public Optional<T> extractValue(List<Card> cards) {
        List<Card> sorted = cards.stream().sorted(Comparator.comparing(card -> card.getRank())).collect(Collectors.toList());
        return extract(sorted);
    }

    protected abstract Optional<T> extract(List<Card> cards);

    protected static boolean isAllSameRank(List<Card> cards, int... ids) {

        List<Card> subList = new ArrayList<>();
        for (int id : ids) {
            subList.add(cards.get(id));
        }

        Rank golden = subList.get(0).getRank();
        for (int i = 1; i < subList.size(); i++) {
            if (subList.get(i).getRank() != golden) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isStraight(List<Card> cards) {
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getRank().ordinal() != cards.get(i-1).getRank().ordinal() + 1) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isFlush(List<Card> cards) {
        return isAllSameSuit(cards, 0, 1, 2, 3, 4);
    }

    protected static boolean isAllSameSuit(List<Card> cards, int... ids) {

        List<Card> subList = new ArrayList<>();
        for (int id : ids) {
            subList.add(cards.get(id));
        }

        Suit golden = subList.get(0).getSuit();
        for (int i = 1; i < subList.size(); i++) {
            if (subList.get(i).getSuit() != golden) {
                return false;
            }
        }
        return true;
    }

    protected int compareHighCard(Rank playerA, Rank playerB) {
        if (playerA.ordinal() > playerB.ordinal()) {
            return 1;
        } else if (playerB.ordinal() > playerA.ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
