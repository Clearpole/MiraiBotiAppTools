package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Friend
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.ForwardMessage
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildForwardMessage
import java.io.File

class sendbroad {
    companion object {
        suspend fun sendbroadcast(nr: String, sender: Member, subject: Group, bot: Bot): Any? {
            try {
                val content = nr.replace("#发送广播 ", "")
                if (power_admin.isAdmin(sender.id)) {
                    val MyGroup: String =
                        File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
                    val MyGroupList = MyGroup.split("-")
                    val number = MyGroup.length - MyGroup.replace("-", "").length + 1
                    var i = 0
                    var forward: ForwardMessage = buildForwardMessage(subject) {}
                    subject.sendMessage("当前延迟时间为每个群间隔30s，这意味着您将在(GroupCount*30)s后收到反馈。")
                    forward = buildForwardMessage(subject) {
                        while (i < number) {
                            val group = bot.getGroup(MyGroupList[i].toLong())!!
                            Thread.sleep(30000L)
                            group.sendMessage(content + "\n——来自" + sender.nameCard + "(" + sender.id.toString() + ")发送的广播，序列号：" + (0..99999).random()
                                .toString())
                            add(2241976775L,
                                "iAppTools 广播发送分Bot 请勿多次发送",
                                PlainText("群聊：" + group.id.toString() + "发送广播成功"))
                            i++
                        }
                    }
                    subject.sendMessage(forward)
                } else {
                    subject.sendMessage("您并不是Bot的管理员！")
                }
            } catch (e: Exception) {
                subject.sendMessage(e.toString())
            }
            return null
        }

        suspend fun sendbroadcastForUpDate(
            nr: String,
            sender: Member,
            subject: Group,
            bot: Bot,
        ): Any? {
            try {
                if (sender.id == 2949792646L) {
                    val content = nr.replace("#发送更新广播\n", "")
                    if (power_admin.isAdmin(sender.id)) {
                        val MyGroup: String =
                            File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
                        val MyGroupList = MyGroup.split("-")
                        val number = MyGroup.length - MyGroup.replace("-", "").length + 1
                        var i = 0
                        var forward: ForwardMessage = buildForwardMessage(subject) {}
                        subject.sendMessage("当前延迟时间为每个群间隔30s，这意味着您将在(GroupCount*30)s后收到反馈。")
                        forward = buildForwardMessage(subject) {
                            while (i < number) {
                                val group = bot.getGroup(MyGroupList[i].toLong())!!
                                Thread.sleep(30000L)
                                group.sendMessage(content + "\n\n更新序列号：" + (0..99999).random()
                                    .toString())
                                add(2241976775L,
                                    "iAppTools 广播发送分Bot 请勿多次发送",
                                    PlainText("群聊：" + group.id.toString() + "发送广播成功"))
                                i++
                            }
                        }
                        subject.sendMessage(forward)
                    } else {
                        subject.sendMessage("您并不是Bot的管理员！")
                    }
                }else{
                    subject.sendMessage("无权。")
                }
            } catch (e: Exception) {
                subject.sendMessage(e.toString())
            }
            return null
        }

        suspend fun sendbroadcastForFriend(
            content: String,
            sender: Friend,
            subject: Friend,
            bot: Bot,
        ): Any? {
            try {
                if (power_admin.isAdmin(sender.id)) {
                    val MyGroup: String =
                        File("/storage/emulated/0/- AClear汤姆/iappcode/群聊.txt").readText()
                    val MyGroupList = MyGroup.split("-")
                    val number = MyGroup.length - MyGroup.replace("-", "").length + 1
                    var i = 0
                    var forward: ForwardMessage = buildForwardMessage(subject) {}
                    subject.sendMessage("当前延迟时间为30s，这意味着您将在(GroupCount*30)s后收到反馈。")
                    forward = buildForwardMessage(subject) {
                        while (i < number) {
                            val group = bot.getGroup(MyGroupList[i].toLong())!!
                            Thread.sleep(30000L)
                            group.sendMessage(content)
                            add(2241976775L,
                                "iAppTools 广播发送分Bot 请勿多次发送",
                                PlainText("群聊：" + group.id.toString() + "发送广播成功"))
                            i++
                        }
                    }
                    subject.sendMessage(forward)
                } else {
                    subject.sendMessage("您并不是Bot的管理员！")
                }
            } catch (e: Exception) {
                subject.sendMessage(e.toString())
            }
            return null
        }
    }
}