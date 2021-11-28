package qa;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ParamTests extends TestBase{

    @ParameterizedTest ( name = "{displayName} {0}")
    @ValueSource (strings = {"Nintendo switch", "Xbox series", "Sega Mega Drive"})
    @DisplayName("Поиск Nintendo Switch и Xbox в магазине Мвидео")
    @Tags({@Tag("Blocker"), @Tag("Nintendo"), @Tag("Xbox")})

    public void mVideoSearchFunTest (String searchItem) {
        paramPage.inputSearchData(searchItem);
        paramPage.clickSearch();
        paramPage.checkSearchResult(searchItem);
    }




    @ParameterizedTest ( name = "{displayName} {0} {1}")
//    @CsvSource({
//            "Play Station 5, приём заявок на покупку комплекта PS5 и второго геймпада временно закрыт",
//            "Xbox series, Игровая приставка Microsoft Xbox Series"
//    })
    @CsvSource(value = {
            "Play Station 5| Сожалеем, но приём заявок на покупку комплекта PS5 и второго геймпада временно закрыт",
            "Xbox series| Игровая приставка Microsoft Xbox Series"
    },
    delimiter = '|')
    @DisplayName("Поиск PS5 и Xbox в магазине Мвидео и проверка результата поиска")
    @Tags({@Tag("Blocker"), @Tag("PS5"), @Tag("Xbox")})

    public void searchFunAnywhereTest (String searchItem, String searchResult) {
        paramPage.inputSearchData(searchItem);
        paramPage.clickSearch();
        paramPage.checkSearchResult(searchResult);
    }




    @ParameterizedTest ( name = "{displayName} {0} {1}")
    @CsvSource(value = {
            "Play Station 5| PS5",
            "Xbox series| XBOX"
    },
            delimiter = '|')
    @DisplayName("Поиск PS5 и Xbox в магазине Мвидео и проверка результата поиска")
    @Tags({@Tag("Blocker"), @Tag("PS5"), @Tag("Xbox")})

    public void searchFunAnywhereTestEnum (String searchItem, SearchItem searchResult) {
        paramPage.inputSearchData(searchItem);
        paramPage.clickSearch();
        paramPage.checkSearchResult(searchResult.name());
    }



    @ParameterizedTest ( name = "{displayName} {0} {1}")
    @EnumSource (SearchItem.class)
    @DisplayName("Поиск PS5 и Xbox в магазине Мвидео и проверка результата поиска")
    @Tags({@Tag("Blocker"), @Tag("PS5"), @Tag("Xbox")})
    public void searchFunAnywhereTestEnumSource (SearchItem searchItem) {
        paramPage.inputSearchData(searchItem.name());
        paramPage.clickSearch();
        paramPage.checkSearchResult(searchItem.getSearchItem());
    }



    static Stream<Arguments> searchFunAnywhereListTest() {
        return Stream.of(
                Arguments.of("Play Station 5",
                        List.of("Сожалеем, но приём заявок на покупку комплекта PS5 и второго геймпада временно закрыт")),
                Arguments.of("Xbox series", List.of("Игровая приставка Microsoft Xbox Series"))
        );
    }
    @ParameterizedTest ( name = "{displayName} {0} {1}")
    @MethodSource
    @DisplayName("Поиск PS5 и Xbox в магазине Мвидео и проверка результата поиска")
    @Tags({@Tag("Blocker"), @Tag("PS5"), @Tag("Xbox")})

    public void searchFunAnywhereListTest (String searchItem, List<String> searchResult) {
        paramPage.inputSearchData(searchItem);
        paramPage.clickSearch();
        paramPage.checkSearchResult(searchResult.get(0));
    }


}
