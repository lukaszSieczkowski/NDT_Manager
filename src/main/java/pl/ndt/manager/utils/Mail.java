package pl.ndt.manager.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pl.ndt.manager.dto.EmployeeDTO;



public class Mail {

	/**
	 * Send email from configured account
	 * 
	 * @param userEmail
	 *            User email address.
	 * @param mailContent
	 *            Email content.
	 * @param subject
	 *            Email subject
	 */
	public void sendMail(String userEmail, String mailContent, String subject) {

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("incidents.rep@gmail.com", "Incidents!1");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("incidents.rep@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject(subject);
			message.setText(mailContent);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Prepares content for email informing about new user
	 * 
	 * @param  employeeDTO
	 *            Data transfer object;
	 * @param password
	 *            New user password
	 * @return Mail content.
	 */

	public String prepareContentNewUser(EmployeeDTO employeeDTO, String password) {
		String mailContent = "Dear " +employeeDTO.getFirstName()+" "+employeeDTO.getLastName()+"\n\n"
				+ "Your account in NDT Manager was created successfuly\n\n"
				+ "Your login: " + employeeDTO.getEmail() + ",\n\n" + "Your password: " + password + "\n\n"
				+ "Your role in NDT Manager is : " + employeeDTO.getRole().getValue() + "\n\n"
				+ "When you login to your account, you can change your password\n\n" + "Kind Regards\n\n"
				+ "NDT Manager";
		return mailContent;
	}

	
	/**
	 * Prepares subject for email about new user.
	 * 
	 * @return Email subject.
	 */
	public String prepareSubjectNewUser() {
		String subject = "New Account in NDT Manager";
		return subject;
	}

	
}
