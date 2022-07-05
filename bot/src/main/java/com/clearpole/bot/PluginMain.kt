package com.clearpole.bot

import com.clearpole.bot.forgeMessage.Companion.ForgeMessage
import com.clearpole.bot.forgeMessage.Companion.ForgeMessageForFriend
import net.mamoe.mirai.Bot
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.Contact.Companion.uploadImage
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.*
import net.mamoe.mirai.message.data.*
import java.awt.SystemColor.text
import java.io.File
import java.net.URL


/**
 * By Clear汤姆 QQ 2949792646
 * 转载请注明原开发者
 */
object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-plugin",
        name = "ExamplePlugin",
        version = "0.1.0"
    )
) {
    override fun onEnable() {
        val before = "#"
        GlobalEventChannel.subscribeAlways<BotInvitedJoinGroupRequestEvent> {
            /* Bot收到加群申请的事件 */
            val admin = bot.getFriend(2949792646L)!!
            admin.sendMessage("您有新的加群邀请，请上号查看！")
        }
        GlobalEventChannel.subscribeAlways<BotJoinGroupEvent> {
            /* Bot加入群聊的事件 */
            val chain = buildMessageChain {
                +PlainText("大家好！今天开始我就要开始为大家服务啦！快点发送#help 来敲醒我吧！")
                +Image(group.uploadImage(File("/storage/emulated/0/- AClear汤姆/iappcode/.welcome.jpg")).imageId)
            }
            group.sendMessage(chain)
        }
        GlobalEventChannel.subscribeAlways<GroupMessageEvent> {
            /* Bot在群聊接收到消息的事件 */
            //所有指令的前缀
            val helpRegex =
                Regex("$before(([Hh][Ee][Ll][Pp])|菜单|帮助|bot|机器人|开机)").matches(message.content.trim()
                    .replace("\n", ""))
            //帮助
            val baiduRegex =
                Regex("$before(((([Bb]|百)([Dd]|度))|)(((([Bb]|百)([Kk]|科))|)|(([Ss]|搜)([Ss]|索)))) (.*)").matches(
                    message.content.trim().replace("\n", ""))
            //百度百科
            val iAppHotRegex = Regex("$before([iI][Aa][Pp]([Pp]|))").matches(message.content.trim()
                .replace("\n", ""))
            //iApp的热度趋势
            val v3officialRegex =
                Regex("$before([Vv]3) (.*)").matches(message.content.trim().replace("\n", ""))
            //iApp v3的官方文档
            val v5officialRegex =
                Regex("$before([Vv]5) (.*)").matches(message.content.trim().replace("\n", ""))
            //iApp v5的官方文档
            val ijsOfficialRegex =
                Regex("$before([iI][Jj][Ss]) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //iApp ijs的官方文档
            val iJavaOfficialRegex =
                Regex("$before([Ii][Jj][Aa][Vv][Aa]) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //iApp iJava的官方文档
            val iLuaOfficialRegex =
                Regex("$before([Ii][Ll][Uu][Aa]) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //iApp iLua的官方文档
            val forgeMessage =
                Regex("$before(?s)((构|[Gg])(造|[Zz])(聊|[Ll])(天|[Tt]))(.*?)").matches(message.content)
            //构造聊天
            val isAdminRegex =
                Regex("$before(([Gg]|管)([Ll]|理)(([Yy]|员)|)((([Ll]|列)([Bb]|表))|))").matches(message.content.trim()
                    .replace("\n", ""))
            //管理员列表
            val addAdminRegex =
                Regex("$before((添|[Tt])(加|[Jj])(管|[Gg])(理|[Ll])(员|[Yy]))(.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //添加管理员
            val delAdminRegex =
                Regex("$before((删|[Ss])(除|[Cc])(管|[Gg])(理|[Ll])(员|[Yy]))(.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //删除管理员
            val isPowerGroup =
                Regex("$before((授|[Ss])(权|[Qq])((群|[Qq])|)(((列|[Ll])(表|[Bb]))|))").matches(message.content.trim()
                    .replace("\n", ""))
            //授权群列表
            val addPowerGroupRegex =
                Regex("$before((授|[Ss])(权|[Qq])(本|[Bb])(群|[Qq]))").matches(message.content.trim()
                    .replace("\n", ""))
            //授权本群
            val delPowerGroupRegex =
                Regex("$before((取|[Qq])(消|[Xx])(本|[Bb])(群|[Qq])(((授|[Ss])(权|[Qq]))|))").matches(
                    message.content.trim().replace("\n", ""))
            //取消本群授权
            val replaceRegex = Regex("$before((替|[Tt])(换|[Hh]))(.*)").matches(message.content.trim()
                .replace("\n", ""))
            //替换
            val tiktokRegex =
                Regex("$before((抖|[Dd])(音|[Yy])(((解|[Jj])(析|[Xx]))|)) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //抖音解析
            val appRegex =
                Regex("$before((((软|[Rr])(件|[Jj]))|)(((下|[Xx])(载|[Zz]))|)) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //软件下载
            val sendUpdateBroadRegex =
                Regex("$before((发|[Ff])(送|[Ss])(更|[Gg])(新|[Xx])(((广|[Gg])(播|[Bb]))|))(.*)").matches(
                    message.content.trim().replace("\n", ""))
            //发送更新广播
            val sendBroadRegex =
                Regex("$before((发|[Ff])((送|[Ss])|)((广|[Gg])(播|[Bb]))) (.*)").matches(message.content.trim()
                    .replace("\n", ""))
            //发送广播
            val timeStampRegex =
                Regex("$before((时|[Ss])(间|[Jj])((戳|[Cc])|))").matches(message.content.trim()
                    .replace("\n", ""))
            //时间戳
            val imageUrlRegex =
                Regex("$before((图|[Tt])((片|[Pp])|)(((直|[Zz])(链|[Ll]))|))").containsMatchIn(message.content.trim()
                    .replace("\n", ""))
            //图片直链
            when {
                message.content == before + "状态" -> {
                    val instance = Bot.getInstance(2241976775L)
                    subject.sendMessage("$instance#状态正常。")
                }
                helpRegex -> {
                    sendhelp.sendhelp(subject, sender, message)
                }
                baiduRegex -> {
                    BaiduEncyclopedia.Baidu_encyclopedia(message.content,
                        subject,
                        message,
                        bot,
                        sender)
                }

                iAppHotRegex -> {
                    iApp_hot.iAppHot(subject, message)
                }
                v3officialRegex -> {
                    official_v3.getiAppGfWDForV3(message.content, subject, bot, message, sender)
                }
                v5officialRegex -> {
                    official_v5.getiAppGfWDForV5(message.content, subject, bot, message, sender)
                }
                ijsOfficialRegex -> {
                    official_ijs.getiAppGfWDForIjs(message.content, subject, bot, message, sender)
                }
                iJavaOfficialRegex -> {
                    official_ijava.getiAppGfWDForIjava(message.content,
                        subject,
                        bot,
                        message,
                        sender)
                }
                iLuaOfficialRegex -> {
                    official_ilua.getiAppGfWDForIlua(message.content, subject, bot, message, sender)
                }
                forgeMessage -> {
                    com.clearpole.bot.forgeMessage.ForgeMessage(message.content,
                        subject,
                        bot,
                        message,
                        sender)
                }
                tiktokRegex -> {
                    tiktok.tiktok(subject, message)
                }
                appRegex -> {
                    AppDownload.appdownload(subject, message)
                }
                replaceRegex -> {
                    replace.replace(message.content, subject, bot, message, sender)
                }
                isAdminRegex -> {
                    power_admin_list.PowerAdminList(subject)
                }
                isPowerGroup -> {
                    power_group_list.PowerGroupList(subject)
                }
                addPowerGroupRegex -> {
                    power_group.addGroup(group.id, subject, message)
                }
                delPowerGroupRegex -> {
                    power_group.delGroup(group.id, subject, message)
                }
                sendUpdateBroadRegex -> {
                    sendbroad.sendbroadcastForUpDate(message.content, sender, subject, bot)
                }
                sendBroadRegex -> {
                    sendbroad.sendbroadcast(message.content, sender, subject, bot)
                }
                timeStampRegex -> {
                    timeStamp.timeStamp(subject, message)
                }
                imageUrlRegex -> {
                    imageUrl.imageUrl(subject, message)
                }
                addAdminRegex -> {
                    power_admin.addAdmin(subject, message)
                }
                delAdminRegex -> {
                    power_admin.delAdmin(subject, message)
                }
                message.firstIsInstance<At>().target == 2241976775L || message.firstIsInstance<At>().target == 3515029694L -> {
                    val json = File("/storage/emulated/0/- AClear汤姆/iappcode/info.json").readText()
                    val app = LightApp(json)
                    group.sendMessage(app)
                }
            }
        }
        GlobalEventChannel.subscribeAlways<FriendMessageEvent> {
            /* 接收到来自私聊的消息 */
            val forgeMessage =
                Regex("$before(?s)((构|[Gg])(造|[Zz])(聊|[Ll])(天|[Tt]))(.*?)").matches(message.content)
            friend.sendMessage("Bot已接收到您的反馈，请等待开发者回复。")
            val admin = bot.getFriend(2949792646L)!!
            admin.sendMessage(PlainText("您有新的消息请回复：\n${message.content}\n来自QQ：${sender.id}"))
            when {
                forgeMessage -> {
                    ForgeMessageForFriend(message.content, friend)
                }
            }

        }
        GlobalEventChannel.subscribeAlways<FriendAddEvent> {
            /* 机器人成功添加一个好友 */
            friend.sendMessage("你好，加我有什么事情吗？或者直接拉我进群哦！")
        }
        GlobalEventChannel.subscribeAlways<MemberJoinEvent> {
            /* 新成员入群事件 */
            val json = File("/storage/emulated/0/- AClear汤姆/iappcode/welcome.json").readText()
            val app = LightApp(json)
            group.sendMessage(app)
        }
        GlobalEventChannel.subscribeAlways<NudgeEvent> {
            /* 戳一戳事件 */
            subject.sendMessage("你在戳什么呢？疼疼疼！")
        }
        GlobalEventChannel.subscribeAlways<BotUnmuteEvent> {
            /* 机器人被解除禁言 */
            val at = At(operator.id)
            group.sendMessage(at + "把我解除禁言啦！我自由啦！")
        }
        GlobalEventChannel.subscribeAlways<MemberMuteEvent> {
            /* 群成员被禁言 */
            val at = At(member.id)
            group.sendMessage(at + "被管理员禁言了！请大家引以为戒！不要挑战小黑屋的权威！")
        }
        GlobalEventChannel.subscribeAlways<MemberCardChangeEvent> {
            /* 群成员改名 */
            val at = At(member.id)
            group.sendMessage(at+"改名了\n改名前: $origin \n改名后: $new")
            if (new.contains("http")||new.contains(".com")||new.contains("www")||new.contains(".cn")||new.contains(".top")||new.contains(".org")||new.contains(".xyz")){
                val atAdmin = At(target = 2949792646L)
                group.sendMessage(atAdmin+"检测到${member.id}的群名片包含链接，请各位管理员火速处理！")
            }
        }
    }
}

