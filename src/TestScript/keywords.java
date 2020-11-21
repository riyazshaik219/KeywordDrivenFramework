package TestScript;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class keywords {
	static FirefoxDriver driver;
	 static FileInputStream file;
	  static Properties prop;
	
	
public  void openbrowser() throws Exception
{
	 driver = new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 file = new FileInputStream("D:\\Riyaz\\CRMFramework\\src\\objectrepository\\objectrepository.properties");
	 prop = new Properties();
	 prop.load(file);
}

public void navigate (String data)
{
	driver.get(data);
}
public String VerifyTitle()
{
	String actualValue = driver.getTitle();
	return actualValue;
}
public String VerifyPageText(String objectname)
{
	String actualValue = driver.findElement(By.xpath(prop.getProperty(objectname))).getText();
	return actualValue;
}
public void input(String data, String objectname) throws Exception
{
	driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(data);
}

public void click(String objectname)
{
	
	driver.findElement(By.xpath(prop.getProperty(objectname))).click();
}

}