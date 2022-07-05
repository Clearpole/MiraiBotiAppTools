package com.clearpole.bot

import net.mamoe.mirai.contact.Contact.Companion.uploadImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import java.io.File

class sendhelp {
    companion object {
        suspend fun sendhelp(subject : Group,sender:Member,message: MessageChain):Any? {
            /*
            val id = subject.uploadImage(File("/storage/emulated/0/- AClear汤姆/iappcode/.help.jpg"))
            val chain = buildMessageChain {
                + Image(id.imageId)
            }
            subject.sendMessage(message.quote()+chain)
            return null
             */
            val json = File("/storage/emulated/0/- AClear汤姆/iappcode/info.json").readText()
            val app = LightApp(json)
            subject.sendMessage(app)
            return null
        }
    }
}