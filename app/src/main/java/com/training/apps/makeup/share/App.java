package com.training.apps.makeup.share;


import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.training.apps.makeup.language.Language;
import com.training.apps.makeup.preferences.Preferences;


public class App extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Preferences.getInstance().getLanguage(newBase)));

    }

}

