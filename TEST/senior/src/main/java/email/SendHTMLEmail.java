//package email;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
///**
// * @author SHI-HUA-LEI
// * @DATE 2020/7/31
// * @CLASSNAME
// * @description
// */
//public class SendHTMLEmail {
//    public static void main(String[] args) {
//        // 收件人电子邮箱
//        String to = "1325381059@qq.com";
//
//        // 发件人电子邮箱
//        String from = "2044772728@qq.com";
//
//        // 指定发送邮件的主机为 localhost
//        String host = "localhost";
//
////        获取系统属性
//        Properties properties = System.getProperties();
////        设置邮件服务器
//        properties.setProperty("smtp.exmail.qq.com",host);
//        // 获取默认的 Session 对象。
//        Session session = Session.getDefaultInstance(properties);
//        // 创建默认的 MimeMessage 对象。
//        MimeMessage message = new MimeMessage(session);
//        // Set From: 头部头字段
//        try {
//            message.setFrom(new InternetAddress(from));
//            // Set To: 头部头字段
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//
//            // Set Subject: 头字段
//            message.setSubject("This is the Subject Line!");
//
//            // 发送 HTML 消息, 可以插入html标签
//            message.setContent("<h1>This is actual message</h1>",
//                    "text/html" );
//
//            // 发送消息
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//}
