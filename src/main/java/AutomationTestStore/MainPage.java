package AutomationTestStore;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public final SelenideElement numberOfItemsInCart = $("header").$(".block_7").$(".label");
    public final ElementsCollection itemsPrices = $$(".oneprice");
    public final ElementsCollection pricesAfterDiscount = $$(".pricenew");
    public final ElementsCollection itemsNames = $$(".prdocutname");
    public final SelenideElement itemName = $(".prdocutname");

//    public void findProductInTheProductsList(String productName){
//        itemsNames.findBy(Condition.attribute(productName));
//    }
//
////    public MainPage listOfProducts(String product){
////        for(String product){
////            System.out.println($$(".prdocutname").shouldHave(texts(product)));
////        }
////    }
}
