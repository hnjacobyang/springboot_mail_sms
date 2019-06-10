package com.example.demo.dao;


import com.example.demo.util.md5;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="sms")
@Component
public class SMSInformation {

    private String protocol;
    private String host;
    private String websiturl;
    private String cmd;
    private String eprId;
    private String userId;
    private String password;
    private String msgId;
    private String format;


    private String timestamp;
    private String key;
    private String mobile;
    private String content;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getWebsiturl() {
        return websiturl;
    }

    public void setWebsiturl(String websiturl) {
        this.websiturl = websiturl;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getEprId() {
        return eprId;
    }

    public void setEprId(String eprId) {
        this.eprId = eprId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SMSInformation{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", websiturl='" + websiturl + '\'' +
                ", cmd='" + cmd + '\'' +
                ", eprId='" + eprId + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", msgId='" + msgId + '\'' +
                ", format='" + format + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", key='" + key + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String GetRequestURL(String mobile, String content ){
        String url = "";
        timestamp = String.valueOf(System.currentTimeMillis());
        key = md5.getMD5Str(eprId + userId + password + timestamp);
//        curl -x 10.0.71.26:8000  "http://qydx.53api.com/api/webservice?cmd=send&eprId=1926&userId=office_dept&key=839697D6421AA38506AD4322212EA9C3&timestamp=1539569984821&mobile=15338857709&msgId=10001&format=1&content=test01
        url = protocol + "://" + host + "/" + websiturl + "?cmd=" + cmd + "&eprId=" +
                eprId + "&userId=" + userId + "&key=" + key + "&timestamp=" +
                timestamp + "&mobile=" + mobile + "&msgId=" + msgId + "&format="+
                format + "&content=" + content;
        return url;
    }
}
