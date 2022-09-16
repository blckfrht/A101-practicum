package com.a101;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticumTest {
	
	private static final int wait = 2000;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		driver.get("https://www.a101.com.tr/");
        Thread.sleep(wait);
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//a[@title='GÝYÝM & AKSESUAR']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//a[@data-value='1565']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//a[@data-value='1567']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//img[@src='https://ayb.akinoncdn.com/products/2020/11/11/54870/d8dbaefe-f64e-45a0-b6d7-e483e4aaf225_size250x250_quality100_cropCenter.jpg']")).click();
        Thread.sleep(wait);
        WebElement SiyahKontrol=driver.findElement(By.xpath("//span[text()='SÝYAH']"));
        Assertions.assertTrue(SiyahKontrol.isDisplayed(),"Ürün Siyah Renkli Deðil");
        driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//a[@class='go-to-shop']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/orders/checkout/']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//a[@title='ÜYE OLMADAN DEVAM ET']")).click();
        Thread.sleep(wait);
        WebElement Email = driver.findElement(By.xpath("//input[@name='user_email']"));
        Email.sendKeys("user@gmail.com");
        Thread.sleep(wait);
        driver.findElement(By.xpath("//button[@class='button block green']")).click();
        Thread.sleep(wait);
        driver.findElement(By.linkText("Yeni adres oluþtur")).click();
        Thread.sleep(wait);

        Actions actions=new Actions(driver);
        WebElement Form = driver.findElement(By.xpath("//input[@placeholder='Ev adresim, iþ adresim vb.']"));
        actions.click(Form).
                sendKeys("EV")
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)        
                .sendKeys("Surname")
                .perform();
        
        Thread.sleep(wait);
        
        WebElement phone =driver.findElement(By.xpath("//input[@name='phone_number']"));
        phone.sendKeys("45654874561");
        Thread.sleep(wait);
        Select drpCity = new Select(driver.findElement(By.name("city")));
		drpCity.selectByVisibleText("ANKARA");
        Thread.sleep(wait);
		Select drpTown = new Select(driver.findElement(By.name("township")));
		drpTown.selectByVisibleText("ÇANKAYA");
        Thread.sleep(wait);
        driver.findElement(By.xpath("//select[@name='district']")).click();
        Thread.sleep(wait);
        driver.findElement(By.xpath("//option[@value='5413']")).click();
        Thread.sleep(wait);

        WebElement Adress = driver.findElement(By.xpath("//textarea[@name='line']"));
        Adress.sendKeys("balýkçý apartmaný no:12/6");
        Thread.sleep(wait);
        
        WebElement Postcode = driver.findElement(By.xpath("//input[@name='postcode']"));
        Postcode.sendKeys("06530");
        Thread.sleep(6000);
        
        driver.findElement(By.xpath("//button[@class='button green js-set-country js-prevent-emoji']")).click();
        
        Thread.sleep(wait);
        
        driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']")).submit();
        
        String odemeKontrol="https://www.a101.com.tr/orders/checkout/";
        
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(odemeKontrol));
       


        driver.quit();

	}


}
