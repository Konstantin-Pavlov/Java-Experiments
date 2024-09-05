package org.example.mailServiceStepic;

import org.example.mailServiceStepic.mailExceptions.IllegalPackageException;
import org.example.mailServiceStepic.mailExceptions.StolenPackageException;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailServiceRunner1 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MailServiceRunner1.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        List<MailService> variousWorkers = List.of(spy, thief, inspector);
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable[] correspondence = {
                new MailMessage("James", "Tim", "How is it going?"),
                new MailMessage("Tim", "James", "Fine! How are you?"),
                new MailMessage("Ilon Mask", Constants.AUSTIN_POWERS, "Gonna order some parts for a new rocket engine.."),
                new MailMessage(Constants.AUSTIN_POWERS, "Ilon Mask", "no problem bro"),
                new MailMessage("ef54fs", "sd64fx3", Constants.WEAPONS),
                new MailMessage(Constants.AUSTIN_POWERS, "Ilon Mask", "no problem bro"),
                new MailPackage("hmmm", "uhhhh", new Package("wow", 32)),
                new MailMessage("NASA", Constants.AUSTIN_POWERS, "we need to know what Mask ordered, send it to us"),
                new MailPackage(Constants.AUSTIN_POWERS, "NASA", new Package("rocket engine", 2500000)),
                new MailPackage(Constants.AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("China", "NK", new Package("banned substance", 99)),
                new MailPackage(Constants.AUSTIN_POWERS, "terrorists", new Package("tiny bomb", 9000)),
                new MailMessage(Constants.AUSTIN_POWERS, "shrink", "pls hlp"),
                new MailMessage("Ray", "Gim", Constants.BANNED_SUBSTANCE)
        };
        Arrays.stream(correspondence).forEach(parcel -> {
            try {
                worker.processMail(parcel);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }
}
