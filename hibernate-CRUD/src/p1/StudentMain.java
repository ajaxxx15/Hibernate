package p1;

/**
 * Create Read Update Delete code. 
 * Nested Transaction is not allowed.
 *
 */
public class StudentMain {

	public static void main(String[] args) {

		Student s = new Student();

		s.setSid("3");
		s.setSname("XYZ3");

		// insert into DB
		HibernateManager hm = new HibernateManager();
		hm.connect();

		// insert into DB
		hm.insert(s);

		// select from DB
		hm.select();

		// select from DB by Student ID
		hm.select("2");

		// Update Name in DB
		hm.update("3", "XYZ2");

		// Delete from DB
		hm.delete("3");
	}

}
