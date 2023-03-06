package workingtests;

import io.netty.util.Timeout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CreatingNewElementsTheSystem extends BaseConfig {


    private static String userLogin = "admin",
            userPassword = "admin",
            nameBriefcase = "Тестовый портфель",
            nameProject = "Первый проект";


    @Tags({@Tag("HIGHEST"), @Tag("UI_TEST")})
    @DisplayName("Создать в системе новый портфель проектов")
    @Test
    void createNewBriefcase() {


        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $(".nav__add, ng-star-inserted").shouldBe(visible).click();
        $(".nav__item--modal").shouldBe(visible);
        $(".nav__item--modal").shouldBe(text("Создать портфель проектов")).hover().click();
        $(".portfolio").shouldBe(visible);
        $(".ui-dialog-titlebar").shouldHave(text("Портфель проектов"));
        $("#name").setValue(nameBriefcase);
        $(".ng-select-single").shouldHave(text("Выберите")).hover().click();
        $("div.scrollable-content").$(byText("Администратор")).click();
        $(".ui-button-success").shouldBe(enabled).click();
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(nameBriefcase));


    }

    @Tags({@Tag("HIGHEST"), @Tag("UI_TEST")})
    @DisplayName("Создать в системе новый проект")
    @Test
    void createNewProject() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $(".nav__add, ng-star-inserted").shouldBe(visible).click();
        $(".nav__item--modal").shouldBe(visible);
        $(".nav__item--modal").$(byText("Создать проект")).click();
        $(".modal-task").shouldBe(visible);
        $("#name").setValue(nameProject);
        $("[formcontrolname=status]").click();
        $(".ng-dropdown-panel-items").$(byText("Инициация")).click();
        $("[formcontrolname=task_manager]").click();
        $(".ng-dropdown-panel-items").$(byText("Администратор")).click();
        $("[for=need_plan]").click();
        $("[label=Сохранить]").shouldBe(enabled).click();
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(nameProject));

    }


    @Tags({@Tag("HIGHEST"), @Tag("UI_TEST")})
    @DisplayName("Создать в системе новую задачу в составе проекта")
    @Test
    void createNewTask() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"));

    }

    @Tags({@Tag("LOW"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Сотрудники")
    @Test
    void moveEmployeesSection() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"));

    }

    @Tags({@Tag("MEDIUM"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Администрирование")
    @Test
    void moveAdministrationSection() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"));

    }
}
