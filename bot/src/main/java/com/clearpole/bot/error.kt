package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote

class error {
    companion object {
        suspend fun error(
            message : MessageChain,
            subject: Group,
            bz: String,
        ): Any? {
            subject.sendMessage(message.quote()+bz)
            return null
        }
    }
}
