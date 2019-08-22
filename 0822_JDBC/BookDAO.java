

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BookDAO {
	
	public Connection getConnection() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ws_0822?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;				
	}
	public void close(Connection connection) {
		try {
			if(connection!=null)connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(Statement statement) {
		try {
			if(statement!=null)statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(ResultSet resultSet) {
		try {
			if(resultSet!=null)resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertBook(Book book) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			String sql = "insert into Book(isbn,title,publisher,price,description,authorno) values(?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, book.getIsbn());
			st.setString(2, book.getTitle());			
			st.setString(3, book.getPublisher());
			st.setInt(4, book.getPrice());
			st.setString(5, book.getDescription());
			st.setInt(6, book.getAuthorno());
			int ret = st.executeUpdate();
			if( ret == 1)
				System.out.println("입력성공~");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
		}
		
	}
	public void updateBook(Book book) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			//isbn,title,author,publisher,price,description
			String sql = "update Book set title = ?, publisher = ?,price = ?,description = ? where isbn = ?";
			st = conn.prepareStatement(sql);			
			st.setString(1, book.getTitle());			
			st.setString(2, book.getPublisher());
			st.setInt(3, book.getPrice());
			st.setString(4, book.getDescription());
			st.setString(5, book.getIsbn());
			int ret = st.executeUpdate();
			if(ret == 1)
			{
				System.out.println("변경 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
		}
	}
	public void deleteBook(String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			String sql = "delete from Book where isbn = ?";
			st = conn.prepareStatement(sql);			
			st.setString(1, isbn);			
			int ret = st.executeUpdate();
			if(ret == 1)
			{
				System.out.println("지우기 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
		}
	}
	public Book findBook(String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = getConnection();
			String sql = "select * from Book where isbn = ?";
			st = conn.prepareStatement(sql);			
			st.setString(1, isbn);			
			rs = st.executeQuery();
			
			rs.next();
			book = new Book();
			book.setIsbn(rs.getString("isbn"));
			book.setTitle(rs.getString("title"));			
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getInt("price"));
			book.setDescription(rs.getString("description"));
			book.setAuthorno(rs.getInt("authorno"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}
		return book;
	}
	
	public Book findName(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = getConnection();
			String sql = "select b.title,b.isbn,b.publisher from book b,author a where a.name = ? and a.authorno = b.authorno";
			st = conn.prepareStatement(sql);			
			st.setString(1, name);			
			rs = st.executeQuery();
			
			rs.next();
			book = new Book();			
			book.setTitle(rs.getString("title"));
			book.setIsbn(rs.getString("isbn"));
			book.setPublisher(rs.getString("publisher"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}
		return book;
	}
	
	public ArrayList<Book> findalladdname()
	{
		ArrayList<Book> list = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select b.title,b.publisher,b.price,a.name from book b,author a where a.authorno = b.authorno";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();				
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setName(rs.getString("name"));				
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}		
		return list;
	}
	
	public ArrayList<Book> find_join()
	{
		ArrayList<Book> list = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select b.title,b.price,a.name from book b,author a where b.authorno = a.authorno";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();				
				book.setTitle(rs.getString("title"));							
				book.setPrice(rs.getInt("price"));
				book.setName(rs.getString("name"));				
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}		
		return list;
	}
	
	public ArrayList<Book> listBooks() {
		ArrayList<Book> list = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from Book";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));				
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				book.setAuthorno(rs.getInt("authorno"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}		
		return list;
	}
	public int count() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = getConnection();
			String sql = "select count(isbn) as count from Book";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			ret = rs.getInt("count");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn);
			close(st);
			close(rs);
		}
		return ret;
	}
	
}
