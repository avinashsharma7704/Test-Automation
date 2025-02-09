import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Angular_Form_Automation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\avina\\Downloads\\driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-web-security");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(options);
		// Navigate to a website
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys("Akhil Singh");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akhil@sutosel.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("1234edfgh");
		driver.findElement(By.name("email")).sendKeys("hello@abc.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
		WebElement check = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		check.click();
		boolean checked = check.isSelected();
		if (checked == true) {
			System.out.println("Check me out if you Love IceCreams! checkbox is checked as expected.");
		} else {
			System.out.println("Not checked");
		}
		WebElement value = driver.findElement(By.id("exampleFormControlSelect1"));
		Select picklist = new Select(value);
		picklist.selectByVisibleText("Female");
		Thread.sleep(1000);
		if (value.getText().equals("Female")) {
			System.out.println("Gender fields is working fine");
		} else {
			System.out.println("Picklist is not updated to female");
		}
		WebElement empStatus= driver.findElement(By.id("inlineRadio1"));
		empStatus.click();
		boolean checkBox2=empStatus.isSelected();
		if (checkBox2=true) {
			System.out.println("Student checkbox is selected");
		}
		else{
			System.out.println("Student checkbox is not selected");
			
		}
		//Veriying the disable checkbox
	boolean disable=	driver.findElement(By.xpath("//label[text()='Entrepreneur (disabled)']")).isSelected();
	System.out.println(disable);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("08/02/2025");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();
		System.out.println(message);
	}
}
