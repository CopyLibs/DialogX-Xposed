package com.kongzue.dialogx.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

public class ModuleContext extends ContextWrapper {
    private LayoutInflater mLayoutInflater;

    public ModuleContext(Context base) {
        super(base);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        ModuleUtil.injectModuleAppResources(res);
        return res;
    }

    @Override
    public ClassLoader getClassLoader() {
        return ModuleClassLoader.getInstance();
    }

    @Override
    public Object getSystemService(String name) {
        Object obj = super.getSystemService(name);
        if (obj instanceof LayoutInflater) {
            if (mLayoutInflater == null) {
                mLayoutInflater = ((LayoutInflater) obj).cloneInContext(this);
                LayoutInflater.Factory factory = mLayoutInflater.getFactory();
                ModuleInflaterFactory moduleFactory = new ModuleInflaterFactory(factory, getClassLoader());
                mLayoutInflater.setFactory(moduleFactory);
            }
            return mLayoutInflater;
        }
        return obj;
    }
}
