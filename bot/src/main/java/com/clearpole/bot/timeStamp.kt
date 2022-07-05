package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import org.json.JSONObject
import java.net.URL

class timeStamp {
    companion object{
        suspend fun timeStamp(subject: Group , message:MessageChain) :Any? {
            val info =
                URL("http://vv.video.qq.com/checktime?otype=json").readText()
                    .replace("QZOutputJson=", "")
            val back = JSONObject(info)
            val sjc_1 = back.getString("t")
            subject.sendMessage(message.quote() + sjc_1)
            return null
        }
    }
}