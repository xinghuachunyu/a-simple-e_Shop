package goodsmodel;
import java.sql.*;

import java.util.*;

public class goodsBeanCL {
	private Connection ct=null;
	private PreparedStatement sm=null;
	private ResultSet rs=null;
	
	private int pageSize=6;
	private int pagecount=0;
	private int rowCount=0;
	
	
	
	
	/**
	 * 分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public ArrayList<goodsBean> GoodsByPage(int pageNow,int pageSize)
	{
		
				
		ArrayList<goodsBean> al=new ArrayList<goodsBean>();
		
		try {
			ct=new goodsConnDB().getConn();
			String sql="select top "+pageSize+" * from goods where goodsID not in(select top "+(pageSize*(pageNow-1))+" goodsID from goods)";
			sm=ct.prepareStatement(sql);
			rs=sm.executeQuery();
			while(rs.next())
			{
				goodsBean gb=new goodsBean();
				gb.setGoodsID(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsInro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				al.add(gb);
				
			}
			if(al.equals(null))
			{
				System.out.println("ArrayList错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			this.close();
		}
		return  al;
	}
	/**
	 * 获得总共有多少页
	 */
	public int getPagecount()
	{
		try
		{
			//得到连接
			ct=new goodsConnDB().getConn();
			//查询
			sm=ct.prepareStatement("select count(*) from goods");
			rs=sm.executeQuery();
			//根据结果判断
			if(rs.next())
			{
				rowCount=rs.getInt(1);
			}
			//计算pagecount
			if(rowCount%pageSize==0)
			{
				pagecount=rowCount/pageSize;
			}
			else
			{
				pagecount=rowCount/pageSize+1;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return pagecount;
	}
	/**
	 *货物分类
	 * @param pageNow
	 * @param type
	 * @return
	 */
	public ArrayList<goodsBean> typeGoodsByPage(int pageNow,String type)
	{
		
				
		ArrayList<goodsBean> al=new ArrayList<goodsBean>();
		
		try {
			ct=new goodsConnDB().getConn();
			String sql="select top "+pageSize+" * from goods where type='"+type+"' and goodsID not in(select top "+pageSize*(pageNow-1)+" goodsID from goods where type='"+type+"')";
			sm=ct.prepareStatement(sql);
			rs=sm.executeQuery();
			while(rs.next())
			{
				goodsBean gb=new goodsBean();
				gb.setGoodsID(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsInro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				al.add(gb);
			}
			if(al.equals(null))
			{
				System.out.println("ArrayList错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			this.close();
		}
		return  al;
	}
	/**
	 * 获得货物分类后总共有多少页
	 * @param type
	 * @return
	 */
	public int getgoodstypePagecount(String type)
	{
		try
		{
			//得到连接
			ct=new goodsConnDB().getConn();
			//查询
			sm=ct.prepareStatement("select count(*) from goods where type='"+type+"'");
			rs=sm.executeQuery();
			//根据结果判断
			if(rs.next())
			{
				rowCount=rs.getInt(1);
			}
			//计算pagecount
			if(rowCount%pageSize==0)
			{
				pagecount=rowCount/pageSize;
			}
			else
			{
				pagecount=rowCount/pageSize+1;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return pagecount;
	}
	
	
	/**
	 * 显示细节
	 * @param id
	 * @return
	 */
	public goodsBean showdatail(String id)
	{
		goodsBean gb=new goodsBean();
		try {
			ct=new goodsConnDB().getConn();
			sm=ct.prepareStatement("select * from goods where goodsID=?");
			sm.setString(1, id);
			rs=sm.executeQuery();
			if(rs.next())
			{
				
				gb.setGoodsID(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsInro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			this.close();
		}
		return gb;
	}
	private void close() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null)
			{
				rs.close();
				rs=null;
			}
			else if(sm!=null)
			{
				sm.close();
				sm=null;
			}
			else if(ct!=null)
			{
				ct.close();
				ct=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
