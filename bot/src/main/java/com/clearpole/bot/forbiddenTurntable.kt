package com.clearpole.bot

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import java.io.File

class forbiddenTurntable {
    companion object{
        suspend fun ForbiddenTurntable(
            content: String,
            subject: Group,
            message: MessageChain,
            bot: Bot,
            sender: Member,
        ): Any? {
            try {
                val sjs = (1..9).random()
                when {
                    sjs.equals(1) -> {
                        val time = "1天！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(2) -> {
                        val time = "1小时！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(3) -> {
                        val time = "1分钟！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(4) -> {
                        val time = "30天！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(5) -> {
                        val time = "2小时！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(6) -> {
                        val time = "3天！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(7) -> {
                        val time = "5分钟！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(8) -> {
                        val time = "10分钟！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                    sjs.equals(9) -> {
                        val time = "30分钟！"
                        val imgpath =
                            "/storage/emulated/0/- AClear汤姆/iappcode/.禁言转盘/" + sjs + ".png"
                        val id = subject.uploadImage(File(imgpath).toExternalResource())
                        val chain = buildMessageChain {
                            +PlainText("请及时联系管理员领取奖励\n")
                            +PlainText("恭喜禁言：" + time)
                            +Image(id.imageId)
                        }
                        subject.sendMessage(message.quote() + chain)
                    }
                }
            } catch (e: Exception) {
                error.error(message,subject, "未知原因，请等待开发者回复！")
            }
            return null
        }
    }
}