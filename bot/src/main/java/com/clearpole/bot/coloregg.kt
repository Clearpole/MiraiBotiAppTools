package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChain
import org.json.JSONObject
import java.io.File
import java.net.URL

class coloregg {
    companion object{
        suspend fun 二次元真恶心(bot:Bot,sender:Member,subject:Group,message:MessageChain) :Any?{
            val back =
                URL("https://img.xjh.me/random_img.php?return=json").readText()
            val json_first = JSONObject(back)
            try {
                val imgurl: String = "https:" + json_first.getString("img")
                val name: String =
                    "/storage/emulated/0/- AClear汤姆/iappcode/.缓存/" + (1000000..999999999).random() + ".jpg"
                if (download.download(imgurl, name)) {
                    subject.sendImage(File(name))
                } else {
                }
            } catch (e: Exception) {
                error.error(message,subject,"未知错误")
            }
            return null
        }
    }
}