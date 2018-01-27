import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cilory
{
	public static WebDriver driver;

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Neel\\eclipse\\New\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cilory.com/");

		cilory c = new cilory();
		c.positiveScenario();
		c.negativeScenario();

		driver.quit();

	}

	public void negativeScenario() throws Exception
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//nav[@id='topmenuContener']//li//a[@href='/content/16-men']"))).build().perform();
		Thread.sleep(2000);
		String str;
		str = driver.findElement(By.xpath("//nav[@id='topmenuContener']//div[@class='submenu submenuid3 clearfix']")).getText();
		//System.out.println(str);
		String[] s = str.split("\n");
		//System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			if (s[i].equalsIgnoreCase("Super Hero")) {
				//System.out.println(s[i]);
				String str2 = s[i];
				driver.findElement(By.linkText(str2)).click();
			}
		}

		Thread.sleep(5000);

		WebElement slider = driver.findElement(By.xpath("//div[@id='layered_price_slider']"));
	    int width=slider.getSize().getWidth();
	    Actions move = new Actions(driver);
	    org.openqa.selenium.interactions.Action action  = move.dragAndDropBy(slider, ((width*50)/50*100),0) .build();
	    action.perform();

	    Thread.sleep(5000);

	    boolean value =driver.findElement(By.id("show_more")).isDisplayed();

	    if (value == true)
	    {
	    	System.out.println("Testcase failed - Show more results button is displayed when there are no results to display");
	    }
	    //a.dragAndDropBy(source, xOffset, yOffset)   if you need to arrange price left and right side both you can use this command
	    else
	    {
	    	System.out.println("Testcase passed");
	    }



	}

	public void positiveScenario() throws Exception
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//nav[@id='topmenuContener']//li//a[@href='/content/16-men']"))).build().perform();
		Thread.sleep(2000);
		String str;
		str = driver.findElement(By.xpath("//nav[@id='topmenuContener']//div[@class='submenu submenuid3 clearfix']")).getText();
		//System.out.println(str);
		String[] s = str.split("\n");
		//System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			if (s[i].equalsIgnoreCase("Super Hero")) {
				//System.out.println(s[i]);
				String str2 = s[i];
				driver.findElement(By.linkText(str2)).click();
			}
		}

		Thread.sleep(5000);

		WebElement slider = driver.findElement(By.xpath("//div[@id='layered_price_slider']"));
	    int width=slider.getSize().getWidth();
	    Actions move = new Actions(driver);
	    org.openqa.selenium.interactions.Action action  = move.dragAndDropBy(slider, ((width*1)/50),1) .build();
	    action.perform();

	    Thread.sleep(5000);

	    String startPrice= driver.findElement(By.xpath("//*[@id=\"layered_price_range\"]")).getText().toString().substring(4,8);

	    System.out.println("startprice = "+startPrice);

	    driver.findElement(By.xpath("//*[@id=\"productsSortForm\"]/table/tbody/tr/td[2]/p/a/span[2]")).click();

	    driver.findElement(By.xpath("//*[@id=\"category\"]/ul/li[3]/a")).click();

	    String amount = driver.findElement(By.xpath("//*[@id=\"product_list\"]/li[1]/div[4]/div/span")).getText().toString();

	    System.out.println("amount : "+amount);

	    String[] words=startPrice.split("\\s");
		String a1="";

		for(int i=0; i<words.length;i++)
		{
			System.out.println(words[i]);
			a1+=words[i];
		}

	    int startAmount = Integer.parseInt(a1);

	    int firstAmomunt = Integer.parseInt(amount.substring(4,amount.length()));

	    if (firstAmomunt < startAmount)
	    {
	    	System.out.println("Testcase failed - Price range filter shows lesser value than customer selected.");
	    }

	    else
	    {
	    	System.out.println("Testcase passed - Price range filter shows equal to or greater value than customer selected.");
	    }


	    System.out.println("priority 2");
	}

}
