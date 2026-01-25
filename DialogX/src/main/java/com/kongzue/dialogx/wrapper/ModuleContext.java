package com.kongzue.dialogx.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

public class ModuleContext extends ContextWrapper {
    private LayoutInflater mLayoutInflater;

    public ModuleContext(Context base) {
        super(base);
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
                ModuleInflaterFactory factory = new ModuleInflaterFactory(mLayoutInflater.getFactory(), getClassLoader());
                mLayoutInflater.setFactory(factory);
            }
            return mLayoutInflater;
        }
        return obj;
    }
}
