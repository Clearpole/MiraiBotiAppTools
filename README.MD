# iAppTools

基于Mirai，由Kotlin编写的iApp机器人。


## 配置文件
可前往 https://clearpole.lanzouv.com/ixsIf07e429c 下载zip，然后解压到`/storage/emulated/0/- AClear汤姆/`里，解压后的完整路径应该是`/storage/emulated/0/- AClear汤姆/iappcode/`。
否则无法使用机器人。

## 打包apk？
请打包正式apk！不要debug！

##在哪里运行apk？
https://github.com/mzdluo123/MiraiAndroid 请学习。

#代码编写

## 更改Android应用信息

请到`app\src\main\AndroidManifest.xml`和`app/build.gradle`按照注释更改信息

请在``

## 编写代码

请在`bot`模块下编写你的代码，例如`bot\src\main\java\com\example\bot\PluginMain.kt`

如果你想要更改包名称，需要同时更改`bot\src\main\resources\META-INF\services\net.mamoe.mirai.console.plugin.jvm.JvmPlugin`中的信息

## 测试

本模板已内置mirai-console和MiraiAndroid快捷启动方式，请使用idea或AndroidStudio打开

## 发布

运行`buildPlugin`task即可编译jvm平台下的jar文件，文件可在`bot\build\libs\bot.jar`找到

请在菜单内找到生成签名的apk文件来发布Android插件

## 无法使用？

请检查本地是否有路径，且检查miraiAndroid是否支持读取本地文件。

请联系开发者`QQ 2949792646`，附带代码，截图，报错信息，态度诚恳地询问问题，收费or免费取决于态度和附带信息。


欢迎您Star！不懂得问题可以联系开发者哦！`可付费定制属于自己的机器人`。
