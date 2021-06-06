package servicio_email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modelo.Servicio;
import modelo.Venta;

//IMPLEMENTO OBSERVER
public class Email implements Servicio {

	public void enviar(Venta venta) {

		// remitente
		String to = venta.obtenerEmail();
		// destinatario
		String from = "from@example.com";

		// usuario y clave que se obtiene desde Mailtrap
		final String username = "f1c689c3288076";
		final String password = "dc1c98b9c5f891";

		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");// it’s optional in Mailtrap
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Compro combustible (factura)");
			message.setText(
					venta.obtenerfecha() + "," + venta.obtenerLitrosCargados() + "," + venta.obtenerMontoFactura());
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
