import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class that interfaces with a local MySQL database for use with the ToDoItem class
 * @author Sam
 *
 */
public class HibernateUtil {
	
	private static final SessionFactory sf;
	
	static {
		try {
			sf = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}