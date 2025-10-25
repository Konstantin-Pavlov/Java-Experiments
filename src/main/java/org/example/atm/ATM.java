package org.example.atm;

import org.example.util.ConsoleColors;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private final List<Currency> currencies;
    private final Map<Currency,Cassette> cassettesMap;


    public ATM(Currency... currencies) {
        this.currencies = List.of(currencies);
        this.cassettesMap = new HashMap<>();
        for (Currency currency : currencies) {
            cassettesMap.put(currency, new Cassette(currency));
        }
    }

    public void addBanknote(Banknote banknote) {
        // 1️⃣ Проверяем, что банкомат поддерживает эту валюту
        if (!currencies.contains(banknote.getCurrency())) {
            System.err.println("Банкомат не поддерживает валюту: " + banknote.getCurrency());
            return;
        }

        // 2️⃣ Проверяем, что у валюты есть такой номинал
        if (!banknote.getCurrency().getNominals().contains(banknote.getNominal())) {
            System.err.printf("Номинал %s не поддерживается для валюты %s%n", banknote.getNominal(), banknote.getCurrency());
            return;
        }
        cassettesMap.get(banknote.getCurrency()).addBanknoteToCassette(banknote);
    }

    public void withdraw(Currency currency, int amount) {
        System.out.printf("%n=== Запрошено снятие %d %s ===%n", amount, currency);

        // Проверка валюты
        Cassette cassette = cassettesMap.get(currency);
        if (cassette == null) {
            System.out.println(ConsoleColors.ANSI_RED_BACKGROUND + "Банкомат не поддерживает валюту: " + currency + ConsoleColors.RESET);
            return;
        }

        int totalAvailable = cassette.getTotalAmount();
        if (totalAvailable < amount) {
            System.out.printf("%sНедостаточно средств. Доступно %d %s%s%n",ConsoleColors.ANSI_RED_BACKGROUND, totalAvailable, currency, ConsoleColors.RESET);
            return;
        }

        // Подбор купюр — жадный алгоритм (от большего к меньшему)
        List<Nominal> sortedNominals = cassette.getBanknoteMap().keySet().stream()
                .sorted(Comparator.comparingInt(Nominal::getValue).reversed())
                .toList();

        Map<Nominal, Integer> toWithdraw = new LinkedHashMap<>();
        int remaining = amount;

        for (Nominal nominal : sortedNominals) {
            List<Banknote> banknotes = cassette.getBanknoteMap().get(nominal);
            int availableCount = banknotes.size();
            int neededCount = remaining / nominal.getValue();
            int takeCount = Math.min(availableCount, neededCount);

            if (takeCount > 0) {
                toWithdraw.put(nominal, takeCount);
                remaining -= nominal.getValue() * takeCount;
            }

            if (remaining == 0) break;
        }

        if (remaining > 0) {
            System.err.printf("%sНевозможно выдать сумму %d %s имеющимися номиналами%s.%n",ConsoleColors.ANSI_RED_BACKGROUND, amount, currency, ConsoleColors.RESET);
            return;
        }

        // Удаляем выданные купюры из кассеты
        toWithdraw.forEach((nominal, count) -> {
            List<Banknote> notes = cassette.getBanknoteMap().get(nominal);
            for (int i = 0; i < count; i++) {
                notes.removeLast(); // убираем с конца
            }
        });

        System.out.printf("Выдано %d %s следующими купюрами:%n", amount, currency);
        toWithdraw.forEach((nominal, count) ->
                System.out.printf("  %s x %d шт.%n", nominal.getValue(), count)
        );

        System.out.println("Остаток в кассете: " + cassette.getTotalAmount() + " " + currency);
    }


    public void audit() {
        System.out.println("=== Аудит банкомата ===");
        int total = 0;

        for (Map.Entry<Currency, Cassette> entry : cassettesMap.entrySet()) {
            Currency currency = entry.getKey();
            Cassette cassette = entry.getValue();
            int cassetteTotal = cassette.getTotalAmount();

            System.out.printf("Валюта: %s%n", currency);
            cassette.getBanknoteMap().forEach((nominal, banknotes) -> {
                System.out.printf("  %s x %d шт.%n", nominal, banknotes.size());
            });
            System.out.printf("  Сумма по валюте %s: %d%n%n", currency, cassetteTotal);

            total += cassetteTotal;
        }
// add conversion
//        System.out.printf("Итого по банкомату: %d (в базовой валюте или без конвертации)%n", total);
        System.out.println("========================");
    }


    public void printSupportedNominals() {
        currencies.forEach(currency -> {
            System.out.println(currency + ": " + currency.getNominals());
        });
    }
}
