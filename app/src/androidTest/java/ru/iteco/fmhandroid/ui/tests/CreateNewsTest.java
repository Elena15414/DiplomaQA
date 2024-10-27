package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.PageCreateNews;
import ru.iteco.fmhandroid.ui.page.PageObjectBefore;
import ru.iteco.fmhandroid.ui.page.PageObjectNews;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreateNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    PageObjectNews pageObjectNews = new PageObjectNews();
    PageObjectBefore pageObjectBefore = new PageObjectBefore();
    PageCreateNews pageCreateNews = new PageCreateNews();

    @Before
    public void startPage() {
        pageObjectBefore.loginIn();
    }

    @Test
    public void createNewsPositive() {
        pageObjectNews.createNewsPositive();
        pageCreateNews.checkControlPanel();
    }

    @Test
    public void createNewsEmptyCategory() {
        pageObjectNews.createNewsEmptyCategory();
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createNewsEmptyTitle() {

        pageObjectNews.createNewsEmptyTitle();
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createNewsEmptyPublicationDate() {

        pageObjectNews.createNewsNegative("Publication date");
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createNewsEmptyTime() {

        pageObjectNews.createNewsNegative("Time");
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createNewsEmptyDescription() {

        pageObjectNews.createNewsEmptyDescription();
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createEmptyNewsAll() {

        pageObjectNews.formCreating();
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCreateNews();
    }

    @Test
    public void createNewsAnyCategory() {

        pageObjectNews.createNewsAnyCategory("test");
        pageObjectNews.clickOnSaveButton();
        pageCreateNews.checkToastMessageCategoryCreateNews();
    }
}