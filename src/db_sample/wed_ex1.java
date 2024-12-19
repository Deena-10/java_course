package db_sample;
import java.sql.*;
import java.util.Scanner;
import java.lang.*;
public class wed_ex1 {
    int Account_number;
	int Balance;
    String Account_Holder_name;
    static Scanner s1=new Scanner(System.in);
	int accountIdToCheck;
	Connection connection=null;
	//private ResultSet resultSet;
	public wed_ex1() {
		String url="jdbc:mysql://localhost:3306/bank_sample";
     	String user="root";
     	String password="";
        try {
     		Class.forName("com.mysql.jdbc.Driver");
     		connection =DriverManager.getConnection(url,user,password);
     		//System.out.println("Connection Established");
     		}
     	catch (ClassNotFoundException e)
     		{
     			System.out.print("JDBC Driver not found!");
     			e.printStackTrace();
     		}
     	catch (SQLException e)
     		{
     			e.printStackTrace();
     		}
     	if (connection!=null)
     	{
     		System.out.println("Db connect");
     	}
     	else
     	{
     		System.out.println("db not connect");
     	}
	  }
     void fun() throws SQLException
        {
    	  System.out.println("1.Balance Enquiry ");
    	  System.out.println("2.Deposit Amount  ");
    	  System.out.println("3.Withdrawl Amount ");
    	  int n=s1.nextInt();
          System.out.println(" Enter account number ");
          accountIdToCheck=s1.nextInt();
          String sqlQuery = "SELECT Account_number FROM bank_ex1 WHERE Account_number = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
          preparedStatement.setInt(1,accountIdToCheck);          
          try (ResultSet resultSet = preparedStatement.executeQuery()) {
               if (resultSet.next()) {
                   System.out.println("Account Number " + accountIdToCheck + " exists.");
                } 
               else {
                      System.out.println("Account Number " + accountIdToCheck + " does not exist.");
                  }
              }
          
    	  switch(n) 
    	  {
    	  case 1:
    		 String query="SELECT * FROM bank_ex1 where Account_Number= ?";
    		 PreparedStatement preparedStatement1 = connection.prepareStatement(query);
             preparedStatement1.setInt(1,accountIdToCheck); 
             ResultSet resultSet1 = preparedStatement1.executeQuery();
      		 while(resultSet1.next()) 
      		 {
      			String Account_number=resultSet1.getString(1);
      			String Account_Holder_Name=resultSet1.getString(2);
      			String Balance=resultSet1.getString(3);
      			System.out.println("Account Number: "+accountIdToCheck);      			
      			System.out.println("Account Holder Name: "+Account_Holder_Name);
      			System.out.println("Balance: "+Balance);
      			break;
      		}
          break;
    	   case 2:
    		  System.out.println("Enter Amount to Deposit In Your Bank Account: ");
    		  int dep_amt=s1.nextInt();
    		  String updateQuery = "UPDATE bank_ex1 SET Balance = balance+ ? WHERE Account_Number = ?";
    		  PreparedStatement preparedStatement2 = connection.prepareStatement(updateQuery);
    		  preparedStatement2.setInt(1, dep_amt); // Set the new balance
    		  preparedStatement2.setInt(2, accountIdToCheck); // Set the account number
    		  int rowsAffected = preparedStatement2.executeUpdate();
    		  System.out.println(" Your Account Has Been Updated:   " + rowsAffected);
    		  String query33="SELECT * from bank_ex1 where Account_Number= ?";
     		  PreparedStatement preparedStatement12 = connection.prepareStatement(query33);
              preparedStatement12.setInt(1,accountIdToCheck); 
              ResultSet rs1 = preparedStatement12.executeQuery();
             while(rs1.next()) {
              System.out.println("Your current balance: "+rs1.getInt(3));
    		  break;
             }
    		 break;
    	  case 3:
    		  System.out.println(" Enter Withdrawl Amount: ");
    		  int wd_amt=s1.nextInt();
    		  String updatequery3="UPDATE bank_ex1 SET Balance= balance-? WHERE Account_Number=?";
    		  PreparedStatement p1=connection.prepareStatement(updatequery3);
     		  p1.setInt(1,wd_amt);
    		  p1.setInt(2,accountIdToCheck);
    		  int no_update=p1.executeUpdate();
    		  System.out.println(" Your Account Has been Updated: "+no_update);
    		  String query34="SELECT * from bank_ex1 where Account_Number= ?";				
    		  PreparedStatement p2=connection.prepareStatement(query34);			
    		  p2.setInt(1,accountIdToCheck);
    		  ResultSet r2=p2.executeQuery();
    		  while(r2.next())
    		  {
    			  System.out.println("Your Current Balance :"+r2.getInt(3));
    			  break;
    		  }
            break;
    		}
            }
      public static void main(String[] args) throws SQLException  {
    	 wed_ex1 ob1=new wed_ex1();
    	 ob1.fun();
    	 
 }
}




