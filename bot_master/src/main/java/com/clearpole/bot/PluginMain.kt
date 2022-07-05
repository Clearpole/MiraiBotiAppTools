package com.clearpole.bot

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MemberJoinEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.events.GroupMessageSyncEvent


object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-plugin",
        name = "Bot_Master",
        version = "0.1.0"
    )
) {
    override fun onEnable() {
        GlobalEventChannel.subscribeAlways<GroupMessageSyncEvent> {
            start(message,sender,subject)
        }
        GlobalEventChannel.subscribeAlways<GroupMessageEvent> {
            start(message,sender,subject)
        }
        GlobalEventChannel.subscribeAlways<MemberJoinEvent>
        {
            try {
                if (group.id == 239547050L) {
                    val chain = buildMessageChain {
                        +At(member.id)
                        +PlainText("欢迎加入本群，发送/help 以了解群聊Bot。")
                    }
                    group.sendMessage(chain)
                }
            } catch (e: Exception) {
                group.sendMessage(e.toString())
            }
        }
    }
}

suspend fun start(message: MessageChain, sender: Member, subject: Group): Any? {
    if (!isEmpty(message)) {
        when {
            getRealMsg(message).startsWith("禁言") -> {
                if (sender.id == 2949792646L || sender.id == 2583963775L) {
                    try {
                        val at: At = message.firstIsInstance<At>()
                        val id = at.target.toLong()
                        val list = message.content.split("//")
                        val time = list[1].toInt()
                        if (time > 2592000) {
                            subject.sendMessage("最高数值为2592000（30天），禁言时长请勿超过30天！")
                        } else {
                            subject.getMember(id)?.mute(time)
                        }
                    } catch (e: Exception) {
                        subject.sendMessage(e.toString())
                    }
                }
            }
            getRealMsg(message).startsWith("解禁") -> {
                if (sender.id == 2949792646L || sender.id == 2583963775L) {
                    try {
                        val at: At = message.firstIsInstance<At>()
                        val id = at.target.toLong()
                        subject.getMember(id)?.unmute()
                    } catch (e: Exception) {
                        subject.sendMessage(e.toString())
                    }
                }
            }
        }
    }
    return null
}

fun isEmpty(message: MessageChain): Boolean {
    return message.content.isEmpty()
}

fun getRealMsg(message: MessageChain): String {
    return message.filterIsInstance<PlainText>()[0].content
}