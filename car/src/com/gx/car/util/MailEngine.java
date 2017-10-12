package com.gx.car.util;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailEngine {
	protected static final Log log = LogFactory.getLog(MailEngine.class);
	@Resource
	private MailSender mailSender;

	/**
	 * 
	 * 
	 * @param emailAddress
	 *            收件人地址
	 * @param fromEmail
	 *            发送人邮箱
	 * @param bodyText
	 *            发送内容
	 * @param subject
	 *            发送的题目
	 * @param attachmentName
	 *          附件名字
	 * @param resource
	 *           资源
	 * @throws MessagingException
	 */
	public void sendMessage(String[] emailAddresses, String fromEmail, String bodyText, String subject, String attachmentName, ClassPathResource resource) throws MessagingException {
		MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(emailAddresses);
		if (fromEmail != null) {
			helper.setFrom(fromEmail);
		}
		helper.setText(bodyText);
		helper.setSubject(subject);

		if (attachmentName != null && resource != null)
			helper.addAttachment(attachmentName, resource);

		((JavaMailSenderImpl) mailSender).send(message);
	}

	/**
	 
	 * 
	 * @param msg
	 *//*
	public void send(SimpleMailMessage msg) {
		try {
			((JavaMailSenderImpl) mailSender).send(msg);
		} catch (MailException ex) {
			// log it and go on
			log.error(ex.getMessage());
		}
	}

*/
}