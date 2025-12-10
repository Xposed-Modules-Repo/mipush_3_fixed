package com.example.disablexmspushlog;

import android.content.Intent;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookEntry implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!"com.xiaomi.xmsf".equals(lpparam.packageName)) return;

        try {
            XposedHelpers.findAndHookMethod(
                    "com.xiaomi.push.service.LogXMPushServiceAspect",
                    lpparam.classLoader,
                    "logIntent",
                    Intent.class,
                    XC_MethodReplacement.returnConstant(null)
            );
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
