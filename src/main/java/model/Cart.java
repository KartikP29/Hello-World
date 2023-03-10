package model;

public class Cart {
	int uid;
	int pid;
	String pname;
	int pqty;
	String pprice;
	String pimg;
	
	public Cart() {
		
	}
	public Cart(int uid, int pid, String pname, int pqty, String pprice, String pimg) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pqty = pqty;
		this.pprice = pprice;
		this.pimg = pimg;
		this.uid = uid;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	@Override
	public String toString() {
		return "Cart [pid=" + pid + ", pname=" + pname + ", pqty=" + pqty + ", pprice=" + pprice + ", pimg=" + pimg
				+ "]";
	}
	
	

}
