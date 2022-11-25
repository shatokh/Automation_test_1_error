package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LocatorsTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("Start test scenario");
        Configuration.baseUrl = "https://magento.softwaretestingboard.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulTest() throws InterruptedException {

        // 1.Open (https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html)
        open("/men/tops-men/jackets-men.html");

        //2.Open tab Men - > Tops
        $(By.xpath("//a[@id='ui-id-5']")).hover();
        $(By.xpath("//a[@id='ui-id-17']")).click();

        //3.Select Style -> Rain coat
        $(By.xpath("//div[text()='Style']")).click();
        $(By.xpath("//li/a[contains(text(),'Rain Coat')]")).click();

        //4.Select via as List
        $(By.xpath("//a[@id='mode-list']")).click();

        //5.Sort by Price
        $(By.xpath("//select[@data-role='sorter']")).click();
        $(By.xpath("//option[@value='price']")).click();

        //6. Select size of first coat
        $(By.xpath("//*[@index='4']")).click();

        //7. Select color of fist coat
        $(By.xpath("//*[@option-label='Yellow']")).click();

        //8. Click “Add to cart” button
        $(By.xpath("//span[contains(text(),'Add to Cart')]")).click();

        //9. Click to shopping cart
        $(By.xpath("//*[@class='action showcart']")).click();

        //10. Check that coat is added\
        $(By.xpath("//*[contains(text(),'Beaumont Summit Kit to')]")).shouldHave(text("added"));
        $(By.xpath("//*[@class='action showcart']")).click();
        $(By.xpath("//div[@class='items-total']")).shouldHave(text("1 Item in Cart"));


        //11. Click delete item
        //12. Check that “Are you sure you would like to remove this item from the shopping cart?” is visible
        //13. Click on “Ok” button
        $(By.xpath("//*[@title='Remove item']")).click();
        $(By.xpath("//div[@id='modal-content-103']")).shouldHave(text("Are you sure you would like to remove this item from the shopping cart?"));
        $(By.xpath("//*[contains(text(),'OK')]")).click();


        //14. Check that cart provides the message “You have no items in your shopping cart“.
        $(By.xpath("//strong[@class='subtitle empty']")).shouldHave(text("You have no items in your shopping cart."));







    }
}
