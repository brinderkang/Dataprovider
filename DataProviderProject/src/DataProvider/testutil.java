package DataProvider;

import java.util.ArrayList;

public class testutil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> gettestdata()
	{
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		reader=new Xls_Reader("D:\\Brinder\\OBJ\\DataProviderProject\\src\\DataProvider\\Testdata.xlsx");
		int rowcount=reader.getRowCount("yahoo");
		
		for(int i=2;i<=rowcount;i++)
		{
			String username=reader.getCellData("yahoo", "username", i);
			String password=reader.getCellData("yahoo", "password", i);
			Object obj[]={username,password};
			mydata.add(obj);
		}
		
		return mydata;
		
	}

}
