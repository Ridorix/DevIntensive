package com.softdesign.devintensive.data.managers;


import android.content.SharedPreferences;

import com.softdesign.devintensive.utils.ConstantManager;
import com.softdesign.devintensive.utils.DevintensiveApplication;

import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {

    private SharedPreferences mSharedPreferences;

    private static final String[] USER_FIELDS = {ConstantManager.USER_PHONE_KEY, ConstantManager.USER_MAIL_KEY, ConstantManager.USER_VK_KEY, ConstantManager.USER_GIT_KEY, ConstantManager.USER_ABOUT_KEY};

    public PreferencesManager() {
        this.mSharedPreferences = DevintensiveApplication.getsSharedPreferences();
    }

    public void saveUserProfileData(List<String> userFields) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_FIELDS.length; i++) {
            editor.putString(USER_FIELDS[i], userFields.get(i));
        }
        editor.apply();
    }

    public List<String> loadUserProfileData() {
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_KEY, "+7913208****"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_MAIL_KEY, "ridorix@yandex.ru"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_VK_KEY, "vk.com/ridorix"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_GIT_KEY, "github.com/Ridorix/DevIntensive"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_ABOUT_KEY, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        return userFields;
    }
}
