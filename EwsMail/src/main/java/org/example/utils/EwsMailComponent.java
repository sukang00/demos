package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
@Component
public class EwsMailComponent {

    @Value("${ews.serverHost}")
    private String serverHost;

    @Value("${ews.domainAccount}")
    private String domainAccount;

    @Value("${ews.account}")
    private String account;

    @Value("${ews.password}")
    private String password;

    /**
     * 邮件内容类型 html
     */
    private final int MAIL_BODY_TYPE_HTML = 0;

    /**
     * 邮件内容类型 文本
     */
    private final int MAIL_BODY_TYPE_TEXT = 1;


    /**
     * 单个发送 不带抄送及附件邮件
     *
     * @param subject   主题
     * @param recipient 收件人
     * @param content   内容
     * @param bodyType  体型
     * @throws Exception 应用程序异常
     */
    public void sendSingle(String subject,String recipient,String content,int bodyType)throws Exception{
        List<String> recipients=new ArrayList<>();
        recipients.add(recipient);
        send( subject, recipients, null,bodyType, content,null);
    }



    /**
     * 发送 不带附件 不抄送的邮件
     *
     * @param subject    主题
     * @param recipients 收件人
     * @param content    内容
     * @param bodyType   邮件类型 0-html 1-文本
     * @throws Exception 异常
     */
    public void send(String subject,List<String> recipients,String content, int bodyType) throws Exception {
        send( subject, recipients, null,bodyType, content,null);
    }

    /**
     * 发送 带附件 不抄送的邮件
     *
     * @param subject    主题
     * @param recipients 收件人
     * @param ccs        抄送人
     * @param content    内容
     * @param bodyType   邮件类型 0-html 1-文本
     * @throws Exception 异常
     */
    public void send(String subject,List<String> recipients, List<String> ccs,String content, int bodyType) throws Exception {
        send( subject, recipients, ccs,bodyType, content,null);
    }

    /**
     * 发送
     *
     * @param subject         主题
     * @param recipients      收件人
     * @param ccs             抄送人
     * @param bodyType        邮件类型 0-html 1-文本
     * @param content         内容
     * @param attachmentPaths 附件的路径
     * @throws Exception 应用程序异常
     */
    public void send(String subject, List<String> recipients, List<String> ccs, int bodyType,
                     String content, List<String> attachmentPaths) throws Exception {
        ExchangeService service = initExchangeService();
        try {
            EmailMessage msg = new EmailMessage(service);
            msg.setSubject(subject);
            MessageBody body = MessageBody.getMessageBodyFromText(content);
            if (MAIL_BODY_TYPE_HTML == bodyType) {
                body.setBodyType(BodyType.HTML);
            }
            if (MAIL_BODY_TYPE_TEXT == bodyType) {
                body.setBodyType(BodyType.Text);
            }
            msg.setBody(body);
            for (String recipient : recipients) {
                msg.getToRecipients().add(recipient);
            }
            if (Objects.nonNull(ccs)) {
                for (String cc : ccs) {
                    msg.getCcRecipients().add(cc);
                }
            }
            if (Objects.nonNull(attachmentPaths)) {
                for (String attachmentPath : attachmentPaths) {
                    msg.getAttachments().addFileAttachment(attachmentPath);
                }
            }
            msg.send();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception("mail.send.fail");
        }
    }


    /**
     * 初始化邮件服务器
     *
     * @return {@link ExchangeService}
     */
    private ExchangeService initExchangeService() throws Exception {
        ExchangeService service = new ExchangeServiceWithHostVerify(ExchangeVersion.Exchange2007_SP1);
        //用户认证信息
        ExchangeCredentials credentials = null;
        if (StringUtils.isBlank(domainAccount)) {
            credentials = new WebCredentials(account, password);
        } else {
            credentials = new WebCredentials(account, password, domainAccount);
        }
        service.setCredentials(credentials);
        try {
            service.setUrl(new URI(serverHost));
        } catch (URISyntaxException e) {
            log.error(e.getMessage(), e);
            throw new Exception("mail.send.fail");
        }
        return service;
    }
}
