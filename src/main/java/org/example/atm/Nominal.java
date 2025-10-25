package org.example.atm;

public enum Nominal {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private final Integer value;

    Nominal(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
