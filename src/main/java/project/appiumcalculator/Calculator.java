package project.appiumcalculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    private static AndroidDriver<WebElement> driver;
    static void driverCalculator(){
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung pro");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0.1");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver<WebElement>(url, dc);
    }
    static void tearDown(){
        driver.quit();
    }
    static void calculatorAdd(){
        //1 + 2 = 3
        //1
        WebElement one = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='1']"));
        one.click();
        // + button
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='plus']")).click();
        //2
        WebElement two = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']"));
        two.click();
        // = button
        WebElement equalsButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']"));
        equalsButton.click();

        String resultAdd = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        System.out.println("1 + 2 = " + resultAdd);
    }
    static void calculatorMultiply(){
        //3 x 4 = 12
        //3
        WebElement three = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='3']"));
        three.click();
        // x button
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='multiply']")).click();
        //4
        WebElement four = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='4']"));
        four.click();
        // = button
        WebElement equalsButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']"));
        equalsButton.click();

        String resultMultiply = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        System.out.println("3 * 4 = " + resultMultiply);
    }
    public static void main(String[] args) {
        driverCalculator();
        calculatorAdd();
        calculatorMultiply();
        tearDown();
    }
}