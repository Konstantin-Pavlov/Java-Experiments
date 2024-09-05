package org.example.mailServiceStepic;

import lombok.Getter;

/**
 * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
 * Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
 * Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок,
 * которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
 * он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */
public class Thief implements MailService {
    @Getter
    private static int StolenValue;
    private static int MinValue;

    public Thief(int m) {
        this.MinValue = m;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage mailPackage) {
            if (mailPackage.getContent().getPrice() >= MinValue) {
                StolenValue += mailPackage.getContent().getPrice();
                return new MailPackage(
                        mailPackage.from,
                        mailPackage.to,
                        new Package("stones instead of " + mailPackage.getContent(), 0)
                );
            }
        }
        return mail;
    }
}
