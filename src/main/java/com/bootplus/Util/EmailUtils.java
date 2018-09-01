package com.bootplus.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
/**
 * 发送邮件的例子
 * 需要增加属性配置
 * # JavaMailSender email send config
spring.mail.host=smtp.163.com
spring.mail.username=xxx@163.com	
#这个密码不是邮箱登陆密码，而是授权码，需要到邮箱中设置获取第三方授权码
spring.mail.password=xxxxxxxx
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
 * @author angle
 *
 */
public class EmailUtils {

    // 获取JavaMailSender bean
    @Autowired
    private JavaMailSender javaMailSender;
 
    // 获取配置文件的username
    @Value("${spring.mail.username}")
    private String username;
 
    /**
     * 一个简单的邮件发送
     */
    public void sendSimpleMail1(){
        SimpleMailMessage message = new SimpleMailMessage();
           // 设定邮件参数
           message.setFrom(username); //发送者
           message.setTo("61106163@qq.com"); //接受者
           message.setSubject("主题:邮件"); //主题
           message.setText("邮件内容"); //邮件内容
 
           // 发送邮件
           javaMailSender.send(message);
    }
}
