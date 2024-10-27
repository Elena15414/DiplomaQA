package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

import ru.iteco.fmhandroid.R;

import androidx.test.espresso.ViewInteraction;

public class ControlPanelElement {

    private final ViewInteraction controlPanel = onView(withText(containsString("Control panel")));
    private final ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));

    public ViewInteraction getControlPanel() {
        return controlPanel;
    }

    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    public ViewInteraction getCreateNewsButton() {
        return createNewsButton;
    }

}
