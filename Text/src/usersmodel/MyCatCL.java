package usersmodel;

import java.sql.*;
import java.util.*;
import goodsmodel.*;

public class MyCatCL {
	private Connection ct=null;
	private PreparedStatement sm=null;
	private ResultSet rs=null;
	private float price=0.0f;
	private String flag=null;
	
	
	
	HashMap<String,String> hs=new HashMap<String,String>();
	/**
	 * 购物车添加货物
	 * @param goodsid：货物id
	 * @param goodsNum:购买数量
	 */
	public void add(String goodsid,String goodsNum)
	{
		hs.put(goodsid, goodsNum);
	}
	/**
	 * 删除购物车货物
	 * @param goodsid：货物id
	 * @param goodsNum：货物数量
	 */
	public void delet(String goodsid)
	{
		hs.remove(goodsid);
	}
	/**
	 * 删除所有货物
	 */
	public void deletall()
	{
		hs.clear();
	}
	/**
	 * 修改货物数量
	 * @param goodsid
	 * @param goodsNum
	 */
	public void update(String goodsid,String goodsNum)
	{
		hs.put(goodsid, goodsNum);
	}
	/**
	 * 获取货物对应购买数量
	 * @param goodsid
	 * @return
	 */
	public int goodsnewNum(String goodsid)
	{
		String s_newnum=hs.get(goodsid);
		int newnum=Integer.parseInt(s_newnum);
		return newnum;
	}
	/**
	 * 获取购物车总价
	 * @return
	 */
	public float returnallprice()
	{
		return this.price;
	}
	public String returngoodsid()
	{
		return this.flag;
	}
	
	
	/**
	 * 显示购物车
	 * @return
	 */
	public ArrayList<goodsBean> showTheCat()
	{
		ArrayList<goodsBean> al=new ArrayList<goodsBean>();
		
		try {
			ct=new goodsConnDB().getConn();
			String sql="select * from goods where goodsID in";
			Iterator<String> it=hs.keySet().iterator();
			flag="(";
			while(it.hasNext())
			{
				//取出key
				String goodsID=(String)it.next();
				if(it.hasNext())
				{
					
					flag+=goodsID+",";
				}
				else
				{
					flag+=goodsID+")";
				}
			}
			sql+=flag;
			sm=ct.prepareStatement(sql);
			rs=sm.executeQuery();
			this.price=0.0f;
			while(rs.next())
			{
				
				int num=this.goodsnewNum(rs.getInt(1)+"");
				price+=num*rs.getFloat(4);
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
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			this.close();
		}
		return al;
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
