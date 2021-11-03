import java.sql.*; 

class TestSleepMethod1 extends Thread{    
 public void run(){    
  for(int i=1;i<5;i++){   
  // the thread will sleep for the 500 milli seconds   
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
    System.out.println(i);    
  }    
 }   

public class TestDBOracle {

public static void main(String[] args)
throws ClassNotFoundException, SQLException
{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=off)(FAILOVER=on)(address_list=(ADDRESS=(PROTOCOL=TCP)(HOST=rds-orcl.cveuj7cbvndw.us-east-1.rds.amazonaws.com)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=rds-orcl.cveuj7cbvndw.us-east-1.rds.amazonaws.com)(PORT=15321))) (CONNECT_DATA=(SERVICE_NAME=ORCL)))";

System.out.println(url);

Connection conn =
DriverManager.getConnection(url,"admin","test1234");

conn.setAutoCommit(false);
Statement stmt = conn.createStatement();
while (true) {
   ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
   while (rset.next()) {
   System.out.println (rset.getString(1));
   }
   stmt.close();   
}

System.out.println ("Success!");

}
} 