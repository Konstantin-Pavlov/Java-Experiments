package org.example.atm;

import java.util.List;

public enum Currency {
    RUB(List.of(
            Nominal.TEN,
            Nominal.FIFTY,
            Nominal.ONE_HUNDRED,
            Nominal.FIVE_HUNDRED,
            Nominal.ONE_THOUSAND,
            Nominal.FIVE_THOUSAND
    )),
    USD(List.of(
            Nominal.ONE,
            Nominal.FIVE,
            Nominal.TEN,
            Nominal.TWENTY,
            Nominal.FIFTY,
            Nominal.ONE_HUNDRED
    )),
    EUR(List.of(
            Nominal.FIVE,
            Nominal.TEN,
            Nominal.TWENTY,
            Nominal.FIFTY,
            Nominal.ONE_HUNDRED,
            Nominal.TWO_HUNDRED,
            Nominal.FIVE_HUNDRED
    )),
    SOM(List.of(
            Nominal.TWENTY,
            Nominal.FIFTY,
            Nominal.ONE_HUNDRED,
            Nominal.TWO_HUNDRED,
            Nominal.FIVE_HUNDRED,
            Nominal.ONE_THOUSAND,
            Nominal.TWO_THOUSAND,
            Nominal.FIVE_THOUSAND
    ));

    private final List<Nominal> nominals;

    Currency(List<Nominal> nominals) {
        this.nominals = nominals;
    }

    public List<Nominal> getNominals() {
        return nominals;
    }
}

