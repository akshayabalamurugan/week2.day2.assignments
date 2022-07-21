package week2.day2.assignments;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class EditLead {
	public static void main(String[] args) throws InterruptedException {
//		http://leaftaps.com/opentaps/control/main
//		
//		* 1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		* 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
//		* 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		* 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
//		* 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
//		* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//		* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		* 8	Enter first name
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Akshaya");
//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		* 10 Click on first resulting lead
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
//		* 11 Verify title of the page
		String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("The view lead page is verified");
		}
		else {
			System.out.println("The view lead page is not verified");
		}
//		* 12 Click Edit
		driver.findElement(By.linkText("Edit")).click();
//		* 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Flexprod");
//		* 14 Click Update
		driver.findElement(By.className("smallSubmit")).click();
//		* 15 Confirm the changed name appears
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (companyName.equals("Flexprod (10963)")) {
			System.out.println("The company name is updated");
		}
		else {
			System.out.println("The company name is not updated");
		}
//		* 16 Close the browser (Do not log out)
		driver.quit();
	}
}