package com.kongzue.dialogx.wrapper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Constructor;

public class ModuleInflaterFactory implements LayoutInflater.Factory {
    private final LayoutInflater.Factory mOriginFactory;
    private final ClassLoader mModuleLoader;

    public ModuleInflaterFactory(LayoutInflater.Factory originFactory, ClassLoader moduleLoader) {
        mOriginFactory = originFactory;
        mModuleLoader = moduleLoader;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view = null;
        try {
            Class<?> clazz = mModuleLoader.loadClass(name);
            Constructor<?> constructor = clazz.getConstructor(Context.class, AttributeSet.class);
            view = (View) constructor.newInstance(context, attrs);
        } catch (Exception ignored) {
        }
        if (view != null) {
            return view;
        } else {
            if (mOriginFactory != null) {
                return mOriginFactory.onCreateView(name, context, attrs);
            } else {
                return null;
            }
        }
    }
}
