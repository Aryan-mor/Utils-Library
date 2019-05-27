package com.aryanmo.utilsexample

import android.os.Bundle
import com.aryanmo.utils.BaseActivity
import com.aryanmo.utils.utils.*
import com.aryanmo.utils.utils.log.DEFAULT_LOG_MODE
import com.aryanmo.utils.utils.log.LOG_ERROR_MODE
import com.aryanmo.utils.utils.log.log
import com.aryanmo.utils.utils.log.logThis
import kotlin.math.log

class MainActivity : BaseActivity(true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DEFAULT_LOG_MODE = LOG_ERROR_MODE

        statusBarColor = android.R.color.holo_red_light

        log(":DDDDDDDDDDDDDDD")
//        log("mylog -> " + getString("{{test1}}{{test2}}{{test3}}"), logType = LOG_ERROR_MODE)
        log("mylog -> " + getString("{{test1}}{{test2}}"), logType = LOG_ERROR_MODE)



//
//        val recorder = VoiceRecorder(this)
//
//
////        recorder.setOutputFileDir(getExternalFilesDir(Environment.getDataDirectory().absolutePath).absolutePath)
////        recorder.setOutputFileDir(Environment.getExternalStorageDirectory().absolutePath,"recording")
//        stop.isEnabled = false
//        play.isEnabled = false
//        record.setOnClickListener {
//            log(":DDDDDDDDDDDDD")
//            log(":1")
//            if (recorder.isInitialize())
//                log("resetRecord -> " + recorder.resetRecorder())
//            log(":2")
//            log("startRecorder -> " + recorder.startRecorder())
//            log(":3")
//            record.isEnabled = false
//            stop.isEnabled = true
//            longToast("Recording started").show()
//        }
//
//        stop.setOnClickListener {
//            log("stopRecorder -> " + recorder.stopRecorder())
//            record.isEnabled = true
//            stop.isEnabled = false
//            play.isEnabled = true
//            toast("Audio Recorder stopped").show()
//        }
//
//        play.setOnClickListener {
//            log("recorder play" + recorder.playRecorder())
//            toast("Playing Audio").show()
//        }


//        val a = "ba salam khedmate shoma"
//
//        val map = hashMapOf<String, String>()
//        map["a"] = "b"
//        map["c"] = "d"
//
//        val json = map.toJson()
//        "json -> $json".logThis()
//        val newMap = json?.hydrate(HashMap<String, String>()::class.java)
////        newMap?.forEach {
////            log("key -> ${it.key}   |   val -> ${it.value}")
////        }
//        newMap!!.log()
//
//        log("md5 -> " + a.md5())
//        intentTo(TestActivity::class)
    }
}
