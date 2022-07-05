package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChain

class replace {
    companion object{
        suspend fun replace(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val list = content.split("//")
                val (v1, v2, v3, v4) = list
                val scz = v2.replace(v3, v4)
                subject.sendMessage(scz.toString())
            } catch (e: Exception) {
                error.error(message,subject,"未知错误或格式错误！")
            }
            return null
        }
    }
}