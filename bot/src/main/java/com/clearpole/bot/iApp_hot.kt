package com.clearpole.bot

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.PlainText
import org.json.JSONObject
import java.io.File
import java.net.URL

class iApp_hot {
    companion object{
        suspend fun iAppHot(subject : Group , message: MessageChain) :Any? {
            subject.sendMessage(message.quote() + PlainText("正在解析中..."))
            val back =
                URL("https://yuanxiapi.cn/api/Douyinhome/?url=https://v.douyin.com/FuhrHvV/").readText()
            val jsonFirst = JSONObject(back)
            try {
                val tf = jsonFirst.getString("msg")
                if (tf == "查询成功") {
                    val name = jsonFirst.getString("name")
                    val works = jsonFirst.getString("works")
                    val fans = jsonFirst.getString("fans")
                    val laud = jsonFirst.getString("laud")
                    val sign = jsonFirst.getString("sign")
                    val gfid = jsonFirst.getString("id")
                    val jsonback =
                        File("/storage/emulated/0/- AClear汤姆/iappcode/.缓存/抖音/info.json").readText()
                    val jsonbackOne = JSONObject(jsonback)
                    val lastWorks = jsonbackOne.getString("works").toInt()
                    val lastFans = jsonbackOne.getString("fans").toInt()
                    val lastlaud = jsonbackOne.getString("laud").toInt()
                    var worksType = "错误"
                    var fansType = "错误"
                    var laudType = "错误"
                    var worksNow = (works.toInt() - lastWorks).toString()
                    var fansNow = (fans.toInt() - lastFans).toString()
                    var laudNow = (laud.toInt() - lastlaud).toString()
                    if (worksNow.contains("-")) {
                        worksType = "减少"
                        worksNow = worksNow.replace("-", "")
                    } else {
                        worksType = "增加"
                    }
                    if (fansNow.contains("-")) {
                        fansType = "减少"
                        fansNow = fansNow.replace("-", "")
                    } else {
                        fansType = "增加"
                    }
                    if (laudNow.contains("-")) {
                        laudType = "减少"
                        laudNow = fansNow.replace("-", "")
                    } else {
                        laudType = "增加"
                    }
                    var type = "趋势计算失败"
                    if (fans.toInt() < lastFans) {
                        type = "小幅下降"
                        if (laud.toInt() < lastlaud) {
                            type = "大幅下降，风评降低"
                        }
                    } else if (fans.toInt() > lastFans && laud.toInt() > lastlaud) {
                        type = "稳步上升"
                    } else {
                        type = "不稳定地小幅上升"
                    }
                    subject.sendMessage(message.quote() + PlainText("“$sign”\n\n$name 本着以上原则，截至目前在抖音平台一共拥有$works 个宣传作品，收获了$fans 个粉丝和$laud 个获赞。\n\n对比上次更新数据：\n[$worksType]了$worksNow 个作品\n[$fansType]了$fansNow 个粉丝\n[$laudType]了$laudNow 个点赞\n\n在抖音的热度趋势为\n“$type”。\n\n大家可以去抖音搜索官方UID：$gfid ，助力iApp的开发与宣传。"))
                } else {
                    subject.sendMessage(message.quote() + PlainText("查询失败"))
                }
            } catch (e: Exception) {
                subject.sendMessage(e.toString())
            }
            return null
        }
        suspend fun iAppHotUpDate(sender : Member , subject: Group , message: MessageChain) :Any? {
            if (power_admin.isAdmin(sender.id)) {
                subject.sendMessage(message.quote() + PlainText("正在更新中..."))
                val back =
                    URL("https://yuanxiapi.cn/api/Douyinhome/?url=https://v.douyin.com/FuhrHvV/").readText()
                val jsonFirst = JSONObject(back)
                try {
                    val tf = jsonFirst.getString("msg")
                    if (tf == "查询成功") {
                        val works = jsonFirst.getString("works")
                        val fans = jsonFirst.getString("fans")
                        val laud = jsonFirst.getString("laud")
                        val jsonback =
                            File("/storage/emulated/0/- AClear汤姆/iappcode/.缓存/抖音/info.json").readText()
                        val jsonbackOne = JSONObject(jsonback)
                        jsonbackOne.put("works", works)
                        jsonbackOne.put("fans", fans)
                        jsonbackOne.put("laud", laud)
                        File("/storage/emulated/0/- AClear汤姆/iappcode/.缓存/抖音/info.json").writeText(
                            jsonbackOne.toString())
                        subject.sendMessage(message.quote() + PlainText("更新成功！"))
                    } else {
                        subject.sendMessage(message.quote() + PlainText("更新失败"))
                    }
                } catch (e: Exception) {
                    error.error(message,subject,"错误")
                }
            } else {
                subject.sendMessage(message.quote() + PlainText("您无权更新。"))
            }
            return null
        }
    }
}