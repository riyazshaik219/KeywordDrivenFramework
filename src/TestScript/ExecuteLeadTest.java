package TestScript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

public class ExecuteLeadTest {
	@Test
public void leadTest() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	keywords key = new keywords();
ArrayList a = new ArrayList();
FileInputStream file = new FileInputStream("D:\\LeadSuite1.xlsx");
XSSFWorkbook wbks = new XSSFWorkbook(file);
Sheet s = wbks.getSheet("TestSteps");
Iterator itr = s.iterator();
while(itr.hasNext())
{
	Row rowitr =(Row) itr.next();
	Iterator cellitr = rowitr.cellIterator();
	while(cellitr.hasNext())
	{
		Cell celldata = (Cell)cellitr.next();
		switch(celldata.getCellType())
        {
        case STRING:
            a.add(celldata.getStringCellValue());
            break;
        case NUMERIC:
            a.add(celldata.getNumericCellValue());
            break;
        case BOOLEAN:
            a.add(celldata.getBooleanCellValue());
            break;
	}
	}
}
for(int i=0; i<a.size(); i++)
{
	if(a.get(i).equals("openbrowser"))
	{
		String keyword = (String)a.get(i);
		String data = (String)a.get(i+1);
		String objectname = (String)a.get(i+2);
		String runmode = (String)a.get(i+3);
		System.out.println(keyword);
		System.out.println(data);
		System.out.println(objectname);
		System.out.println(runmode);
if(runmode.equals("yes"))
{
	key.openbrowser();
}
}
	
if(a.get(i).equals("navigate"))
{
	String keyword = (String)a.get(i);
	String data = (String)a.get(i+1);
	String objectname = (String)a.get(i+2);
	String runmode = (String)a.get(i+3);
	System.out.println(keyword);
	System.out.println(data);
	System.out.println(objectname);
	System.out.println(runmode);
if(runmode.equals("yes"))
{
key.navigate(data);
}
}
if(a.get(i).equals("VerifyTitle"))
{
	String keyword = (String)a.get(i);
	String data = (String)a.get(i+1);
	String objectname = (String)a.get(i+2);
	String runmode = (String)a.get(i+3);
	System.out.println(keyword);
	System.out.println(data);
	System.out.println(objectname);
	System.out.println(runmode);
if(runmode.equals("yes"))
{
	String actualValue = key.VerifyTitle();
	Assert.assertEquals(data, actualValue);
}
}
if(a.get(i).equals("VerifyPageText"))
{
	String keyword = (String)a.get(i);
	String data = (String)a.get(i+1);
	String objectname = (String)a.get(i+2);
	String runmode = (String)a.get(i+3);
	System.out.println(keyword);
	System.out.println(data);
	System.out.println(objectname);
	System.out.println(runmode);
if(runmode.equals("yes"))
{
	String actualValue = key.VerifyPageText(objectname);
	Assert.assertEquals(data, actualValue);
}
}

if(a.get(i).equals("input"))
{
	String keyword = (String)a.get(i);
	String data = (String)a.get(i+1);
	String objectname = (String)a.get(i+2);
	String runmode = (String)a.get(i+3);
	System.out.println(keyword);
	System.out.println(data);
	System.out.println(objectname);
	System.out.println(runmode);
if(runmode.equals("yes"))
{
key.input(data, objectname);
}
}
if(a.get(i).equals("click"))
{
	String keyword = (String)a.get(i);
	String data = (String)a.get(i+1);
	String objectname = (String)a.get(i+2);
	String runmode = (String)a.get(i+3);
	System.out.println(keyword);
	System.out.println(data);
	System.out.println(objectname);
	System.out.println(runmode);
if(runmode.equals("yes"))
{
key.click(objectname);
}
}
}
}
}
