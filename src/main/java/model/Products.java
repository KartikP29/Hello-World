package model;

public class Products {
	private
		int pid;
		String pname;
		String pprice;
		String pimg;
		public Products() {
		}
		public Products(int pid, String pname, String pprice, String pimg) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.pprice = pprice;
			this.pimg = pimg;
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
			return "Products [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pimg=" + pimg + "]";
		}
		
		
		

}
