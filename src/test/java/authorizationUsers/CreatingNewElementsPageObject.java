package authorizationUsers;

import org.checkerframework.framework.qual.AnnotatedFor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreatingNewElementsPageObject {

    @AnnotatedFor("createNewBriefcase")
    public void selectButtonForCreateObjects() {
        $(".nav__add, ng-star-inserted").shouldBe(visible).click();
        $(".nav__item--modal").shouldBe(visible);
    }

    public void buttonForCreateBriefcase() {
        $(".nav__item--modal").shouldBe(text("Создать портфель проектов")).hover().click();
    }


    public void modalWindowForNewBriefcase() {
        $(".portfolio").shouldBe(visible);
        $(".ui-dialog-titlebar").shouldHave(text("Портфель проектов"));
    }

    public void dataFillingBriefcase(String value) {
        $("#name").setValue(value);
        $(".form-row:not(.ui-g-12)").shouldHave(text("Выберите")).hover().click();
        $("div.scrollable-content").$(byText("Администратор")).click();
        $(".ui-button-success").shouldBe(enabled).click();
    }

    public void checkCreatingNewBriefcase(String value) {
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(value));
    }

    @AnnotatedFor("createNewProject")
    public void buttonForCreateProject() {
        $(".nav__item--modal").$(byText("Создать проект")).click();
    }

    public void modalWindowForNewProject() {
        $(".modal-task").shouldBe(visible);
        $(".ui-dialog-titlebar").shouldHave(text("Проект"));
    }

    public void dataFillingProject(String value) {
        $("#name").setValue(value);
        $("[formcontrolname=status]").click();
        $(".ng-dropdown-panel-items").$(byText("Инициация")).click();
        $("[formcontrolname=task_manager]").click();
        $(".ng-dropdown-panel-items").$(byText("Администратор")).click();
        $("[for=need_plan]").click();
        $("[label=Сохранить]").shouldBe(enabled).click();
    }

    public void checkCreatingNewProject(String value) {
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(value));
    }

    @AnnotatedFor("createNewTask")
    public void findRequiredProject(String value) {
        $(".gantt_grid").$(byText(value)).click();
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(value));
    }

    public void modalWindowForCreateTask() {
        $(".g-icons__add-task_white_bg").click();
        $(".modal-task").shouldBe(visible);
    }

    public void dataFillingTask(String value) {
        $("#name").setValue(value);
        $("[formcontrolname=status]").click();
        $(".ng-dropdown-panel-items").$(byText("В проработке")).click();
        $("[formcontrolname=task_manager]").click();
        $(".ng-dropdown-panel-items").$(byText("Администратор")).click();
        $("[for=need_plan]").click();
        $("[label=Сохранить]").shouldBe(enabled).click();
    }

    public void checkCreatingNewTask(String value) {
        $(".sidebar-opened").shouldBe(visible).shouldHave(text(value));
    }

    @AnnotatedFor("moveEmployeesSectionOpenCardUser")
    public void transitionOnStaffSection() {
        $("nav").$(byText("Сотрудники")).click();
        $(".share-layout__header").shouldHave(text("Сотрудники"));
    }

    public void checkCardUser() {
        $(".table-body").$(byText("Администратор")).click();
        $(".profile-header__title").shouldHave(text("Администратор"), Duration.ofSeconds(5));
    }

    public void moveBackOnStaffSection() {
        $("app-history-back-button").shouldBe(enabled).click();
    }

    @AnnotatedFor("moveAdministrationSectionAddNewOrganization")



}
