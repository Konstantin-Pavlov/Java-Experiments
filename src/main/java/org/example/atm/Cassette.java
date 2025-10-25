package org.example.atm;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Log4j2
@Data
public class Cassette {
    private final Map<Nominal, List<Banknote>> banknoteMap;
    private final Currency currency;

    public Cassette(Currency currency) {
        log.info("Создание кассеты с валютой [{}]", currency.name());
        this.banknoteMap = new HashMap<>();
        this.currency = currency;
        log.info("Инициализация номиналов кассеты с валютой [{}]", currency.name());
        currency.getNominals().forEach(nominal -> {
            log.trace("добавляем номинал {}", nominal.name());
            banknoteMap.put(nominal, new ArrayList<>());
        });
        log.info("Кассета с валютой [{}] инициализирована успешно\n", currency.name());
    }

    public void addBanknoteToCassette(Banknote banknote) {
        if (banknote.getCurrency() != currency) {
            System.err.println("Нельзя добавить купюру другой валюты: " + banknote.getCurrency());
            return;
        }

        System.out.println("Добавлена купюра: " + banknote.getNominal() + " " + banknote.getCurrency());

        banknoteMap.computeIfAbsent(banknote.getNominal(), k -> new ArrayList<>()).add(banknote);
    }

    public int getTotalAmount() {
        return banknoteMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getValue() * entry.getValue().size())
                .sum();
    }

}
