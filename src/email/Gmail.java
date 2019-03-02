//YouTube Tutorial - https://www.youtube.com/watch?v=sHC8YgW21ho&t=108s
package email;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class Gmail {
    
    
    
    public static void main(String[] args) {
        //Start of email code
        final String username = "stephenfinn17@gmail.com";
        final String password = "Starter4321";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");  //This is the smpt server address
        props.put("mail.smtp.port", "587"); //This is the port for the smpt server
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password); //This is used to authenticate your gmail account
                    }    
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stephenfinn17@gmail.com")); //From e-mail address
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("sfcoke@gmail.com")); //To e-mail address
            message.setSubject("My First Email"); //Sets subject of Email
            message.setContent("<h:body style=background-color:white;font-family:verdana;color:#OD66CC;>"
                    + "If you are getting this you wrote your first email.<br/><br/>"
                    + "</body>", "text/html; charset=utf-8"); //Sets the content body of the email
            Transport.send(message); //Sends the entire message object
                
            System.out.println("Was the email sent: Done"); //Verifies that the code fired
        
        }   catch (MessagingException e) {
            throw new RuntimeException(e); //If the email address is incorrect or doesn't exist
        }
        //End of email code
    }
}
