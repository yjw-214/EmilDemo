package cn.yxw.em;
import com.sun.org.apache.xpath.internal.objects.XNull;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class wwwww {
    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //  对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。  ps :myEmailPassword
    public static final String myEmailAccount="2729033658@qq.com";
    public static final String myEmailPassword="lvymzpirqresdeha";
    public static final String myEmailUserName="姚小伟";
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // qq邮箱的 SMTP 服务器地址为: smtp.qq.com  163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.qq.com";
    public static Thatpublic thatpublic = null;
    public static  Message msg = null;



    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
            thatpublic = new Thatpublic();
            thatpublic.setMyEmailPassword(myEmailPassword);
            thatpublic.setSendMail(myEmailAccount);
            thatpublic.setUserName(myEmailUserName);
            Scanner in =new Scanner(System.in);
             List<String> receivMail = new ArrayList<String>();
            System.out.println("请输入收件人的邮箱号! 您可以连续输入多个，输入n结束");

              while (true){
                  String sb = in.next();
                if(!sb.equals("n")){
                    receivMail.add(sb);
                    System.out.println("------------------------------------------------------");
                 }else{
                      break;
                 }
              }
            System.out.println("请输入邮箱的标题");
            String title = in.next();
            System.out.println("请输入邮箱内容");

            String content = in.next();
            thatpublic.setReceivMails(receivMail);
            thatpublic.setTitle(title);
            thatpublic.setContent(content);
        demo();
    }



    public static void demo() throws MessagingException, UnsupportedEncodingException {
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.auth", "true");
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.put("mail.smtp.host",myEmailSMTPHost);// smtp服务器地址
            Session session = Session.getInstance(prop);
          //  session.setDebug(true);  打印日志
            if(thatpublic.getReceivMails()!=null){
                Transport transport=null;
                for (String re : thatpublic.getReceivMails()) {
                    msg =  new MimeMessage(session);
                    msg.setSubject(thatpublic.getTitle()); // 这里是文章的标题
                    msg.setContent(thatpublic.getContent(),"text/html;charset=UTF-8"); //这里是文章的内容
                    msg.setSentDate(new Date());
                    /*msg.set*/
                    msg.setFrom(new InternetAddress(thatpublic.getSendMail(),thatpublic.getUserName(),"utf-8"));//发件人邮箱(我的163邮箱)
                    msg.setRecipient(Message.RecipientType.TO,
                            new InternetAddress(re));
                    transport = session.getTransport();
                    transport.connect(thatpublic.getSendMail(),thatpublic.getMyEmailPassword());//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)
                    transport.sendMessage(msg, msg.getAllRecipients());

                }
                transport.close();
            }else{
                System.out.println("失败");
            }
        }catch (Exception exception){
            System.out.println("出错了"+exception.getMessage());
            return;
        }finally {
            System.out.println("邮件发送成功...");
        }


    }
}
