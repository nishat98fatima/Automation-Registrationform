package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_Data_from_excel {
	public static String Readexcelfile(String Test_keyword,String value) throws Throwable{
		String result="";
		try {
			File file = new File("D:/Scratch_Framework/Test_data.xlsx");
			FileInputStream s=new FileInputStream(file);
			XSSFWorkbook wb= new XSSFWorkbook(s);
			XSSFSheet sheet= wb.getSheet("Sheet1");
			int Rows=sheet.getPhysicalNumberOfRows();
			int Columns= sheet.getRow(0).getPhysicalNumberOfCells();
			HashMap<String,String> h1=new HashMap<>();
			for(int i=0;i<Rows;i++) {
				System.out.println(sheet.getRow(i).getCell(0).toString());
				if(sheet.getRow(i).getCell(0).toString().equals(Test_keyword)) {
					for(int j=0;j<Columns;j++) {
						String var="";
						if(sheet.getRow(i).getCell(j)!=null) {
							var=sheet.getRow(i).getCell(j).toString();
						}
						h1.put(sheet.getRow(0).getCell(j).toString(),var);
					
					}
						
				}
		}
			System.out.println(h1.toString());
			result=h1.get(value);
			
				
				/*FileInputStream fis = new FileInputStream(new File("D:/Scratch_Framework/Test_data.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				//String sheet_name = Read_config.get_from_config("test_sheet_name");
				//System.out.println("sheet name = " + sheet_name);
				XSSFSheet ws = wb.getSheet("Sheet1");
				int no_of_rows = ws.getPhysicalNumberOfRows();
				int no_of_cols = ws.getRow(0).getPhysicalNumberOfCells();
				for(int i=0;i<no_of_rows;i++) {
					System.out.println(ws.getRow(i).getCell(0).toString());
				}*/
				
				
				
			
			
		
			
			
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(result);
		return result;
		
	
	
	}
		

 public static void main(String args[]) throws Throwable {
	
	String var1= Readexcelfile("Test_1","First Name");
	System.out.println(var1);
	String var2= Readexcelfile("Test_2","First Name");
	System.out.println(var2);
	
 }
}