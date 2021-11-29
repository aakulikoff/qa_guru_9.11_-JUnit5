package qa;

import pages.ParamPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class TestBase extends TestData{

    ParamPage paramPage = new ParamPage();

    @BeforeEach
    public void openOnlineShopUrl(){
        open(MVIDEOURL);
    }

}
