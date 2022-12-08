import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumKongaSiginTest {
    //import selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources" +
                "\\chromedriver.exe");

        // open chrome browser
        driver = new ChromeDriver();
    }

    @Test (priority = 0)
    public void openUrl() throws InterruptedException {
        // fetch Konga's url
        driver.get("https://www.konga.com/");
        // Verify the user input the right url and is on the right web page
        if (driver.getCurrentUrl().contains("https://www.konga.com/")){
            //pass
            System.out.println("correct web page");
        } else {
            //fail
            System.out.println("wrong web page");
        }
        Thread.sleep(5000);

        //maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test (priority = 1)
    public void getPageTitle() throws InterruptedException {
        //get page title
        String expectedPageTitle = "Buy Phones";
        String actualPageTitle = driver.getTitle();
        if(actualPageTitle.contains(expectedPageTitle)){
            //pass
            System.out.println("correct page title");
        } else{
            //fail
            System.out.println("wrong page title");
        }
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void negativeLoginInvalidEmail() throws InterruptedException {

        // click on login/signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

        // input invalid email
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("gmail.com");
        Thread.sleep(5000);

        // input valid password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(
                "#tag_Konga4me");

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4" +
                "]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        String errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/" +
                "section/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).getText();

        assert (errorMessage.contains("The username or password you have " +
                "entered is incorrect"));

    }

    @Test (priority = 3)
    public void negativeLoginInvalidPassword() throws InterruptedException {

        // clear email input field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        Thread.sleep(5000);

        // clear password input field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        Thread.sleep(5000);

        // input valid email
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(
                "deefiyinfoluwa@gmail.com");
        Thread.sleep(5000);

        // input invalid password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(
                "#_Konga4me");

        // click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4" +
                "]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        String errorMessage1 = driver.findElement(By.xpath("/html/body/div[1" +
                "]/div/" +
                "section/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).getText();

        assert (errorMessage1.contains("The username or password you have " +
                "entered is incorrect"));

    }

    @Test (priority = 4)
    public void positiveLoginValidEmail() throws InterruptedException {

        // clear email input field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        Thread.sleep(5000);

        // clear password input field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        Thread.sleep(5000);

        // input valid email
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(
                "deefiyinfoluwa@gmail.com");
        Thread.sleep(5000);

        // input valid password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(
                "#tag_Konga4me");

        // click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4" +
                "]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        Thread.sleep(4000);

    }


    @Test (priority = 5)
    public void logout() throws InterruptedException {
        // click on your My Account drop down
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(4000);

        // click on logout
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        Thread.sleep(4000);
    }

    @AfterTest
    public void closeBrowser(){
        //quit browser
        driver.quit();
    }



}
