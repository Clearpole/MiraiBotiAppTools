package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import java.io.File


class power_group {
    companion object {
        suspend fun addGroup(group: Long,subject:Group,message:MessageChain): Any? {
            if (isAddGroup(group)) {
               subject.sendMessage(message.quote()+"本群已被授权！")
            } else {
                val BotAdmin: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
                val nowBotAdmin = BotAdmin + "-" + group.toString()
                File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").writeText(nowBotAdmin)
                subject.sendMessage(message.quote()+"授权成功！")
            }
            return null
        }

        suspend fun delGroup(group: Long,subject: Group,message: MessageChain): Any? {
            if (!isAddGroup(group)) {
                subject.sendMessage(message.quote()+"取消授权失败：本来就没有授权本群。")
            } else {
                val BotAdmin: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
                val nowBotAdmin = BotAdmin.replace("-" + group.toString(), "")
                File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").writeText(nowBotAdmin)
                subject.sendMessage(message.quote()+"取消授权成功。")
            }
            return null
        }

        fun isAddGroup(group: Long): Boolean {
            val BotAdmin: String =
                File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
            return BotAdmin.contains(group.toString())
        }
    }
}
