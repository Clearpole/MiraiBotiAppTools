package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.Image.Key.queryUrl
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.firstIsInstance

class imageUrl {
    companion object{
        suspend fun imageUrl(sunject:Group,message :MessageChain):Any?{
            val img = message.firstIsInstance<Image>()
            sunject.sendMessage(message.quote()+img.queryUrl())
            return null
        }
    }
}