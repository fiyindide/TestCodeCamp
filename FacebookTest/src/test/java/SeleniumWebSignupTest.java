import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources" +
                "\\chromedriver.exe");

        // 1. open chrome browser
        driver = new ChromeDriver();
    }

    @Test (priority = 0)
    public void getUrl() throws InterruptedException {
        // 2. input selenium page url and add a little pause timer
        driver.get("https://selenium-blog.herokuapp.com/");
        // Test 1: Verify the user input the right url and his on the
        // right web page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp" +
                ".com/")){
            //pass
            System.out.println("correct web page");
        } else {
            //fail
            System.out.println("wrong web page");
        }
        Thread.sleep(5000);

        // 3. maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void openSignUpPage() throws InterruptedException {
        // 4. click on signUp button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        // Test 2: Verify that when user clicks on the signUp button, the
        // user is directed to the signUp page
        String expectedSignupUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualSignupUrl = driver.getCurrentUrl();
        if (actualSignupUrl.contains(expectedSignupUrl)){ // if(actualUrl
            // == contains expectedUrl)
            //pass
            System.out.println("correct sigUp page");
        } else {
            //fail
            System.out.println("wrong sigUp page");
        }
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void positiveSignUp() throws InterruptedException {

        // 5. locate the username field and input your username on the
        // username field
        driver.findElement(By.id("user_username")).sendKeys("fifi6");

        // 6. locate the email field and input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fifi6" +
                "@mailinator.com");

        // 7. locate the password field and input your password on the
        // password field
        driver.findElement(By.id("user_password")).sendKeys("admin");

        // 8. click on signUp button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        // Test 7  Verify that user is successfully signed up when valid details are inputted
        String expectedUrl = "https://selenium-blog.herokuapp.com/users.11290";
        String actualUrl = driver.getCurrentUrl();
        //pass
        if (actualUrl.contains(expectedUrl)){ // if(actualUrl.contains(expectedUrl)
            System.out.println("Sign up successful!");
        } else {
            //fail
            System.out.println("sign up unsuccessful!");
        }
        Thread.sleep(3000);
    }


    @Test (priority = 3)
    public void clickUserItem() throws InterruptedException {
        // Test 8: verify that User1 item is present on the item list page
        //9. Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1" +
                "]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void verifySearchedItem() throws InterruptedException {
        // Test 9: Verify that the item searched for on the User1 page is present
        //9. Search for an item ("Learn XPath") and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(3000);
        // Verify searched item url
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/articles/59";
        String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl)){
            //pass
            System.out.println("correct page url");
        } else {
            //fail
            System.out.println("wrong page url");
        }
        Thread.sleep(3000);
    }

    @Test (priority = 5)
    public void logout() throws InterruptedException {
        //10. click logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1" +
                "\"]/ul/li[3]/a")).click();
        // Test 10: Verify that when the user logout, he/she is directed back to the home page
        String expectedHomeUrl = "https://selenium-blog.herokuapp.com/";
        String actualHomeUrl = driver.getCurrentUrl();
        if(expectedHomeUrl.contains(actualHomeUrl)){
            System.out.println("correct page url");
        } else {
            System.out.println("wrong page url");
        }
        Thread.sleep(3000);
    }

    @Test (priority = 6)
    public void negativeSignUpInvalidUsername() throws InterruptedException {
        // click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // Test 3: Verify that user cannot signup with username less than 3
        // characters*
        // locate the username field and input your username on the
        // username field
        driver.findElement(By.id("user_username")).sendKeys("fi");

        // locate the email field and input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fi" +
                "@mailinator.com");

        // locate the password field and input your password on the
        // password field
        driver.findElement(By.id("user_password")).sendKeys("admin");

        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);


    }

    @Test (priority = 7)
    public void negativeSignUpInvalidEmailAddress() throws InterruptedException {
        // click on signup button in the navbar to open signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        // Test 4: Verify that user cannot signup with invalid email address
        // locate the username field and input your username on the
        // username field
        driver.findElement(By.id("user_username")).sendKeys("fifi2");

        // locate the email field and input invalid email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fifi2");

        // locate the password field and input your password on the
        // password field
        driver.findElement(By.id("user_password")).sendKeys("admin");

        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void negativeSignUpInvalidPassword() throws InterruptedException {
        // click on signup button in the navbar to open signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        // Test 5: Verify user cannot login with password less than or equal
        // to one character
        // locate the username field and input your username on the
        // username field
        driver.findElement(By.id("user_username")).sendKeys("fifi3");

        // locate the email field and input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fifi3@gmail.com");

        // locate the password field and input invalid password on the
        // password field
        driver.findElement(By.id("user_password")).sendKeys(" ");

        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 9)
    public void negativeSignUpBlankFields() throws InterruptedException {
        // click on signup button in the navbar to open signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // Test 6: Verify user cannot signup with either/all of the fields blank
        // locate the username field and input your username on the
        // username field
        driver.findElement(By.id("user_username")).sendKeys(" ");

        // locate the email field and input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fifi4@gmail.com");

        // locate the password field and input invalid password on the
        // password field
        driver.findElement(By.id("user_password")).sendKeys("admin");

        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser(){
        //quit browser
        driver.quit();
    }
}


//        8. Verify that User1 item is present on the item list page.*
//        9. Verify that the item searched for on the User1 page is present.*
//        10.