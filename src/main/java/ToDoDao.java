
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.transaction.Transactional;

public class ToDoDao {
	
	@SuppressWarnings("deprecation")
	@Transactional
	public void saveItem(ToDoItem item) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(item);
		transaction.commit();
		session.close();//
	}
	
	public List<ToDoItem> showAllTasks() {
		List<ToDoItem> list = new ArrayList<ToDoItem>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings({ "deprecation", "unchecked" })
		Query<ToDoItem> query = session.createQuery("From ToDoList");
		list = query.list();
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public void updateItem(ToDoItem newItem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ToDoItem oldItem = (ToDoItem)session.load(ToDoItem.class, newItem.getId());
		oldItem.setTask(newItem.getTask());
		session.merge(oldItem);
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("deprecation")
	public void deleteItem(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ToDoItem item = (ToDoItem)session.load(ToDoItem.class, id);
		session.delete(item);
		transaction.commit();
		session.close();
	}
}
