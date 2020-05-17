package cn.yxw.em;

import javax.mail.Session;
import java.util.List;

public class Thatpublic {
    private Session session;
    private  String  sendMail;
    private String receivMail;
    private List<String> receivMails;
    private  String UserName;
    private  String Title;
    private  String Content;
    private  String myEmailPassword;

    public void setReceivMail(String receivMail) {
        this.receivMail = receivMail;
    }

    public List<String> getReceivMails() {
        return receivMails;
    }

    public void setReceivMails(List<String> receivMails) {
        this.receivMails = receivMails;
    }

    public Thatpublic() {
    }

    public String getReceivMail() {
        return receivMail;
    }

    public Thatpublic(Session session, String sendMail, List<String> receivMails, String userName, String title, String content, String myEmailPassword) {
        this.session = session;
        this.sendMail = sendMail;
        this.receivMails = receivMails;
        UserName = userName;
        Title = title;
        Content = content;
        this.myEmailPassword = myEmailPassword;
    }
    public Thatpublic(String sendMail, List<String> receivMails, String userName, String title, String content, String myEmailPassword) {
        this.sendMail = sendMail;
        this.receivMails = receivMails;
        UserName = userName;
        Title = title;
        Content = content;
        this.myEmailPassword = myEmailPassword;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }



    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMyEmailPassword() {
        return myEmailPassword;
    }

    public void setMyEmailPassword(String myEmailPassword) {
        this.myEmailPassword = myEmailPassword;
    }
}
