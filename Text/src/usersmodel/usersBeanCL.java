package usersmodel;
import java.sql.*;
import goodsmodel.*;
public class usersBeanCL {
	private Connection ct=null;
	private PreparedStatement sm=null;
	private ResultSet rs=null;
	
	/**
	 * ��֤��¼
	 * @param u���û���
	 * @param p������
	 * @return��boolean
	 */
	
	public boolean logincl(String u,String p)
	{
		boolean type=false;
		try {
			ct=new goodsConnDB().getConn();
			sm=ct.prepareStatement("select passwd from users where username='"+u+"'");
			rs=sm.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(p))
				{
					//һ���Ϸ�
					type=true;
				}
				else
				{
					//�������
					type=false;
				}
			}
			else
			{
				//�û�������
				type=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			this.close();
		}
		return type;
	}
	/**
	 * �û���\����ע��
	 * @param u���û���
	 * @param tn���û���ʵ����
	 * @param p������
	 * @param eml�������ʼ�
	 * @param tel���绰����
	 * @param adr���û���ַ
	 * @param pst���ʱ�
	 * @param g���û��ȼ�
	 * @return���ύ�û�
	 */
	public boolean register(String u,String tn,String p,String eml,String tel,String adr,String pst,String g )
	{
		boolean type=false;
		try {
			ct=new goodsConnDB().getConn();
			sm=ct.prepareStatement("insert into users(username,truename,passwd,email,phone,address,postcode,grade) "
					+ "values ('"+u+"','"+tn+"','"+p+"','"+eml+"','"+tel+"','"+adr+"','"+pst+"','"+g+"')");
			int m=sm.executeUpdate();
			if(m==1)
			{
				type=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			this.close();
		}
		return type;
	}
	/**
	 * ��ʾ�û���Ϣ�Լ��������Ʒ
	 * @param u
	 * @return
	 */
	public usersBean showuser(String u)
	{
		usersBean ub=new usersBean();
		
		try {
			ct=new goodsConnDB().getConn();
			sm=ct.prepareStatement("select * from users where username='"+u+"'");
			rs=sm.executeQuery();
			if(rs.next())
			{
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			this.close();
		}
		return ub;
	}
	public void close()
	{
		try {
			if(rs!=null)
			{
			rs.close();
			rs=null;
			}
			if(sm!=null)
			{
				sm.close();
				sm=null;
			}
			if(ct!=null)
			{
				ct.close();
				sm=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
