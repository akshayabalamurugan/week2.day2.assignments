package week2.day2.assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LeafgroundEdit {
	public static void main(String[] args) {
	//open leaftabs edit page
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://leafground.com/pages/Edit.html");
	driver.manage().window().maximize();
	//Enter your email address
	driver.findElement(By.id("email")).sendKeys("akshayabalamurugan12@gmail.com");
	//Append a text and press keyboard tab
	driver.findElement(By.xpath("(//label[contains(text(),'Append a text')]//following::input)[1]")).sendKeys("Akshaya");
	driver.findElement(By.xpath("(//label[contains(text(),'Append a text')]//following::input)[1]")).sendKeys(Keys.TAB);
	//Get default text entered
	WebElement defaultText = driver.findElement(By.xpath("(//label[contains(text(),'Get default text entered')]//following::input)[1]"));
	String text = defaultText.getAttribute("value");
	System.out.println(text);
	//Clear the text
	driver.findElement(By.xpath("(//label[contains(text(),'Clear the text')]//following::input)[1]")).clear();
	//Confirm that edit field is disabled
	boolean enabled = driver.findElement(By.xpath("(//label[contains(text(),'Confirm that edit field is disabled')]//following::input)[1]")).isEnabled();
	if (enabled ==false) {
		System.out.println("The button is disabled");
	}
	else {
		System.out.println("The button is enabled");
	}
	}
}
