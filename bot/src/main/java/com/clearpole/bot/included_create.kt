package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChain
import java.io.File

class included_create {
    companion object{
        suspend fun CreateIncluded(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val cd = content.replace("创建收录//", "").replace("cjsl//", "")
                val list = cd.split("//")
                val wjj = list[0]
                val name = list[1]
                val nr = list[2]
                val path = "/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/" + name + ".txt"
                File(path).writeText(nr)
                val info: String =
                    File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/A1.收录.txt").readText()
                val gn = info.substring(info.indexOf("-") until info.indexOf("回复 查看收录"))
                val xjgn: String =
                    "收录的内容有：\n" + gn + "- " + name + "\n回复 查看收录//" + wjj + "//名称 展开教程"
                File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/A1.收录.txt").writeText(
                    xjgn)
                subject.sendMessage("收录成功，你可以发送\n查看收录//" + wjj + "\n来检测是否收录成功")

            } catch (e: Exception) {
                error.error(message,subject,
                    "创建收录的格式不正确！我去你的！爱创不创！不能新建分类！Bot看不懂你在狗叫什么！！！")
            }
            return null
        }
    }
}