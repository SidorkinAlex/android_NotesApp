package my.notesapp;

import android.app.Activity;

import com.google.android.material.navigation.NavigationView;

public class HelperRouter {
    public static boolean routeActions(int id, MainActivity activity) {
        //логика обработки нажатия кнопок меню
        switch (id) {
            case R.id.action_main:
                ListNotesFragment listNotesFragment = new ListNotesFragment();
                activity.replaceFragment(listNotesFragment);
                return true;
            case R.id.action_about:
                AboutFragment aboutFragment  = new AboutFragment();
                activity.replaceFragment(aboutFragment);
                return true;
        }
        return false;
    }
}
