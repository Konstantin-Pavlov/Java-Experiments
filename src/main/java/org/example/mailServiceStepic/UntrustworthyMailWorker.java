package org.example.mailServiceStepic;

import java.util.Arrays;
import java.util.List;

/**
 * является MailService
 * UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
 * чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц,
 * а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
 * У UntrustworthyMailWorker должен быть конструктор от массива MailService
 * ( результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
 * и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.
 */
public class UntrustworthyMailWorker implements MailService {
    private final List<MailService> mailWorkers;
    private final RealMailService realWorker ;
//    private final MailService[] mailWorkers;

    public UntrustworthyMailWorker(List<MailService> mailWorkers) {
        this.mailWorkers = mailWorkers;
        this.realWorker = new RealMailService();
    }

//    public UntrustworthyMailWorker(MailService[] mailWorkers) {
//        this.mailWorkers = mailWorkers;
//        this.realWorker = new RealMailService();
//    }

    @Override
    public Sendable processMail(Sendable mail) {
        mailWorkers.forEach(worker -> worker.processMail(mail));
//        Arrays.stream(mailWorkers).forEach(worker -> worker.processMail(mail));
        return realWorker.processMail(mail);
    }

    public RealMailService getRealWorker() {
        return realWorker;
    }
}
