package device;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.Presence;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

public class XMPPReceiverServlet extends HttpServlet {
	private XMPPService service;

	@Override
	public void init() {
		this.service = XMPPServiceFactory.getXMPPService();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Message message = service.parseMessage(req);
		
		System.out.println(message.getMessageType());
//		processMessage(service.parseMessage(req), res);
	}
    
    public void processMessage(Message message, HttpServletResponse res) throws IOException {
		JID fromId = message.getFromJid();
		Presence presence = service.getPresence(fromId);
		String presenceString = presence.isAvailable() ? "" : "not ";
		SendResponse response = service.sendMessage(new MessageBuilder()
				.withBody(
						message.getBody() + " (you are " + presenceString
								+ "available)").withRecipientJids(fromId)
				.build());
		
		for (Map.Entry<JID, SendResponse.Status> entry : response
				.getStatusMap().entrySet()) {
			res.getWriter().println(
					entry.getKey() + "," + entry.getValue() + "<br>");
		}

		res.getWriter().println("processed");
	}
}
