package org.example.atm;

import lombok.Data;

@Data
public class Banknote {
    private final Currency currency;
    private final Nominal nominal;

    public Banknote(Currency currency, Nominal nominal) {
        this.currency = currency;
        this.nominal = nominal;
    }
}
