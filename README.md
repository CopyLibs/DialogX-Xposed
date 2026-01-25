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
```

### 对话框

```kotlin
MessageDialog.build()
  .setTitle("标题")
  .setMessage("内容")
  .setOkButton("确定")
  .show()
```

## 致谢

- [DialogX](https://github.com/kongzue/DialogX)
- [DialogX](https://github.com/suzhelan/DialogX)