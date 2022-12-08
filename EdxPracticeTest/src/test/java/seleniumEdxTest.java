import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumEdxTest {

    //import selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start(){

        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources" +
                "\\chromedriver.exe");

        // open chrome browser
        driver = new ChromeDriver();
    }


    @Test (priority = 0)
    public void getUrl() throws InterruptedException {
        // fetch edx website
        driver.get("https://www.edx.org/");

        // maximize the browser
        driver.manage().window().maximize();

        //get page title
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Free Online Courses")){
            System.out.println("You are on the right website!");
        } else{
            System.out.println("Please confirm the url");
        }
        Thread.sleep(3000);

    }

    @Test (priority = 1)
    public void negativeSigninInvalidInput() throws InterruptedException {
        // click signin button
        driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div[8]/nav/a[1]")).click();
        Thread.sleep(30000);

        // click email input field and enter invalid email
        driver.findElement(By.xpath("//*[@id=\"emailOrUsername\"]")).sendKeys("deefiyinfoluwa" +
                "@gmail.con");
        Thread.sleep(5000);

        // click password input field and enter valid password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("#tag_Edx4me");
        Thread.sleep(5000);
        // click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/span/span")).click();
        Thread.sleep(3000);

        // assert the error message
        String errorMessage1 = driver.findElement(By.xpath("//*[@id=\"login-failure-alert\"]/div/div/p")).getText();
        assert errorMessage1.contains("The username, email, or password you " +
                "entered is incorrect");

        Thread.sleep(3000);
        // clear the email input field and enter a valid email
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[1]/input")).clear();
        Thread.sleep(3000);

        // clear password input field and enter blank password
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/input")).clear();
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void negativeSigninBlankInput() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"emailOrUsername\"]")).sendKeys("deefiyinfoluwa" +
                "@gmail.com");
        Thread.sleep(3000);

        // enter blank password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(" ");
        Thread.sleep(3000);

        // click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/span/span")).click();
        Thread.sleep(3000);

        // assert the error message
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"login-failure-alert\"]/div/div")).getText();
        assert errorMessage.contains("Please fill in the fields below");
        Thread.sleep(3000);
    }

    @Test (priority = 3)
    public void positiveSignup() throws InterruptedException {
        // clear the email input field and enter a valid email
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[1]/input")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"emailOrUsername\"]")).sendKeys("deefiyinfoluwa" +
                "@gmail.com");
        Thread.sleep(3000);

        // clear password input field and enter valid password
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/input")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("#tag_Edx4me");
        Thread.sleep(3000);

        // click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/span/span")).click();
        Thread.sleep(3000);

    }

    @Test (priority = 4)
    public void getDashboardUrl() throws InterruptedException {
        // get dashboard url
        String dashboardUrl = driver.getCurrentUrl();
        if (dashboardUrl.contains("dashboard")){
            System.out.println("Welcome back!");
        } else {
            System.out.println("an error occurred!");
        }
        Thread.sleep(3000);
    }

    @Test (priority = 5)
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2" +
                "]/div[2]/div[3]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/div[6]/a")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
