package tn.pi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by abburi on 6/10/17.
 */

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
	private Configuration config;

    @Value("${email.from.address}")
    private String fromAddress;

    public void sendMailMultipart(String toEmail, String subject) throws MessagingException, IOException, TemplateException {
    	MimeMessage message = javaMailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
    	
		Template t = config.getTemplate("mail.ftl");
		
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, null);
    

       // MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.addAttachment("QRCode.png", new ClassPathResource("QRCode.png"));
        helper.addAttachment("bill.pdf", new ClassPathResource("bill.pdf"));
        
        helper.setFrom(fromAddress);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(html, true);
        javaMailSender.send(message);

    }

    public void sendMail(String toEmail, String subject,String text) throws MessagingException, IOException, TemplateException {
    	MimeMessage message = javaMailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
    	
		//Template t = config.getTemplate("mail.ftl");
		
//		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, null);
    

       // MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
       // helper.addAttachment("QRCode.png", new ClassPathResource("QRCode.png"));
        //helper.addAttachment("bill.pdf", new ClassPathResource("bill.pdf"));
        
        helper.setFrom(fromAddress);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(text);
        javaMailSender.send(message);

       
      
    }

	

   
    

   
}