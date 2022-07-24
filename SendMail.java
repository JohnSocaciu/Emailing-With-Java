import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;
import static javax.mail.Transport.send;

public class SendMail //trying to send an email from a java program
{

    public static void main(String [] args) // doesn't work with Google ---> To help keep your account secure,
                                            // from May 30, 2022, ​​Google no longer supports the use of third-party apps or devices which ask you
                                            // to sign in to your Google Account using only your username and password.
                                            // Important: This deadline does not apply to Google Workspace or Google Cloud Identity customers.
                                            // The enforcement date for these customers will be announced on the Workspace blog at a later date.For more information, continue to read.
    {
        String to = "john.socaciu@gmail.com";
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("john.socaciu@gmail.com", "N/A");
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("john.socaciu@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("hello");
            message.setText("testing");

            Transport.send(message);
            System.out.println("the message has been sent");
        }
        catch(MessagingException e){
           throw new RuntimeException(e);
    }

    }
}