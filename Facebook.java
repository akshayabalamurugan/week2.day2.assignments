package week2.day2.assignments;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Facebook {
	public static void main(String[] args) throws InterruptedException {
		// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver driver= new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]/a")).click();
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']//input")).sendKeys("Joey");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//div[contains(text(),'Surname')]/following::input")).sendKeys("Trib");
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[contains(text(),'Mobile number')]/following::input")).sendKeys("9500194552");
		// Step 10: Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("that_WoRd_is_notKnoWN");
		// Step 11: Handle all the three drop downs
		//dropdown selection for date
		 WebElement day = driver.findElement(By.id("day"));
		Select dayDrop= new Select(day);
		dayDrop.selectByVisibleText("12");
		//dropdown selection for month
		 WebElement month = driver.findElement(By.id("month"));
		Select monthDrop= new Select(month);
		monthDrop.selectByVisibleText("Jan");
		//dropdown selection for year
		 WebElement year = driver.findElement(By.id("year"));
		Select yearDrop= new Select(year);
		yearDrop.selectByVisibleText("1995");
		// Step 12: Select the radio button "Female"
		driver.findElement(By.className("_8esa")).click();
		//( A normal click will do for this step)
		driver.findElement(By.xpath("//div[@class='_1lch']//button")).click();
	}
}
