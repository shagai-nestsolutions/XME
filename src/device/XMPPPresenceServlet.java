package device;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.xmpp.Subscription;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

public class XMPPPresenceServlet extends HttpServlet {

	private XMPPService service;

	@Override
	public void init() {
		this.service = XMPPServiceFactory.getXMPPService();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		XMPPService xmppService = XMPPServiceFactory.getXMPPService();
		Subscription sub = xmppService.parseSubscription(req);

		
		System.out.println(sub.getToJid());
//		processMessage(service.parseMessage(req), res);
	}
}
