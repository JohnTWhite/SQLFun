package add_to_table;

import java.sql.*; 

import com.mysql.jdbc.Statement;

public class add_to_table {
	
	//my information to log into db
	private static String user_name = "ninjerman";
	private static String password = "G";
	
	/*
	 * title of table will be what we name the table 
	 * that we are generating. 
	 */

	//our host
	private static String url = "jdbc:mysql://localhost:3306/Zipf";
	//our connection
	private static Connection connection;
	//our SQL statement.
	private static java.sql.Statement statement;
	//result set in case we return any values
	private static ResultSet resultSet;
	
	

	public add_to_table() {
		super();

		

		try{
			System.out.println("Intial strings compiled");
			connection = DriverManager.getConnection(url, user_name, password);
			System.out.println("connection worked");
			statement = connection.createStatement();
			System.out.println("statement created");
			statement.execute(sql_statement());
			System.out.println("statement worked");
			resultSet = statement.getResultSet();
		}catch(SQLException e){
			System.out.println("This broke: ");
			e.printStackTrace();
		}

		
		//if there is a result set this will output that info
		try {
			while(resultSet.next()){
				System.out.println(resultSet.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("This broke when getting RS: ");
			e.printStackTrace();
		}
	}
		
	


	public String sql_statement(){
		
//		String ultimate = "INSERT INTO titles(title, author_first,author_last,genere, fiction)"
//				+ " VALUES('place holder', 'john', 'white','comedy','fictitious');";
		
		String ultimate = "SELECT title FROM titles WHERE author_first = 'john';";

		
		return ultimate;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		add_to_table execute = new add_to_table();
	}

}