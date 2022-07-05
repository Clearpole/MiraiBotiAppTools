package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import org.json.JSONObject
import java.io.File
import java.net.URL

class official_v5 {
    companion object{
        suspend fun getiAppGfWDForV5(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val info = URL("http://vv.video.qq.com/checktime?otype=json").readText()
                    .replace("QZOutputJson=", "")
                val back = JSONObject(info)
                val sjc_1 = back.getString("t")
                val xx_1: Int = sjc_1.toInt() - 333
                val xx_2: Int = sjc_1.toInt() - 222
                val xx_3: Int = sjc_1.toInt() - 111
                val CodeName = content.replace("#v5 ", "").replace("#v5 ", "")
                if (CodeName.trim() == "") {
                } else {
                    val yv = "v5"
                    val json = File("/storage/emulated/0/- AClear汤姆/iappcode/read.json").readText()
                    val app = LightApp(json)
                    val back = URL("https://sakuraplayer.dthqsz.club/iapptools/writeread.php?code=$yv&codename=$CodeName").readText()
                    if (back=="修改成功") {
                        subject.sendMessage(app)
                    }else{
                        subject.sendMessage(message.quote()+"服务器链接失败！")
                    }
                }
            } catch (e: Exception) {
                error.error(message,subject,"不存在该代码！")
            }
            return null
        }
    }
}