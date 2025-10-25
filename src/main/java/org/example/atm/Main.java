package org.example.atm;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(Currency.RUB, Currency.USD);
        atm.printSupportedNominals();

        atm.addBanknote(new Banknote(Currency.RUB, Nominal.FIVE_THOUSAND));
        atm.addBanknote(new Banknote(Currency.RUB, Nominal.FIVE_THOUSAND));
        atm.addBanknote(new Banknote(Currency.RUB, Nominal.ONE_THOUSAND));
        atm.addBanknote(new Banknote(Currency.RUB, Nominal.FIVE_HUNDRED));
        atm.addBanknote(new Banknote(Currency.RUB, Nominal.FIVE_HUNDRED));
        atm.addBanknote(new Banknote(Currency.USD, Nominal.TEN));
        atm.addBanknote(new Banknote(Currency.USD, Nominal.TWENTY));

        atm.audit();

        atm.withdraw(Currency.SOM, 6500);
        atm.withdraw(Currency.RUB, 7000);

        atm.audit();

    }
}
