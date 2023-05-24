package seminar_7.builder;


public class Program {
    public static void main(String[] args) {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo("to@mail.ru");
        mailMessage.setFrom("from@mail.ru");
        mailMessage.setSubject("Hello");

        MailMessage mailMessage1 = new MailMessageBuilder()
                .setBody("")
                .setFrom("")
                .setSubject("")
                .build();
    }
}
