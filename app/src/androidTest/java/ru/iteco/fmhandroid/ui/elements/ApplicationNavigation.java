package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ApplicationNavigation {

    private final ViewInteraction missionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction missionTitle = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction missionText = onView(withText("Love is all"));

    public ViewInteraction getMissionButton() {
        return missionButton;
    }

    public ViewInteraction getMissionTitle() {
        return missionTitle;
    }

    public ViewInteraction getMissionText() {
        return missionText;
    }
}
