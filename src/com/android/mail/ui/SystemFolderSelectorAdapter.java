/*******************************************************************************
 *      Copyright (C) 2012 Google Inc.
 *      Licensed to The Android Open Source Project.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *******************************************************************************/

package com.android.mail.ui;

import android.content.Context;
import android.database.Cursor;

import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider.FolderCapabilities;

import java.util.Set;

public final class SystemFolderSelectorAdapter extends FolderSelectorAdapter {

    public SystemFolderSelectorAdapter(Context context, Cursor folders,
            Set<String> initiallySelected, boolean single) {
        super(context, folders, initiallySelected, single);
    }

    /**
     * Return whether the supplied folder meets the requirements to be displayed
     * in the folder list.
     */
    @Override
    protected boolean meetsRequirements(Folder folder) {
        // We only want to show system folders.
        return folder.supportsCapability(FolderCapabilities.CAN_ACCEPT_MOVED_MESSAGES)
                && Folder.isProviderFolder(folder);
    }
}
