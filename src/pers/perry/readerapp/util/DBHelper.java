package pers.perry.readerapp.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {

	private static final Log log = LogFactory.getLog(DBHelper.class);
	private static SessionFactory sessionFactory;
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static Session getCurrentSession() {
		// session一定要给每个Dao独立的对象,不能共用一个
		// Session s = session.get();
		// if (s == null) {
		// s = sessionFactory.openSession();
		// session.set(s);
		// }
		Session s = sessionFactory.openSession();
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null) {
			s.close();
		}
		session.set(null);
	}

}
