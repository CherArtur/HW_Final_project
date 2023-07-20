package workingtests;

import authorizationUsers.AuthhorizationAdminUser;
import authorizationUsers.CreatingNewElementsPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreatingNewElementsTheSystem extends BaseConfig {
    CreatingNewElementsPageObject creatingNewElementsPageObject = new CreatingNewElementsPageObject();
    AuthhorizationAdminUser authhorizationAdminUser = new AuthhorizationAdminUser();


    private static String
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
        authhorizationAdminUser.authAdminUser();
        creatingNewElementsPageObject.selectButtonForCreateObjects();
        creatingNewElementsPageObject.buttonForCreateBriefcase();
        creatingNewElementsPageObject.modalWindowForNewBriefcase();
        creatingNewElementsPageObject.dataFillingBriefcase(nameBriefcase);
        creatingNewElementsPageObject.checkCreatingNewBriefcase(nameBriefcase);

    }

    @Tags({@Tag("HIGHEST"), @Tag("UI_TEST")})
    @DisplayName("Создать в системе новый проект")
    @Test
    void createNewProject() {

        open(baseUrl);
        authhorizationAdminUser.authAdminUser();
        creatingNewElementsPageObject.selectButtonForCreateObjects();
        creatingNewElementsPageObject.buttonForCreateProject();
        creatingNewElementsPageObject.modalWindowForNewProject();
        creatingNewElementsPageObject.dataFillingProject(nameProject);
        creatingNewElementsPageObject.checkCreatingNewProject(nameProject);

    }


    @Tags({@Tag("HIGHEST"), @Tag("UI_TEST")})
    @DisplayName("Создать в системе новую задачу в составе проекта - Первый проект")
    @Test
    void createNewTask() {

        open(baseUrl);
        authhorizationAdminUser.authAdminUser();
        creatingNewElementsPageObject.findRequiredProject(nameProject);
        creatingNewElementsPageObject.modalWindowForCreateTask();
        creatingNewElementsPageObject.dataFillingTask(nameTask);
        creatingNewElementsPageObject.checkCreatingNewTask(nameTask);

    }

    @Tags({@Tag("LOW"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Сотрудники и открыть карточку пользователя Администратор")
    @Test
    void moveEmployeesSectionOpenCardUser() {

        open(baseUrl);
        authhorizationAdminUser.authAdminUser();
        creatingNewElementsPageObject.transitionOnStaffSection();
        creatingNewElementsPageObject.checkCardUser();
        creatingNewElementsPageObject.moveBackOnStaffSection();

    }

    @Tags({@Tag("HIGH"), @Tag("UI_TEST")})
    @DisplayName("Перейти в раздел Администрирование и создать новую организацию")
    @Test
    void moveAdministrationSectionAddNewOrganization() {

        open(baseUrl);
        authhorizationAdminUser.authAdminUser();
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
        authhorizationAdminUser.authAdminUser();
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


}
