package ir.aryanmo.utilsexample

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import ir.aryanmo.utils.BaseActivity
import ir.aryanmo.utils.utils.checkDir
import ir.aryanmo.utils.utils.log.DEFAULT_LOG_MODE
import ir.aryanmo.utils.utils.log.LOG_ERROR_MODE
import ir.aryanmo.utils.utils.utilsClass.VoiceRecorder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DEFAULT_LOG_MODE = LOG_ERROR_MODE

        val recorder = VoiceRecorder(this)


//        recorder.setOutputFileDir(getExternalFilesDir(Environment.getDataDirectory().absolutePath).absolutePath)
//        recorder.setOutputFileDir(Environment.getExternalStorageDirectory().absolutePath,"recording")
        stop.isEnabled = false
        play.isEnabled = false
        record.setOnClickListener {
            log(":DDDDDDDDDDDDD")
            log(":1")
            if (recorder.isInitialize())
                log("resetRecord -> " + recorder.resetRecorder())
            log(":2")
            log("startRecorder -> " + recorder.startRecorder())
            log(":3")
            record.isEnabled = false
            stop.isEnabled = true
            longToast("Recording started").show()
        }

        stop.setOnClickListener {
            log("stopRecorder -> " + recorder.stopRecorder())
            record.isEnabled = true
            stop.isEnabled = false
            play.isEnabled = true
            toast("Audio Recorder stopped").show()
        }

        play.setOnClickListener {
            log("recorder play" + recorder.playRecorder())
            toast("Playing Audio").show()
        }
    }
}
