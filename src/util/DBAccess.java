package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.google.appengine.api.utils.SystemProperty;

public class DBAccess {
	public static PersistenceManagerFactory getFactory() {
		Map<String, String> properties = new HashMap<String, String>();
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.GoogleDriver");
			properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url"));
		} else {
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url.dev"));
		}
		return JDOHelper.getPersistenceManagerFactory(properties, "transactions-optional");
	}

	public static void close(PersistenceManager manager, Transaction transaction) {
		if (transaction != null && transaction.isActive()) {
			transaction.commit();
		}
		if (manager != null && !manager.isClosed()) {
			manager.close();
		}
	}

	public static <T> T save(T object) {
		PersistenceManagerFactory factory = getFactory();
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction transaction = manager.currentTransaction();
		transaction.begin();
		try {
			return manager.makePersistent(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.close(manager, transaction);
		}
		return object;
	}

	public static <T> T update(T object) {
		PersistenceManagerFactory factory = getFactory();
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction transaction = manager.currentTransaction();
		transaction.begin();
		try {
			return manager.detachCopy(object);
		} finally {
			DBAccess.close(manager, transaction);
		}
	}

	public static <T> void delete(Object key, Class<T> type) {
		PersistenceManagerFactory factory = getFactory();
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction transaction = manager.currentTransaction();
		transaction.begin();
		try {
			manager.deletePersistent(manager.getObjectById(type, key));
		} finally {
			DBAccess.close(manager, transaction);
		}
	}

	public static <T> T findObjectById(Object key, Class<T> type) {
		PersistenceManagerFactory factory = getFactory();
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction transaction = manager.currentTransaction();
		transaction.begin();
		try {
			return manager.getObjectById(type, key);
		} catch (Exception e) {
			return null;
		} finally {
			DBAccess.close(manager, transaction);
		}
	}

	public static <T> List<T> findFilter(Class<T> type, String order,
			String filter, Map<String, Object> params) {
		PersistenceManagerFactory factory = getFactory();
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction transaction = manager.currentTransaction();
		transaction.begin();
		try {
			Query query = manager.newQuery(type);
			query.setFilter(filter);
			Set<String> classes = new HashSet<String>();
			for (String key : params.keySet()) {
				classes.add(params.get(key).getClass().getName());
				query.declareParameters(params.get(key).getClass().getName()
						+ " " + key);
			}
			for (String c : classes) {
				query.declareImports("import " + c);
			}
			query.setOrdering(order);
			return new ArrayList<T>((List<T>) query.executeWithMap(params));
		} finally {
			DBAccess.close(manager, transaction);
		}
	}

	public static <T> List<T> findFilter(Class<T> type, String order,
			String filter) {
		return findFilter(type, order, filter, new HashMap<String, Object>());
	}

	public static <T> T findObject(Class<T> type, String order, String filter,
			Map<String, Object> map) {
		List<T> list = findFilter(type, order, filter, map);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	public static <T> T findObject(Class<T> type, String order, String filter) {
		return findObject(type, order, filter, new HashMap<String, Object>());
	}
}
