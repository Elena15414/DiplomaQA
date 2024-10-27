package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AboutPolicyElement;

public class PageAboutPrivacyPolicy {

    AboutPolicyElement aboutPolicyElement = new AboutPolicyElement();
    PageObjectPage pageObjectPage = new PageObjectPage();

    public void entranceInAbout() {
        pageObjectPage.menuPage("About");
    }

    public void checkAboutPrivatePolice() {
        onView(withId(R.id.about_privacy_policy_label_text_view))
                .check(matches(withText("Privacy Policy:")));
    }

    public void checkAboutTermsOfUse() {
        onView(withId(R.id.about_terms_of_use_label_text_view))
                .check(matches(withText("Terms of use:")));
    }

    //"Проверка отображения экрана О приложении"
    public void checkAboutIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.about_company_info_label_text_view, 4000));
        aboutPolicyElement.getVersion().check(matches(isDisplayed()));
        aboutPolicyElement.getNumberVersion().check(matches(isDisplayed()));
    }

    //"Проверка кликабельности ссылки Политика конфиденциальности"
    public void checkPrivacyPolicyLinkIsClickable() {
        aboutPolicyElement.getPrivacyPolicyLink().check(matches(isClickable()));
    }

    //"Проверка кликабельности ссылки Пользовательское соглашение"
    public void checkTermsOfUseLinkIsClickable() {
        aboutPolicyElement.getTermsOfUseLink().check(matches(isClickable()));
    }

    //"Нажатие на кнопку Назад"
    public void clickOnBackButton() {
        aboutPolicyElement.getBackButton().perform(click());
    }
}
