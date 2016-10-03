package Create_Table_LocalSQL;

import java.sql.*; 

import com.mysql.jdbc.Statement;

public class Create_Table {
	
	//my information to log into db
	private static String user_name = "ninjerman";
	private static String password = "Great1";
	
	/*
	 * title of table will be what we name the table 
	 * that we are generating. 
	 */
	private static String title_of_table;
	//our host
	private static String url = "jdbc:mysql://localhost:3306/ZIPF";
	//our connection
	private static Connection connection;
	//our SQL statement.
	private static java.sql.Statement statement;
	//result set in case we return any values
	private static ResultSet resultSet;
	
	

	public Create_Table(String title_of_table) {
		super();
		this.title_of_table = title_of_table;
		
		String title = "";
		

		try{
			System.out.println("Intial strings compiled");
			connection = DriverManager.getConnection(url, user_name, password);
			System.out.println("connection worked");
			statement = connection.createStatement();
			System.out.println("statement created");
			statement.execute(sql_statement(title));
			System.out.println("statement worked");
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
		
	


	public String sql_statement(String table){
		
		String ultimate = "CREATE TABLE TITLES (`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255) NOT NULL,author_first_name VARCHAR(255) NOT NULL,author_last_name VARCHAR(255) NOT NULL,genere VARCHAR(255) ,fiction VARCHAR(255));";
		
		return ultimate;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		Create_Table execute = new Create_Table("ZIPF");
	}

}
