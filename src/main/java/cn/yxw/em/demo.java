package cn.yxw.em;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class demo {
























































































    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //  对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。  ps :myEmailPassword
    /*public static final String myEmailAccount="2729033658@qq.com";
    public static final String myEmailPassword="lvymzpirqresdeha";
    public static final String myEmailUserName="姚小伟";
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // qq邮箱的 SMTP 服务器地址为: smtp.qq.com  163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.qq.com";
    public static Thatpublic thatpublic = null;
    public static List<String> receivMail = null;

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        Scanner in =new Scanner(System.in);
        receivMail =new ArrayList<String>();
        System.out.println("请输入收件人的邮箱号! 您可以连续输入多个，输入n结束");
        String sb = in.next();
        while (true){
            if(!sb.equals("n")){
                receivMail.add(sb);
            }else{
                break;
            }
        }
        System.out.println("请输入邮箱的标题");
        String title = in.next();
        System.out.println("请输入邮箱内容");
        String content = in.next();
        thatpublic = new Thatpublic(myEmailAccount,receivMail,myEmailUserName
        ,title,content,myEmailPassword);
        demo(thatpublic);
    }

*/
/*
   public static void demo(Thatpublic thatpublic) throws MessagingException, UnsupportedEncodingException {
*/
/*

       Properties prop = new Properties();                  //   用于连接邮件服务器（发送邮件是 需要用到）
       Session session =Session.getInstance(prop);          //  根据参数配置，创建会话对象。(为了发邮件准备)
       MimeMessage message = new MimeMessage(session);      //  创建邮件对象
*//*


       */
/***
        * 也可以根据已有的 eml 邮件文件创建MimeMessage  对象
        * MimeMessage message = new MimeMessage(session,new FileInputStream(""))
        *
        *//*

       Properties prop = new Properties();
       prop.setProperty("mail.smtp.auth", "true");
       prop.setProperty("mail.transport.protocol", "smtp");
       prop.put("mail.smtp.host",myEmailSMTPHost);// smtp服务器地址
       */
/* PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
           如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
           取消下面 *//*
*/
/* ... *//*
*/
/* 之间的注释代码, 开启 SSL 安全连接。*//*

        */
/*
         SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
                         需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
                         QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
*//*

       Session session = Session.getInstance(prop);
     */
/*  //session.setDebug(true);
       Message msg = createMimeMessage(thatpublic);
       msg.setSubject(Title); // 这里是文章的标题
       //msg.setText(Content); //这里是文章的内容
       msg.setContent(Content,"text/html;charset=UTF-8");
       msg.setSentDate(new Date());


       msg.setFrom(new InternetAddress("2729033658@qq.com","姚小伟","UTF-8"));//发件人邮箱(我的163邮箱)
       msg.setRecipient(Message.RecipientType.TO,
               new InternetAddress(sb)); //收件人邮箱(我的QQ邮箱)
       msg.saveChanges();*//*

       thatpublic.setSession(session);

       Message msg = createMimeMessage(thatpublic);
       Transport transport = session.getTransport();
       transport.connect(thatpublic.getSendMail(),myEmailPassword);//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)
       transport.sendMessage(msg, msg.getAllRecipients());
      // transport.getURLName();
       System.out.println("邮件发送成功..."+transport.getURLName());
       transport.close();
   }

*/





   /*// 创建自己的Message
    public static MimeMessage createMimeMessage(Thatpublic thatpublic) throws UnsupportedEncodingException, MessagingException {
        MimeMessage msg = new MimeMessage(thatpublic.getSession());

        for (String s : thatpublic.getReceivMail()) {
            msg.setSubject(thatpublic.getTitle()); // 这里是文章的标题
            //msg.setText(Content); //这里是文章的内容
            msg.setContent(thatpublic.getContent(),"text/html;charset=UTF-8");
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(thatpublic.getSendMail(),thatpublic.getUserName(),"utf-8"));
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(s));
            msg.saveChanges();

        }

            return msg;


    }*/
}
