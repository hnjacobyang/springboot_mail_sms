package com.example.demo.service.impl;

import com.example.demo.dao.SMSInformation;
import com.example.demo.service.TextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TextMessageServiceImpl implements TextMessageService {

//    @Value("${sms.host}")
//    private String host;

    @Autowired
    private SMSInformation smsInformation;
    @Override
    public void sendTextMessage(String mobile, String content) {
        System.out.println(smsInformation);
        String url = smsInformation.GetRequestURL(mobile,content);
        System.out.println("sendTextMessage*****url:" + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String strbody = restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        System.out.println(strbody);
    }
}
