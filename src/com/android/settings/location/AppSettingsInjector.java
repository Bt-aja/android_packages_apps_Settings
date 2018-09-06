/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.location;

import android.content.Context;
import android.text.TextUtils;

import androidx.preference.Preference;

import com.android.settings.widget.AppPreference;
import com.android.settings.widget.RestrictedAppPreference;
import com.android.settingslib.location.InjectedSetting;
import com.android.settingslib.location.SettingsInjector;

import java.util.List;

/**
 * Adds the preferences specified by the {@link InjectedSetting} objects to a preference group.
 */
public class AppSettingsInjector extends SettingsInjector {

    public AppSettingsInjector(Context context) {
        super(context);
    }

    @Override
    protected Preference createPreference(Context prefContext, InjectedSetting setting) {
        return TextUtils.isEmpty(setting.userRestriction)
                ? new AppPreference(prefContext)
                : new RestrictedAppPreference(prefContext, setting.userRestriction);
    }
}
