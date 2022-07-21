package AutomationTestStore.MainPageTest;

import AutomationTestStore.CartPage;
import AutomationTestStore.MainPage;
import AutomationTestStore.TextReportLog;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;

public class MainPageAddToCartTest implements TextReportLog {

    private final MainPage mainPage = Selenide.page(MainPage.class);
    private final CartPage cartPage = Selenide.page(CartPage.class);


    @BeforeEach
    public void setup() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterEach
    public void cleanup() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void shouldAddItemsToCart() {
        //when
        mainPage.itemsNames
                .first()
                .click();
        cartPage.addToCartButton.click();
        Selenide.open(Configuration.baseUrl);

        mainPage.itemsNames
                .first()
                .click();
        cartPage.addToCartButton.click();

        //then
        mainPage.numberOfItemsInCart.shouldHave(exactText("2"));
    }

}
