package db_sample;
import java.sql.*;
import java.util.Scanner;
import java.lang.*;
public class wed_ex2 {
    int Account_number,Balance;
    String Account_Holder_name;
    Scanner s1=new Scanner(System.in);
	private Object option;
    void fun()
    {
      System.out.println("Enter Account Number: ");
      Account_number=s1.nextInt();
      if(Account_number==75400||Account_number== 0066){
    	  System.out.println("Welcome");
    	  System.out.println("1.Balance Enquiry ");
    	  System.out.println("2.Deposit Amount  ");
    	  System.out.println("3.Withdrawl Amount ");
    	  int n=s1.nextInt();
    	  switch(n) {
    	  case 1:
    		  System.out.println("Your Account Balance: ");
    		  System.out.println(Balance);
    	  case 2:
    		  System.out.println("Deposit Amount: ");
    		  int amt=s1.nextInt();
    		  Balance=Balance+amt;
    		  System.out.println("Your Balance "+ Balance);
    	  case 3:
    		  System.out.println("Withdrawl Amount: ");
    		  int wamt=s1.nextInt();
    		  Balance=Balance-wamt;
    		  System.out.print("Balance after Withdrawl: "+ Balance);
    		}
            }
          else {
    	  System.out.print("Enter correct account number");
              }
       }
     public static void main(String[] args)  {
//    	 wed_ex1 ob1=new wed_ex1();
//    	 ob1.fun();
    	String url="jdbc:mysql://localhost:3306/bank_sample";
    	String user="root";
    	String password="";
    	Connection connection=null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection =DriverManager.getConnection(url,user,password);
    		System.out.println("Connection Established");
    		String query="SELECT * FROM bank_ex1";
    		Statement statement=connection.createStatement();
    		ResultSet resultset=statement.executeQuery(query);
    		while(resultset.next()) 
    		{
    			int Account_number=resultset.getInt(1);
    			String Account_Holder_Name=resultset.getString("Account_Holder_name");
    				int Balance=resultset.getInt(3);
    				System.out.println("Account Number:"+Account_number);
    				System.out.println("Account Hloder Name"+Account_Holder_Name);
    				System.out.println("Balance: "+Balance);
    		}}
    		catch (ClassNotFoundException e)
    		{
    				System.out.print("JDBC Driver not found!");
    				e.printStackTrace();
    		}
    			catch (SQLException e)
    			{
    				e.printStackTrace();
    			}
    				    			
}
}





