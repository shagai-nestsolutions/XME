package delivery.model;

import java.util.Date;

import util.Message;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(name = "shipment")
public class RequestAPI {
	@ApiMethod(name = "create")
	public Message createDeliveryRequest(Message message) {
		return new Message().addField("message", "success").addField("time", new Date());
	}
}
