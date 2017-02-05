package pl.mariuszczarny.hibernateSample.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mariusz
 */
public class HibernateUtil {
	private static final Logger logger = LoggerFactory.getLogger(GenericExtendedDao.class);
	   
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

        }
        catch (Throwable ex) {
        	logger.warn("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	getSessionFactory().close();
    }

}
