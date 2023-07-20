package authorizationUsers;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthhorizationAdminUser {

    private static String userLogin = "admin",
            userPassword = "admin";

    public void authAdminUser (){
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("app-header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
    }

}

