package com.kongzue.dialogx.wrapper;

public class ModuleClassLoader extends ClassLoader {
    private static ModuleClassLoader instance;
    private final ClassLoader moduleLoader;

    private ModuleClassLoader(ClassLoader parent) {
        super(parent);
        this.moduleLoader = parent;
    }

    public static ModuleClassLoader getInstance() {
        if (instance == null) {
            instance = new ModuleClassLoader(ModuleClassLoader.class.getClassLoader());
        }
        return instance;
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
