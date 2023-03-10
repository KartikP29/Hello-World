package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import model.Cart;
import model.Products;

public class CartDAO {
	private Connection con;
	private String query;
	private String query2;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private ResultSet rs;
	private ResultSet rs1;
	
	public CartDAO(Connection con) {

		this.con = con;
	}

//function to get values from product table via product id
	public Products addProduct(int pid) throws IOException {
		Products product = null;
		try {
			query = "select * from products where ProductID=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if (rs.next()) {
				product = new Products();
				product.setPid(rs.getInt("ProductID"));
				product.setPname(rs.getString("ProductName"));
				product.setPprice(rs.getString("ProductPrice"));
				product.setPimg(rs.getString("ProductImageSrc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(product);
		return product;
	}

//function to transfer the values into cart table
	public boolean addToCart(Products p) {
		String INSERT_CART = "INSERT INTO cart" + " (c_uid, ProductID, ProductName, ProductPrice, ProductImageSrc) VALUES " + " (?, ?, ?, ?, ?);";
		try {
			Cart c = new Cart();
			pst = this.con.prepareStatement(INSERT_CART);
			pst.setInt(1, c.getUid());
			pst.setInt(2, p.getPid());
			pst.setString(3, p.getPname());
			pst.setString(4, p.getPprice());
			pst.setString(5, p.getPimg());
			System.out.println(pst);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}

////function to display the values in cart table via list
	public List<Cart> cartDisplay() throws IOException {
		Cart item = null;
		List<Cart> cartlist = new ArrayList<>();
		try {
			query = "select * from cart";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				item = new Cart();
				item.setUid(rs.getInt("c_uid"));
				item.setPid(rs.getInt("ProductID"));
				item.setPname(rs.getString("ProductName"));
				item.setPprice(rs.getString("ProductPrice"));
				item.setPimg(rs.getString("ProductImageSrc"));
		
				cartlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartlist;
	}

//function to remove the values from cart table
	public void removeFromCart(int pid) {
		try {
			query = "delete from cart where c_uid="+pid;
			pst = this.con.prepareStatement(query);
			//pst.setInt(1, pid);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cart> Display() throws SQLException{
		List<Cart> cartlist = new ArrayList<>();
		Cart it = null;
		try {
			
			query=" SELECT MAX(c_uid), count(c_uid) as total,sum(ProductPrice) as po, ProductName, max(ProductImageSrc) as pi from cart group by ProductName; ";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			
		
			while(rs.next()){
				it=new Cart();
				it.setPimg(rs.getString("pi"));
				it.setUid(rs.getInt("max(c_uid)"));
				it.setPqty(rs.getInt("total"));
				it.setPprice(rs.getString("po"));
				it.setPname(rs.getString("ProductName"));
				
				cartlist.add(it);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return cartlist;
		
	}

}
