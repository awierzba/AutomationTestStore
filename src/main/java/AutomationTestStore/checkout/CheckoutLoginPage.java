package AutomationTestStore.checkout;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutLoginPage {
    public final SelenideElement continueButton = $("#accountFrm").$(".btn");
    public final SelenideElement guestLoginButton = $("#accountFrm_accountguest");

}
