package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Contact.Companion.uploadImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import org.json.JSONObject
import java.io.File
import java.net.URL

class BaiduEncyclopedia {
    companion object {
        suspend fun Baidu_encyclopedia(
            content: String,
            subject: Group,
            message: MessageChain,
            bot: Bot,
            sender: Member,
        ): Any? {
            try {
                val list = content.split(" ")
                val (v1, SearchName) = list
                if (SearchName.trim() != "") {
                    val text =
                        URL("https://baike.baidu.com/api/openapi/BaikeLemmaCardApi?appid=379020&bk_key=" + SearchName).readText()
                    val json_first = JSONObject(text)
                    val back: String = json_first.getString("abstract")
                    var img = "No"
                    if (text.contains("\"image\":\"")) {
                        img = json_first.getString("image")
                    }
                    val url = json_first.getString("url")
                    if (back.contains("...")) {
                        val name: String =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                        if (img.equals("No")) {
                            subject.sendMessage(message.quote() + PlainText(back + "\n" + "详细内容请查看：" + url + "\n该百科无图片展示权。"))
                        } else {
                            if (download.download(img, name)) {
                                val id = subject.uploadImage(File(name))
                                val chain = buildMessageChain {
                                    +PlainText(back + "\n" + "详细内容请查看：" + url)
                                }
                                val chain_1 = buildMessageChain {
                                    +Image(id.imageId)
                                }
                                subject.sendMessage(message.quote() + chain)
                                subject.sendMessage(message.quote() + chain_1)
                            }
                        }
                    } else {
                        val name: String =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                        if (img.equals("No")) {
                            subject.sendMessage(message.quote() + PlainText(back + "\n该百科无图片展示权。"))
                        } else {
                            if (download.download(img, name)) {
                                val id = subject.uploadImage(File(name).toExternalResource())
                                val chain = buildMessageChain {
                                    +PlainText(back)
                                }
                                val chain_1 = buildMessageChain {
                                    +Image(id.imageId)
                                }
                                subject.sendMessage(message.quote() + chain)
                                subject.sendMessage(message.quote() + chain_1)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                if (e.toString().contains("abstract")) {
                    subject.sendMessage(message.quote() + PlainText("百度暂未收录该百科"))
                } else if (e.toString().contains("Index")) {
                    subject.sendMessage(message.quote() + PlainText("你的格式错了，我真的生气了！"))
                } else {
                    error.error(message,subject, "不存在该分类！")
                }
            }
            return null
        }
    }
}