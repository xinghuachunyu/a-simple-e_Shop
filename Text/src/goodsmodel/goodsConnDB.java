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
				System.out.println("����Դ���Գɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����Դ����ʧ��");
			// TODO: handle exception
		}
    	return ct;*/
    	try
    	{
    		// SQL Server
			
    					// �������ݿ�����,ʵ����һ��driver����
    					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
    					
    					// �������ݿ�db_database17��URL
    					String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb2";
    					String root="sa";
    					String password="123456";
    					
    				    ct=DriverManager.getConnection(url,root,password);

    					if (ct == null) {
    						System.out.println("�޷��������ݿ�����");
    					} else {
    						System.out.println("����Դ���Գɹ���");
    						
    					}

    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("���ݿ�����ʧ��");
    	}
    	finally
    	{
    		
    	}
		return ct;
    	
    }
}
