package ptithcm.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
public class MailConfig {
    @Bean 
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
          
        mailSender.setUsername("ducmanhlai22@gmail.com");
        mailSender.setPassword("cvxqxbcklntoebgt");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;

    }
    @Bean
  public SimpleMailMessage emailTemplate()
  {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("somebody@gmail.com");
    message.setFrom("admin@gmail.com");
      message.setText("FATAL - Application crash. Save your job !!");
      return message;
  }
}
