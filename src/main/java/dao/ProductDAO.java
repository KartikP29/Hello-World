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

import model.Products;

public class ProductDAO {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
     
    public ProductDAO (Connection con) {
        super();
        this.con = con;
    }
    public List<Products> getAllProducts() throws IOException {
    	List<Products> books = new ArrayList<>();
		try {
			query= "select * from products";
			pst = this.con.prepareStatement (query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Products row = new Products();
				row.setPid(rs.getInt("ProductID"));
				row.setPname(rs.getString("ProductName"));
				row.setPprice(rs.getString("ProductPrice"));
				row.setPimg(rs.getString("ProductImageSrc"));
				books.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return books;
    }
}
