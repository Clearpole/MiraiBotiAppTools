package com.clearpole.bot

import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.content

class messagelegality {
    companion object{
        fun isEmpty(message: MessageChain): Boolean {
            return message.content.isEmpty()
        }

        fun getRealMsg(message: MessageChain): String {
            return message.content
        }
    }
}