package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.ForwardMessage
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildForwardMessage
import org.json.JSONObject
import java.io.File
import java.net.URL

class included_open {
    companion object{
        suspend fun OpenIncluded(
            content: String,
            subject: Group,
            bot: Bot,
            message: MessageChain,
            sender: Member,
        ): Any? {
            try {
                val cd: Int = content.replace("查看收录", "").replace("cksl", "").length
                val th = content.replace("查看收录", "").replace("cksl", "").replace("//", "").length
                val rc = cd - th
                if (rc == 2) {
                    val list = content.split("//")
                    val (v1, wjj) = list
                    val info: String =
                        File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/A1.收录.txt").readText()
                    val nr = info.substring(info.indexOf("\n") + 2 until info.indexOf("回复 查看收录//"))
                        .replace("-", "").replace(" ", "")
                    val nrList = nr.split("\n")
                    val number = nr.length - nr.replace("\n", "").length + 1
                    var i = 0
                    var forward: ForwardMessage = buildForwardMessage(subject) {}
                    forward = buildForwardMessage(subject) {
                        add(2241976775L,
                            "iAppTools 收录专用分Bot",
                            PlainText("分类域：" + wjj + "\n" + "回复格式：\n查看收录//$wjj//代码名称"))
                        add(2241976775L,
                            "iAppTools 收录专用分Bot",
                            PlainText("查看收录//$wjj//"))
                        while (i < number) {
                            add(2241976775L,
                                "iAppTools 收录专用分Bot",
                                PlainText(nrList[i].toString()))
                            i++
                        }
                    }
                    subject.sendMessage(forward)
                } else if (rc == 4) {
                    val list = content.split("//")
                    val (v1, wjj, name) = list
                    val jsoninfo = URL("http://vv.video.qq.com/checktime?otype=json").readText()
                        .replace("QZOutputJson=", "")
                    val back = JSONObject(jsoninfo)
                    val sjc_1 = back.getString("t")
                    val xx_1: Int = sjc_1.toInt() - 33
                    val xx_2: Int = sjc_1.toInt() - 22
                    val txt: String =
                        File("/storage/emulated/0/- AClear汤姆/iappcode/收录/" + wjj + "/" + name + ".txt").readText()
                    val forward: ForwardMessage = buildForwardMessage(subject) {
                        add(2241976775L,
                            "iAppTools 收录专用分Bot",
                            PlainText("分类域：" + wjj + "\n代码名：" + name),
                            xx_2)
                        add(2241976775L, "iAppTools 收录专用分Bot", PlainText(txt.trim()), xx_1)
                    }
                    subject.sendMessage(forward)
                }
            } catch (e: Exception) {
                error.error(message,subject, "格式不正确或不存在该收录！")
            }
            return null
        }
    }
}