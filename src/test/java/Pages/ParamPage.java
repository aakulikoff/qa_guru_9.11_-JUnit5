package Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.*;

public class ParamPage {

    @Step
    @DisplayName("Ввести в поисковую строку данные")
    public void inputSearchData (String item){
        $(".input__field").setValue(item);
    }

    @Step
    @DisplayName("Клик 'Найти'")
    public void clickSearch (){
        $(".search-icon-wrap").click();
    }

    @Step
    @DisplayName("Проверить результат поиска")
    public void checkSearchResult (String result){
        $$("body")
                .find(Condition.text(result))
                .shouldBe(Condition.visible);
    }




}
