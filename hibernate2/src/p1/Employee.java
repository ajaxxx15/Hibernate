package p1;

public class Employee {
	private int empid;
	private String ename;
	private EmpAddress addr;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public EmpAddress getAddr() {
		return addr;
	}

	public void setAddr(EmpAddress addr) {
		this.addr = addr;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
