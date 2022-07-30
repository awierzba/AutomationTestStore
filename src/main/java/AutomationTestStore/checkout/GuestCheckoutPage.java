package AutomationTestStore.checkout;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GuestCheckoutPage {
    public final SelenideElement guestCheckoutContinueButton = $(".col-md-9").$(".col-md-12").$("[title=\"Continue\"]");
}
