package com.example.demo;

import com.example.demo.dao.Person;
import com.example.demo.dao.SMSInformation;
import com.example.demo.service.MailService;
import com.example.demo.service.impl.TextMessageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.demo.util.md5.getMD5Str;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
    @Autowired
    private SMSInformation smsInformation;

    @Autowired
    private TextMessageServiceImpl textMessageService;
    @Autowired
    private Person person;

    @Autowired
    private MailService mailService;

    @Value("${sms.host}")
    private String host;

    @Test
    public void contextLoads() {
    }

    @Test
    public  void demo1(){
//        System.out.println(person);
        logger.info(person.toString());
    }

    /**
     * 发送简单纯文本邮件
     */
    @Test
    public void sendSimpleMail() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String subject = simpleDateFormat.format(date);


       subject = "发送邮件测试" + subject;
        mailService.sendSimpleMail("yangyage1@crbeverage.com", subject, "大家好，这是我用springboot进行发送邮件测试");
    }

    /**
     * 发送HTML邮件
     */
    @Test
    public void sendHtmlMail() {
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件" + "</font></h3></body></html>";
        mailService.sendHtmlMail("yangyage1@crbeverage.com", "发送邮件测试", content);
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendAttachmentMail() {
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件，有附件哦" + "</font></h3></body></html>";
        String filePath = "D:\\2.xlsx";
        mailService.sendAttachmentMail("yangyage1@crbeverage.com", "发送邮件测试", content, filePath);
    }

    /**
     * 发送带图片的邮件
     */
    @Test
    public void sendInlineResourceMail() {
        String rscPath = "D:\\1.jpg";
        String rscId = "001";
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件，有图片哦" + "</font></h3>";
//                + "<img src=\'cid:" + rscId + "\'></body></html>";
        mailService.sendInlineResourceMail("yangyage1@crbeverage.com", "发送邮件测试", content, rscPath, rscId);
    }

    @Test
    public void  sendSMS() {
          textMessageService.sendTextMessage("*********","test000");
    }



}
