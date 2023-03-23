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
            nameProject = "Первый проект",
            nameTask = "Новая_задача",
            nameOrganization = "Тест_организация",
            nameMemberOrganization = "Стажер_техник",
            loginMemberOrganization = "TraineeUser",
            passwordMemberOrganization = "pass";


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
    @DisplayName("Создать в системе новую задачу в составе проекта - Первый проект")
    @Test
    void createNewTask() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("app-header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $(".gantt_grid").$(byText(nameProject)).click();
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(nameProject));
        $(".g-icons__add-task_white_bg").click();
        $(".modal-task").shouldBe(visible);
        $("#name").setValue(nameTask);
        $("[formcontrolname=status]").click();
        $(".ng-dropdown-panel-items").$(byText("В проработке")).click();
        $("[formcontrolname=task_manager]").click();
        $(".ng-dropdown-panel-items").$(byText("Администратор")).click();
        $("[for=need_plan]").click();
        $("[label=Сохранить]").shouldBe(enabled).click();
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(nameTask));

    }

    @Tags({@Tag("LOW"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Сотрудники и открыть карточку пользователя Администратор")
    @Test
    void moveEmployeesSectionOpenCardUser() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("app-header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $("nav").$(byText("Сотрудники")).click();
        $(".share-layout__header").shouldHave(text("Сотрудники"));
        $(".table-body").$(byText("Администратор")).click();
        $(".profile-header__title").shouldHave(text("Администратор"), Duration.ofSeconds(5));
        $("app-history-back-button").shouldBe(enabled).click();
    }

    @Tags({@Tag("HIGH"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Администрирование и создать новую организацию")
    @Test
    void moveAdministrationSectionAddNewOrganization() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("app-header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $("nav").$(byText("Администрирование")).click();
        $(".share-layout__header").shouldHave(text("Администрирование"));
        $(".share-layout__header-center").$(byText("Организации")).click();
        $("[label=Добавить]").click();
        $("[role=dialog]").shouldBe(visible).shouldHave(text("Создание организации"));
        $("[id=name]").setValue(nameOrganization);
        $("[label=Сохранить]").click();
        $(".table_simple").shouldHave(text(nameOrganization));

    }

    @Tags({@Tag("HIGH"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Администрирование и создать нового пользователя")
    @Test
    void moveAdministrationSectionAddNewUser() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("app-header").shouldHave(text("Проекты"), Duration.ofSeconds(5));
        $("nav").$(byText("Администрирование")).click();
        $(".share-layout__header").shouldHave(text("Администрирование"));
        $(".share-layout__header").$(byText("Добавить")).click();
        $("[role=dialog]").shouldBe(visible).shouldHave(text("Создание пользователя"));
        $(".name").setValue(nameMemberOrganization);
        $("#login").setValue(loginMemberOrganization);
        $("#pass").setValue(passwordMemberOrganization);
        $("#organization").click();
        $(".scrollable-content").$(byText(nameOrganization)).click();
        $(".admin-users-roles").click();
        $(".scrollable-content").$(byText("Исполнитель")).click();
        $("[label=Сохранить]").click();

    }

    @Tags({@Tag("MEDIUM"), @Tag("UI_TEST")})
    @DisplayName("В боковой карточке задачи добавить нового пользователя в участники задачи")
    @Test
    void addNewUserForTaskMembers() {

        open(baseUrl);
        $(".auth-page__login-form").shouldHave(text("Вход"));
        $("[name=username]").setValue(userLogin);
        $("[name=password]").setValue(userPassword).pressEnter();
        $("header").shouldHave(text("Проекты"));

    }
}
