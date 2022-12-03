import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumJumiaLoginTest {

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
        // fetch Jumia's url
        driver.get("https://www.jumia.com.ng/");
        // Verify the user input the right url and is on the right web page
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/")){
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
        String expectedPageTitle = "Jumia Nigeria";
        String actualPageTitle = driver.getTitle();
        if(actualPageTitle.contains(expectedPageTitle)){
            //pass
            System.out.println("correct page title");
        } else{
            //fail
            System.out.println("wrong page title");
        }
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void negativeLoginInvalidEmail() throws InterruptedException {
        // click on Account drop down
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        Thread.sleep(3000);
        // click on signin button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        Thread.sleep(5000);

        // input invalid email
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2" +
                "]/label/input")).sendKeys("gmail.com");
        Thread.sleep(3000);

        // clear email input field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2" +
                "]/label/input")).clear();
        Thread.sleep(3000);

    }

    @Test (priority = 3)
    public void negativeLoginBlankEmail() throws InterruptedException {
        // input blank email
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2" +
                "]/label/input")).sendKeys(" ");
        Thread.sleep(4000);

        // clear email input field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2" +
                "]/label/input")).clear();
        Thread.sleep(3000);

    }

    @Test (priority = 4)
    public void positiveLoginValidEmail() throws InterruptedException {

        // input valid email
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2" +
                "]/label/input")).sendKeys("*valid_email*");
        Thread.sleep(3000);
        // click continue button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3" +
                "]/div/button/span[3]")).click();
        Thread.sleep(3000);

    }

    @Test (priority = 5)
    public void negativeLoginInvalidPassword() throws InterruptedException {
        // input invalid password
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys(
                "eight");
        Thread.sleep(3000);
        // clear password input field
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3" +
                "]/label/input")).clear();
    }

    @Test (priority = 6)
    public void negativeLoginBlankPassword() throws InterruptedException {
        // input blank password
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys(
                " ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3" +
                "]/label/input")).clear();
    }

    @Test (priority = 7)
    public void positiveLoginValidPassword() throws InterruptedException {
        // input valid password
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys(
                "*valid_password*");
        Thread.sleep(3000);

        // click on login button
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        Thread.sleep(4000);

    }

    @Test (priority = 8)
    public void logout() throws InterruptedException {
        // click on your username drop down
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        Thread.sleep(2000);

        // click on logout
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        //quit browser
        driver.quit();
    }

}
