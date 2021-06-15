//package email;
//
//import com.sun.mail.util.MailSSLSocketFactory;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.security.GeneralSecurityException;
//import java.util.Properties;
//
///**
// * @author SHI-HUA-LEI
// * @DATE 2020/7/31
// * @CLASSNAME
// * @description
// */
//public class SendEmail {
//    public static void main(String [] args)
//    {
//        // 收件人电子邮箱
//        String to = "786197897@qq.com";
//
//        // 发件人电子邮箱
//        String from = "2044772728@qq.com";
//
//        // // 指定发送邮件的主机为 smtp.qq.com
//        String host = "smtp.qq.com";
//
//        // 获取系统属性
//        Properties properties = System.getProperties();
//
//        // 设置邮件服务器
//        properties.setProperty("mail.smtp.host", host);
//
//        properties.put("mail.smtp.auth", "true");
//
//        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
//        MailSSLSocketFactory sf = null;
//        try {
//            sf = new MailSSLSocketFactory();
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//        sf.setTrustAllHosts(true);
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.ssl.socketFactory", sf);
//        // 获取默认session对象
//        Session session = Session.getDefaultInstance(properties,new Authenticator(){
//        @Override
//        public PasswordAuthentication getPasswordAuthentication()
//        {
//            return new PasswordAuthentication("2044772728@qq.com", "olwdjyhrkecmedic"); //发件人邮件用户名、授权码
//        }
//    });
//
//        try{
//            // 创建默认的 MimeMessage 对象
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: 头部头字段
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: 头部头字段
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//
//            // Set Subject: 头部头字段
//            message.setSubject("这是一封测试邮件");
//
////            // 设置消息体
////            message.setText("噘嘴大师你好");
//
//            // 创建消息部分
//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            // 消息
//            messageBodyPart.setText("附件没发出去吗？");
//
//            // 创建多重消息
//            Multipart multipart = new MimeMultipart();
//
//            // 设置文本消息部分
//            multipart.addBodyPart(messageBodyPart);
//
//            // 附件部分
////            messageBodyPart = new MimeBodyPart();
////            String filename = "C:OUT.txt";
////            DataSource source = new FileDataSource(filename);
////            messageBodyPart.setDataHandler(new DataHandler(source));
////            messageBodyPart.setFileName("你打开瞅瞅");
////            multipart.addBodyPart(messageBodyPart);
//
//            // 发送完整消息
//            message.setContent(multipart);
//
//            // 发送消息
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//}
