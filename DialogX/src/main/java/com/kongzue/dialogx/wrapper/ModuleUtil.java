package com.kongzue.dialogx.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

import java.lang.reflect.Method;

public class ModuleUtil {
    public static String modulePath = "";

    /** @noinspection JavaReflectionMemberAccess*/
    @SuppressLint("DiscouragedPrivateApi")
    public static void injectModuleAppResources(Resources hostResources) {
        if (modulePath.isEmpty()) return;
        try {
            AssetManager assetManager = hostResources.getAssets();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.setAccessible(true);
            method.invoke(assetManager, modulePath);
        } catch (Throwable ignore) {
        }
    }

    public static void injectModuleAppResources(Context hostContext) {
        injectModuleAppResources(hostContext.getResources());
    }

    public static Context getContext(Context context) {
        return new ModuleContext(context);
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        return LayoutInflater.from(context).cloneInContext(getContext(context));
    }
}
