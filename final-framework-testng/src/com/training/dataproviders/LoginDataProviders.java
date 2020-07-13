package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getproName(); 
			obj[1] = temp.getmeta();
			obj[2] = temp.getmodel(); 
			obj[3] = temp.getprice(); 
			obj[4] = temp.getcategory(); 
			obj[5] = temp.getdisQuantity(); 
			obj[6] = temp.getdisPrice(); 
			obj[7] = temp.getpoint(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	//correct given by manzoor
	/*@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		String fileName ="C:/Users/ShipraJindal/Desktop/sELENIUM PROJECT/ELearning.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}*/
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
				String fileName ="C:/Users/ShipraJindal/Desktop/sELENIUM PROJECT/AddProductTestdata.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "productNeg-inputs")
	public Object[][] getExcelData1(){
				String fileName ="C:/Users/ShipraJindal/Desktop/sELENIUM PROJECT/AddProductTestdata.xlsx";
		return new ApachePOIExcelRead().getExcelContent1(fileName); 
	}
		
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
