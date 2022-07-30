package AutomationTestStore.CheckoutTest;

import AutomationTestStore.CartPage;
import AutomationTestStore.MainPage;
import AutomationTestStore.TextReportLog;
import AutomationTestStore.checkout.CheckoutLoginPage;
import AutomationTestStore.checkout.GuestCheckoutPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;

public class CheckoutTest implements TextReportLog {

    public final MainPage mainPage = Selenide.page(MainPage.class);
    public final CheckoutLoginPage checkoutLoginPage =
            Selenide.page(CheckoutLoginPage.class);
    public final CartPage cartPage =
            Selenide.page(CartPage.class);

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        Selenide.open(Configuration.baseUrl);
        mainPage.itemsNames
                .first()
                .click();
        cartPage.addToCartButton.click();
        Selenide.open(Configuration.baseUrl);
        mainPage.itemsNames
                .last()
                .click();
        cartPage.addToCartButton.click();
        Selenide.open(Configuration.baseUrl +
                "index.php?rt=account/login");
    }

    @AfterEach
    public void cleanup() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void continueButtonShouldBeVisible() {
        //then
        checkoutLoginPage.continueButton.shouldBe(visible);
    }

    @Test
    public void shouldBeAbleToLoginAsGuest() {
        //given
        final GuestCheckoutPage guestCheckoutPage = Selenide.page(GuestCheckoutPage.class);
        //when
        checkoutLoginPage.guestLoginButton.click();
        checkoutLoginPage.continueButton.click();
        //then
        guestCheckoutPage.guestCheckoutContinueButton.shouldBe(visible);
    }

}
