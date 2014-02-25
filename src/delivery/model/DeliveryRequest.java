package delivery.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class DeliveryRequest {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Key key;
	
	@Persistent
	private Address from;
	
	@Persistent
	private Address to;
	
	@Persistent
	private Status status;
	
	@Persistent
	private Key service;
	
	@Persistent
	private Key sender;
	
	@Persistent
	private Key receiver;
	
	@Persistent
	private Key user;
	
	@Persistent
	private Date lastUpdate;
	
	
	@Persistent
	private Date insertDate;
	
	@PreUpdate
	public void preUpdate(){
		lastUpdate = new Date();
	}
	
	@PrePersist
	public void preInsert(){
		insertDate = new Date();
		lastUpdate = new Date();
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Key getUser() {
		return user;
	}

	public void setUser(Key user) {
		this.user = user;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}
