
package com.android.internal.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;

/**
 * @hide
 */

public class ThemeUtils {
    private static class ThemedUiContext extends ContextWrapper {
        private String mPackageName;

        public ThemedUiContext(Context context, String packageName) {
            super(context);
            mPackageName = packageName;
        }

        @Override
        public String getPackageName() {
            return mPackageName;
        }
    }

    public static Context createUiContext(final Context context) {
        try {
            Context uiContext = context.createPackageContext("com.android.systemui",
                    Context.CONTEXT_RESTRICTED);
            return new ThemedUiContext(uiContext, context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
        }

        return null;
    }
}
