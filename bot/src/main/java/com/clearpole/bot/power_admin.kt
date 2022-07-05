package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.firstIsInstance
import java.io.File

class power_admin {
    companion object{
        suspend fun addAdmin(subject:Group,message:MessageChain): Any? {
            val at = message.firstIsInstance<At>()
            val sender = at.target
            if (isAdmin(sender)) {
                subject.sendMessage(message.quote()+"这个人已经是管理员了。")
            } else {
                val BotAdmin: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").readText()
                val nowBotAdmin = BotAdmin + "-" + sender.toString()
                File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").writeText(nowBotAdmin)
                subject.sendMessage(message.quote()+"添加管理员成功。")
            }
            return null
        }

        suspend fun delAdmin(subject: Group,message: MessageChain): Any? {
            val at = message.firstIsInstance<At>()
            val sender = at.target
            if (!isAdmin(sender)) {
                subject.sendMessage(message.quote()+"删除失败：这个人本来就不是管理员。")
            } else {
                val BotAdmin: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").readText()
                val nowBotAdmin = BotAdmin.replace("-" + sender.toString(), "")
                File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").writeText(nowBotAdmin)
                subject.sendMessage(message.quote()+"删除管理员成功。")
            }
            return null
        }

        fun isAdmin(sender: Long): Boolean {
            val BotAdmin: String =
                File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").readText()
            return BotAdmin.contains(sender.toString())
        }
    }
}