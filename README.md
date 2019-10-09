# launcher-app-android

## Application ID
Every Android app has a unique application ID, such as `com.mycompany.myintranet`. It uniquely identifies your app on the device and on the Google Play Store. So once you publish your app, *you should never change the application ID*.
Set the application ID in the `app/build.gradle` file:
```
android {
    defaultConfig {
        applicationId "com.mycompany.myintranet"
        ...
    }
    ...
}
```

## Icon
The easiest way to update app icon is to go inside the folder `/app/src/main/res/`. Then you have to replace all images under `mipmap-*` folders with same name, same extension (png) and correct size.
Useful links and specifications:
- [Google Play Icon Design Specifications](https://developer.android.com/google-play/resources/icon-design-specifications/)
- [Adaptive Icon on developer.android.com](https://developer.android.com/guide/practices/ui_guidelines/icon_design_adaptive)
- [Product icons on Material.io](https://material.io/design/iconography/product-icons.html)
- [Designing Adaptive Icon](https://medium.com/google-design/designing-adaptive-icons-515af294c783)

## Application name and wording

Application name and texts are defined in `strings.xml` files located under `/app/src/main/res/values-*/` folders.

The default language of the application (english) is defined on the `/values/strings.xml` file.
The french translations is defined on the `/values-fr/strings.xml` file.

By default the application is only localized for this two languages.
To add support for more locales, create additional directories and `strings.xml` files inside `res/` folder. 

Each directory's name adhere to the following format:
`values-<language code>` 

For example, `values-es/strings.xml` contains string resources for locales with the language code `es`.

Create the resource subdirectories and files to support. For example:
```
    values/
        strings.xml
    values-en/
        strings.xml
    values-es/
        strings.xml
    values-it/
        strings.xml
```
