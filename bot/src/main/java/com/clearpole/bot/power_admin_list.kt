package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.ForwardMessage
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildForwardMessage
import java.io.File

class power_admin_list {
    companion object{
        suspend fun PowerAdminList(subject: Group): Any? {
            val BotAdmin: String =
                File("/storage/emulated/0/- AClear汤姆/iappcode/管理.txt").readText()
            val BotAdminList = BotAdmin.split("-")
            val number = BotAdmin.length - BotAdmin.replace("-", "").length + 1
            var i = 0
            var forward: ForwardMessage = buildForwardMessage(subject) {}
            forward = buildForwardMessage(subject) {
                add(2241976775L,
                    "iAppTools 列表Bot",
                    PlainText("以下是Bot的所有管理人员"))
                while (i < number) {
                    add(2241976775L,
                        "iAppTools 列表Bot",
                        PlainText("QQ：" + BotAdminList[i].toLong()))
                    i++
                }
            }
            subject.sendMessage(forward)
            return null
        }
    }
}