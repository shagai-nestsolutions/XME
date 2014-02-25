package device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import util.DBAccess;
import util.Message;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

import delivery.facebook.FacadeUser;
import delivery.facebook.FacebookUser;

@Api(name = "device")
public class DeviceAPI {

	private static FacadeUser facadeUser = new FacadeUser();
	private static char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
	@ApiMethod(name = "subscribe")
	public Message subscribe(@Named("id")Long id, @Named("code")String code) {
		Device device = DBAccess.findObjectById(id, Device.class);
		if (device == null || !code.equals(device.getCode())){
			return new Message().addField("message", "Invalid id or activation code");
		}
		return new Message().addField("message", "success").addField("status", "ACCEPTED").addField("id", device.getKey().getId());
	}
	
	@ApiMethod(name = "update.location")
	public Message sendLocation(@Named("id")Long id, Location location) {
		Device device = DBAccess.findObjectById(id, Device.class);
		if (device == null){
			return new Message().addField("message", "Invalid device id");
		}
		location.setOwner(device.getKey());
		location = DBAccess.save(location);
		return new Message().addField("message", "success").addField("location", location);
	}
	
	private static String getRandomString(){
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
		    builder.append(chars[random.nextInt(chars.length)]);
		}
		return builder.toString();
	}
	
	@ApiMethod(name = "register")
	public Message register(@Named("token")String token, Device device) {
		FacebookUser user = facadeUser.getUser(token);
		if (user == null){
			return new Message().addField("message", "Invalid token");
		}
		device.setCode(getRandomString());
		device.setOwner(user.getKey());
		device = DBAccess.save(device);
		return new Message().addField("message", "success").addField("device", device);
	}
	
	@ApiMethod(name = "device.delete")
	public Message delete(@Named("token")String token, @Named("id")Long id) {
		FacebookUser user = facadeUser.getUser(token);
		if (user == null){
			return new Message().addField("message", "Invalid token or device id");
		}
		Device device = DBAccess.findObjectById(id, Device.class);
		if (device == null){
			return new Message().addField("message", "Invalid token or device id");
		}
		if (!device.getOwner().equals(user.getKey())){
			return new Message().addField("message", "Invalid token or device id");
		}
		DBAccess.delete(id, Device.class);
		return new Message().addField("message", "success");
	}
	
	@ApiMethod(name = "device.list")
	public Message getAll(@Named("token")String token) {
		FacebookUser user = facadeUser.getUser(token);
		if (user == null){
			return new Message().addField("message", "Invalid token or device id");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", user.getKey());
		List<Device> devices = DBAccess.findFilter(Device.class, "key desc", "owner == id", param);
		return new Message().addField("message", "success").addField("devices", devices);
	}
	
	@ApiMethod(name = "refresh.activation")
	public Message refreshActivation(@Named("token")String token, @Named("id")Long id) {
		FacebookUser user = facadeUser.getUser(token);
		if (user == null){
			return new Message().addField("message", "Invalid token or device id");
		}
		Device device = DBAccess.findObjectById(id, Device.class);
		if (device == null){
			return new Message().addField("message", "Invalid token or device id");
		}
		if (!device.getOwner().equals(user.getKey())){
			return new Message().addField("message", "Invalid token or device id");
		}
		device.setCode(getRandomString());
		device = DBAccess.save(device);
		return new Message().addField("message", "success").addField("device", device);
	}
	
}
