package com.clearpole.bot

import io.ktor.client.utils.*
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import org.json.JSONObject
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

class tiktok {
    companion object {
        suspend fun tiktok(subject: Group, message: MessageChain): Any? {
            if (message.content.replace("抖音解析 ", "").startsWith("http")) {
                subject.sendMessage(message.quote() + "正在解析中")
                val name = message.content.replace("抖音解析 ", "")
                val back =
                    URL("https://api.tsyinpin.com/douyin_video.php?url=" + name).readText()
                val json = JSONObject(back)
                val video = json.getJSONObject("video")
                val realVideo = video.getString("realUrl")
                val cover = video.getString("cover")
                val nickname = video.getString("nickname")
                val desc = video.getString("desc")
                val music = json.getJSONObject("music")
                val musicurl = music.getString("music")
                val filename =
                    "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                if (download.download(cover, filename)) {
                    val id = subject.uploadImage(File(filename).toExternalResource())
                    var forward: ForwardMessage = buildForwardMessage(subject) {}
                    forward = buildForwardMessage(subject) {
                        val chain = buildMessageChain {
                            +PlainText("视频封面：")
                            +Image(id.imageId)
                        }
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("解析成功"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("视频作者：\n$nickname"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("视频介绍：\n$desc"))
                        add(2241976775L,
                            "iAppTools 抖音解析分Bot",
                            PlainText("无水印视频链接：\n$realVideo"))
                        add(2241976775L,
                            "iAppTools 抖音解析分Bot",
                            PlainText("用浏览器打开视频链接即可下载，首选via浏览器。"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", chain)
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("音频链接：\n$musicurl"))
                    }
                    subject.sendMessage(forward)
                }
            } else {
                subject.sendMessage(message.quote() + "正在解析中")
                val name = message.content.replace("抖音解析 ", "")
                val url = name.substring(name.indexOf("https"), name.indexOf(" 复制"))
                val back =
                    URL("https://api.tsyinpin.com/douyin_video.php?url=" + url).readText()
                val json = JSONObject(back)
                val video = json.getJSONObject("video")
                var realVideo = video.getString("realUrl")
                val cover = video.getString("cover")
                val nickname = video.getString("nickname")
                val desc = video.getString("desc")
                val music = json.getJSONObject("music")
                val musicurl = music.getString("music")
                val url_1 = URL(realVideo)
                var  redirectUrl =""
                val conn = url_1.openConnection() as HttpURLConnection
                conn.instanceFollowRedirects = false
                val code = conn.responseCode
                if (code == 302){
                     redirectUrl = conn.getHeaderField("Location")
                }
                if (redirectUrl!=null){
                    realVideo = redirectUrl
                    conn.disconnect()
                }
                val filename =
                    "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                if (download.download(cover, filename)) {
                    val id = subject.uploadImage(File(filename).toExternalResource())
                    var forward: ForwardMessage = buildForwardMessage(subject) {}
                    forward = buildForwardMessage(subject) {
                        val chain = buildMessageChain {
                            +PlainText("视频封面：")
                            +Image(id.imageId)
                        }
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("解析成功"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("视频作者：\n$nickname"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("视频介绍：\n$desc"))
                        add(2241976775L,
                            "iAppTools 抖音解析分Bot",
                            PlainText("无水印视频链接：\n$realVideo"))
                        add(2241976775L,
                            "iAppTools 抖音解析分Bot",
                            PlainText("用浏览器打开视频链接即可下载，首选via浏览器。"))
                        add(2241976775L, "iAppTools 抖音解析分Bot", chain)
                        add(2241976775L, "iAppTools 抖音解析分Bot", PlainText("音频链接：\n$musicurl"))
                    }
                    subject.sendMessage(forward)
                }
            }
            return null
        }
    }
}