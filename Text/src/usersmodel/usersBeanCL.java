package usersmodel;
import java.sql.*;
import goodsmodel.*;
public class usersBeanCL {
	private Connection ct=null;
	private PreparedStatement sm=null;
	private ResultSet rs=null;
	
	/**
	 * 验证登录
	 * @param u：用户名
	 * @param p：密码
	 * @return：boolean
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
					//一定合法
					type=true;
				}
				else
				{
					//密码错误
					type=false;
				}
			}
			else
			{
				//用户名错误
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
	 * 用户名\密码注册
	 * @param u：用户名
	 * @param tn：用户真实姓名
	 * @param p：密码
	 * @param eml：电子邮件
	 * @param tel：电话号码
	 * @param adr：用户地址
	 * @param pst：邮编
	 * @param g：用户等级
	 * @return：提交用户
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
	 * 显示用户信息以及购买的物品
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
