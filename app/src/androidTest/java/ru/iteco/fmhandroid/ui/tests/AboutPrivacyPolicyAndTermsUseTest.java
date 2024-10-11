package ru.iteco.fmhandroid.ui.tests;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.PageObjectBefore;
import ru.iteco.fmhandroid.ui.page.PageObjectPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPrivacyPolicyAndTermsUseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void startPage() {
        pageObjectBefore.loginIn();
    }

    PageObjectBefore pageObjectBefore = new PageObjectBefore();
    PageObjectPage pageObjectPage = new PageObjectPage();

    @Test
    public void pageAboutOption1() {

        pageObjectPage.menuPage("About");
        onView(withId(R.id.about_privacy_policy_label_text_view))
                .check(matches(withText("Privacy Policy:")));
    }

    @Test
    public void pageAboutOption2() {

        pageObjectPage.menuPage("About");
        onView(withId(R.id.about_terms_of_use_label_text_view))
                .check(matches(withText("Terms of use:")));
    }
}