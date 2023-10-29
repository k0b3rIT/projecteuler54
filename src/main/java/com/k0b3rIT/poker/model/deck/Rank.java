package com.k0b3rIT.poker.model.deck;

public enum Rank {
    R2(2, "2"),
    R3(3, "3"),
    R4(4, "4"),
    R5(5, "5"),
    R6(6, "6"),
    R7(7, "7"),
    R8(8, "8"),
    R9(9, "9"),
    R10(10, "10"),
    RJ(10, "J"),
    RQ(10, "Q"),
    RK(10, "K"),
    RA(11, "A");

    String symbol;
    int value;
    Rank(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }
}
