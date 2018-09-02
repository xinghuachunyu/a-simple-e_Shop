package goodstype;

import java.io.UnsupportedEncodingException;

public class goods {
	public String saveWrong(String a)
	{
		String m = null;
		try {
			m = new String(a.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}
