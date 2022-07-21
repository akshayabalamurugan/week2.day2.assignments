package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
//	http://leaftaps.com/opentaps/control/main	 
//		1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		2	Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
//		3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
//		5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
//		6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//		7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		9	Enter phone number
		driver.findElement(By.id("ext-gen262")).clear();
		driver.findElement(By.id("ext-gen262")).sendKeys("191");
		driver.findElement(By.id("ext-gen266")).sendKeys("1");
		driver.findElement(By.id("ext-gen270")).sendKeys("9500194552");
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		11	Capture lead ID of First Resulting lead
		Thread.sleep(3000);
		String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		System.out.println("The first resulting lead id is:"+leadID);
//		12	Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
//		13	Click Delete
		driver.findElement(By.linkText("Delete")).click();
//		14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		15	Enter captured lead ID
		driver.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(leadID);
//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(3000);
		 String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if (message.equals("No records to display")) {
			System.out.println("The lead is deleted");	
		}
		else {
			System.out.println("The lead is not deleted");
		}
//		18	Close the browser (Do not log out)
		driver.quit();
	}

}
