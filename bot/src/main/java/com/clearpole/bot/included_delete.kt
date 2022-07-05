package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChain
import java.io.File

class included_delete {
    companion object{
        suspend fun DeleteIncluded(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val list = content.split("//")
                val (v1, wjj, name) = list
                val path = "/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/" + name + ".txt"
                File(path).delete()
                val info: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/A1.收录.txt").readText()
                val scgn = info.replace("\n- " + name, "")
                val back_1 =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/A1.收录.txt").writeText(
                        scgn)
                subject.sendMessage("删除成功，你可以发送\n查看收录//" + wjj + "\n来检测是否删除成功")
            } catch (e: Exception) {
                error.error(message,subject, "格式不正确！")
            }
            return null
        }
    }
}