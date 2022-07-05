package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Friend
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.ForwardMessage
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildForwardMessage

class forgeMessage {
    companion object{
        suspend fun ForgeMessage(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val list = content.replace("#构造聊天\n", "").split("\n")
                var list_1 = content.split("\n")
                var sz: Int = 0
                var jl: Int = 0
                var name = ""
                var user = ""
                var msg = ""
                var forward: ForwardMessage = buildForwardMessage(subject) {}
                forward = buildForwardMessage(subject) {
                    for (i in list) {
                        //subject.sendMessage(i.toString())
                        list_1 = i.toString().split(" ")
                        user = list_1[0]
                        name = list_1[1]
                        msg = list_1[2]
                        add(user.toLong(), name.toString(), PlainText(msg.toString()))
                    }
                }
                subject.sendMessage(forward)
            } catch (e: Exception) {
                error.error(message,subject, "格式错误！")
            }
            return null
        }
        suspend fun ForgeMessageForFriend(
            content: String,
            subject: Friend,
        ): Any? {
            try {
                val list = content.replace("#构造聊天\n", "").split("\n")
                var list_1 = content.split("\n")
                var name = ""
                var user = ""
                var msg = ""
                var forward: ForwardMessage = buildForwardMessage(subject) {}
                forward = buildForwardMessage(subject) {
                    for (i in list) {
                        //subject.sendMessage(i.toString())
                        list_1 = i.toString().split(" ")
                        user = list_1[0]
                        name = list_1[1]
                        msg = list_1[2]
                        add(user.toLong(), name.toString(), PlainText(msg.toString()))
                    }
                }
                subject.sendMessage(forward)
            } catch (e: Exception) {
                subject.sendMessage("格式错误！")
            }
            return null
        }
    }
}