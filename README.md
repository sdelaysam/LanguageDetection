Language Detection for Android
=========

# Introduction

This is fork of [Shuyo's language-detection library](https://github.com/shuyo/language-detection) adopted for Android.

# Including in your project

This project uses [JitPack](https://jitpack.io) to build and release.

Add JitPack to the end of your `repositories`

```
repositories {
    ...
    maven { url "https://jitpack.io" }
}
```

Add the project to your `dependencies`

```
dependencies {
    ...
    implementation 'com.github.sdelaysam:LanguageDetection:1.0.0'
}
```

# Using the library

First initialize the detection factory with needed languages.
Full list of supported language profiles [here](library/src/main/resources/profiles)


```
DetectorInitializer.init("en", "es", "ru", "tr", "fr");
```

Then create detector and provide the text
```
Detector detector = DetectorFactory.create();
detector.append("Hello");
detector.detect(); // en
```

Or check sample app to see how it works.