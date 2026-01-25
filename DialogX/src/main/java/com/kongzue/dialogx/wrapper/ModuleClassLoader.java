package com.kongzue.dialogx.wrapper;

public class ModuleClassLoader extends ClassLoader {
    public static ModuleClassLoader getInstance() {
        return new ModuleClassLoader();
    }

    private final ClassLoader moduleLoader;

    public ModuleClassLoader() {
        moduleLoader = getClass().getClassLoader();
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try {
            Class<?> clazz = moduleLoader.loadClass(name);
            if (clazz != null) return clazz;
        } catch (Throwable ignored) {
        }
        return super.loadClass(name, resolve);
    }
}
