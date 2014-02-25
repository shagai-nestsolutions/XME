package device;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Location implements Serializable{
	private static final long serialVersionUID = 4334716361923858179L;

	@Persistent
	private double longitude;
	
	@Persistent
	private double altitude;
	
	@Persistent
	private Key owner;

	
	public Location() {
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public Key getOwner() {
		return owner;
	}

	public void setOwner(Key owner) {
		this.owner = owner;
	}
	
	
}
