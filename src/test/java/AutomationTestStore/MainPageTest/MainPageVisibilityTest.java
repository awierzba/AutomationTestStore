package AutomationTestStore.MainPageTest;

import AutomationTestStore.MainPage;
import AutomationTestStore.TextReportLog;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

class MainPageVisibilityTest implements TextReportLog {

    private final MainPage mainPage = Selenide.page(MainPage.class);

    @BeforeEach
    public void setup() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterEach
    public void cleanup() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void productsNamesShouldBeVisible() {
        //given
        //when
        //then
        mainPage.itemsNames.shouldHave(exactTexts(
                "SKINSHEEN BRONZER STICK",
                "BENEFIT GIRL MEETS PEARL",
                "BENEFIT BELLA BAMBA",
                "TROPIQUES MINERALE LOOSE BRONZER",
                "ABSOLUTE ANTI-AGE SPOT REPLENISHING UNIFYING TREATMENTSPF 15",
                "ABSOLUE EYE PRECIOUS CELLS",
                "TOTAL MOISTURE FACIAL CREAM",
                "FLASH BRONZER BODY GEL",
                "NEW LADIES HIGH WEDGE HEEL TOE THONG DIAMANTE FLIP FLOP SANDALS",
                "TROPIQUES MINERALE LOOSE BRONZER",
                "VIVA GLAM LIPSTICK",
                "ABSOLUE EYE PRECIOUS CELLS",
                "ABSOLUE EYE PRECIOUS CELLS",
                "ACQUA DI GIO POUR HOMME",
                "BENEFIT GIRL MEETS PEARL",
                "BRUNETTE EXPRESSIONS CONDITIONER"));
    }

    @Test
    public void pricesShouldBeVisible() {
        //given
        //when
        //then
        mainPage.itemsPrices.shouldHave(exactTexts(
                "$29.50", "$28.00", "$38.50",
                "$42.00", "$38.00", "$26.00", "$38.50", "$5.00"));
        mainPage.pricesAfterDiscount.shouldHave(exactTexts(
                "$19.00", "$89.00", "$29.00", "$89.00",
                "$89.00", "$45.00", "$19.00", "$24.00"));
    }

    @Test
    public void shouldNotReturnAnyProduct() {
        //given
        //when
        //then
        mainPage.itemName.shouldNotHave(exactText("soap"));
    }

}