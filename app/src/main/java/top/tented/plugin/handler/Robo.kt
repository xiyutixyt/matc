package top.tented.plugin.handler

import com.saki.aidl.PluginMsg
import top.tented.plugin.Handler
import top.tented.plugin.auary.Award
import top.tented.plugin.auary.Matv
import top.tented.plugin.auary.file
import java.io.File


/**
 * Created by XYT on 2018/2/25.
 */
object Robo : Handler("基础服务", "1.0") {
    init {
        val path:String = file.getSD("WOKT")!!
        message("抽奖") {
            val awards = listOf(
                Award("通用货币-60000", 0.1f, 100),
                Award("通用货币-40000", 0.2f, 100),
                Award("通用货币-30000", 0.3f, 100),
                Award("通用货币-300000", 0.05f, 100),
                Award("通用货币-35000", 0.2f, 100)
            )
            val hb = Matv.lottery(awards)!!.id.split("-")[1].toInt()
            File("$path/基础数据/${this.group}/${this.uin}/通用货币.txt").writeText(((File("$path/基础数据/${this.group}/${this.uin}/通用货币.txt").readText()).toInt()+hb).toString())
                    addMsg(PluginMsg.Key.Message,"恭喜您，抽到了："+ Matv.lottery(awards)!!.id)
        }
        message("根式 [0-9]+") {
            val fd = Math.sqrt(10.0)
        }
    }
}