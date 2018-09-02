package goodsmodel;
import java.sql.*;
public class goodsConnDB {
	private Connection ct=null;
    public Connection getConn()
    {
    	/*try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb2","sa", "123456");
			if(ct!=null)
			{
				System.out.println("数据源测试成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据源测试失败");
			// TODO: handle exception
		}
    	return ct;*/
    	try
    	{
    		// SQL Server
			
    					// 加载数据库驱动,实例化一个driver对象
    					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
    					
    					// 声明数据库db_database17的URL
    					String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb2";
    					String root="sa";
    					String password="123456";
    					
    				    ct=DriverManager.getConnection(url,root,password);

    					if (ct == null) {
    						System.out.println("无法创建数据库连接");
    					} else {
    						System.out.println("数据源测试成功。");
    						
    					}

    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("数据库连接失败");
    	}
    	finally
    	{
    		
    	}
		return ct;
    	
    }
}
