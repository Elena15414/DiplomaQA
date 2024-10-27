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
import ru.iteco.fmhandroid.ui.page.PageObjectControlPanel;
import ru.iteco.fmhandroid.ui.page.PageObjectNews;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CancelCreateNewsTest {

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
    public void canceledCreateNews() {

        pageObjectNews.createNewsCanceled();
        pageCreateNews.checkControlPanel();

    }
}