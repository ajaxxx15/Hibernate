package p1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.*;

public class HibernateManager {
	Session session;

	public void connect() {
		// Connection code
		// these 5 lines would remain same and is used for getting connection
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();
		System.out.println("Connected to Pf....");
	}

	// inserts a row into the table
	public void insert(Student s) {
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		System.out.println("Insertion success...");
	}

	// select entire row from the table
	public void select() {
		session.beginTransaction();
		Query q = session.createQuery("From Student");
		List l = q.list();
		Iterator itr = l.iterator();
		while (itr.hasNext() == true) {
			Student s = (Student) itr.next();
			System.out.println(s.getSid() + " " + s.getSname());

		}
	}

	// select a row from the table
	public void select(String sid) {
		session.beginTransaction();
		Query q = session.createQuery("From Student where sid=:sid");
		q.setString("sid", sid);
		List l = q.list();
		Iterator itr = l.iterator();
		while (itr.hasNext()) {
			Student s = (Student) itr.next();
			System.out.println(s.getSid() + " " + s.getSname());

		}
	}

	// update a row into the table
	public void update(String sid, String newName) {
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, sid);
		s.setSname(newName);
		session.update(s);
		session.getTransaction().commit();
	}

	// delete a row from the table
	public void delete(String sid) {
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, sid);
		session.delete(s);
		session.getTransaction().commit();
	}

}
