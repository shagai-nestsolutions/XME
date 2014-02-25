package delivery.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ContactInfo {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Key key;
}
