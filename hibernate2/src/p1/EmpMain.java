package p1;

/**
 * One-to-One Mapping
 *
 */
public class EmpMain {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setEname("Rohit");

		EmpAddress empaddr = new EmpAddress();
		empaddr.setDno(21);
		empaddr.setLane("1st Cross");
		empaddr.setCity("BLR");
		empaddr.setState("Karnataka");
		empaddr.setCountry("India");

		e.setAddr(empaddr);

		HibernateManager hm = new HibernateManager();
		hm.connect();
		hm.insert(e);
	}

}
