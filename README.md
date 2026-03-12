# DialogX-Xposed

![JitPack Version](https://img.shields.io/jitpack/version/com.github.CopyLibs/DialogX-Xposed)

DialogX Support For Xposed

## 依赖

```kotlin
implementation("com.github.CopyLibs.DialogX-Xposed:DialogX:$version")
```

## 用法

### 官方文档

- [简体中文](https://github.com/kongzue/DialogX/blob/master/README.md)

- [English](https://github.com/kongzue/DialogX/blob/master/README_EN.md)

- [繁體中文](https://github.com/kongzue/DialogX/blob/master/README_TC.md)

### 初始化

```kotlin
DialogX.init(context)
ModuleUtil.modulePath = "模块安装包文件路径"
```

### 基础对话框

```kotlin
MessageDialog.build()
    .setTitle("标题")
    .setMessage("内容")
    .setOkButton("确定")
    .show()
```

### 自定义布局

```kotlin
MessageDialog.build()
    .setTitle("标题")
    .setCustomView(object : OnBindView<MessageDialog>(R.layout.module_setting_dialog) {
        override fun onBind(dialog: MessageDialog, v: View) {}
    })
    .show()

MessageDialog.build()
    .setTitle("标题")
    .setCustomView(object : OnBindingView<MessageDialog, ModuleSettingDialogBinding>() {
        override fun onBind(dialog: MessageDialog, v: View, binding: ModuleSettingDialogBinding) {}
    })
    .show()
```

## 致谢

- [kongzue@DialogX](https://github.com/kongzue/DialogX) - 原始仓库
- [suzhelan@DialogX](https://github.com/suzhelan/DialogX) - Xposed 支持
