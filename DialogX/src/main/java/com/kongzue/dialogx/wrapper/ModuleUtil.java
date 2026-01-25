package com.kongzue.dialogx.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

import java.lang.reflect.Method;

public class ModuleUtil {
    @SuppressLint("DiscouragedPrivateApi")
    public static void injectModuleAppResources(Resources hostResources, String moduleAppFilePath) {
        try {
            AssetManager assetManager = hostResources.getAssets();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.setAccessible(true);
            method.invoke(assetManager, moduleAppFilePath);
        } catch (Throwable ignore) {
        }
    }

    public static void injectModuleAppResources(Context hostContext, String moduleAppFilePath) {
        injectModuleAppResources(hostContext.getResources(), moduleAppFilePath);
    }

    public static Context getContext(Context context) {
        return new ModuleContext(context);
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        return LayoutInflater.from(context).cloneInContext(getContext(context));
    }
}
