package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import org.json.JSONObject
import java.io.File
import java.net.URL

class AppDownload {
    companion object{
        suspend fun appdownload(subject:Group , message : MessageChain):Any? {
            try {
                subject.sendMessage(message.quote() + "正在解析中，敬请等待")
                val back =
                    URL("https://yuanxiapi.cn/api/application/?keyword=" + message.content.replace(
                        "#软件下载 ",
                        "")).readText()
                val JsonFirst = JSONObject(back)
                val data = JsonFirst.getJSONArray("data")
                var forward: ForwardMessage = buildForwardMessage(subject) {}
                forward = buildForwardMessage(subject) {
                    for (i in 0 until data.length()) {
                        val json_1 = data.getJSONObject(i)
                        val name = json_1.getString("name")
                        val size = json_1.getString("size")
                        val userCount = json_1.getString("userCount")
                        val editIntro = json_1.getString("editIntro")
                        val versionName = json_1.getString("versionName")
                        val downloadurl = json_1.getString("downloadurl")
                        val icon = json_1.getString("icon")
                        val filename =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                        if (download.download(icon, filename)) {
                            val id = subject.uploadImage(File(filename).toExternalResource())
                            val chain = buildMessageChain {
                                +PlainText("应用名称：$name\n应用大小：$size\n下载次数：$userCount\n应用介绍：\n$editIntro\n应用版本：$versionName\n下载链接：\n$downloadurl")
                                +Image(id.imageId)
                            }
                            add(2241976775L, "iAppTools 应用下载分Bot", chain)
                        }
                    }
                }
                subject.sendMessage(forward)
            } catch (e: Exception) {
                error.error(message,subject, "不存在该分类！")
            }
            return null
        }
    }
}