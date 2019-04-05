package ir.aryanmo.utils.utils.utilsClass

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Environment
import ir.aryanmo.utils.utils.checkDir
import ir.aryanmo.utils.utils.log.logError
import java.io.File

class VoiceRecorder(private val context: Context) {

    companion object {
        fun getDefaultVoiceDir(context: Context): String {
            return "${context.filesDir}/voice"
        }

        fun getVoiceList(context: Context): Array<out File> {
            return getVoiceList(getDefaultVoiceDir(context))
        }

        fun getVoiceList(path: String): Array<out File> {
            return File(path).listFiles()
        }
    }

    private lateinit var recorder: MediaRecorder
    private lateinit var outPutFileDir: String
    private var audioSource: Int = 0
    private var outputFormat: Int = 0
    private var audioEncoder: Int = 0
    private var initialize = false


    init {
        initialize()
    }

    @SuppressLint("SdCardPath")
    private fun initialize() {
        recorder = MediaRecorder()
        setAudioSource(MediaRecorder.AudioSource.DEFAULT)
        setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
        setOutputFileDir("${getDefaultVoiceDir(context)}/voice-${Date(format = "yyyy-MM-dd HH:mm:ss")}")
        initialize = false
    }

    fun isInitialize(): Boolean {
        return initialize
    }

    fun setAudioSource(audioSource: Int) {
        this.audioSource = audioSource
        recorder.setAudioSource(audioSource)
    }

    fun setOutputFormat(outputFormat: Int) {
        this.outputFormat = outputFormat
        recorder.setOutputFormat(outputFormat)
    }

    fun setAudioEncoder(audioEncoder: Int) {
        this.audioEncoder = audioSource
        recorder.setAudioEncoder(audioEncoder)
    }

    fun setOutputFileDir(outPutFile: String): Boolean {
        if (checkDir(outPutFile)) {
            this.outPutFileDir = outPutFile
            recorder.setOutputFile(outPutFile)
            return true
        }
        return false
    }

    fun setOutputFileName(outPutFile: String) = setOutputFileDir(outputFileName("${context.packageName}/$outPutFile"))

    fun getOutputFile() = outPutFileDir

    fun startRecorder(): Boolean {
        return try {
            initialize = true
            recorder.prepare()
            recorder.start()
            true
        } catch (e: Exception) {
            logError("startRecorder", e)
            false
        }
    }

    fun stopRecorder(): Boolean {
        return try {
            recorder.stop()
            recorder.release()
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getRecord(outPutFileDir: String): MediaPlayer? {
        return return try {
            val mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(outPutFileDir)
            mediaPlayer.prepare()
            mediaPlayer
        } catch (e: Exception) {
            null
        }
    }

    fun getRecord(): MediaPlayer? {
        return getRecord(getOutputFile())
    }

    fun playRecorder(): Boolean {
        try {
            getRecord()?.let {
                it.start()
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun resetRecorder(): Boolean {
        try {
            initialize()
            return true
        } catch (e: Exception) {
            logError("resetRecorder", e)
        }
        return false
    }

    fun getVoiceList(): Array<out File> {
        return getVoiceList(outPutFileDir)
    }

    private fun outputFileName(fileName: String): String {
        return Environment.getExternalStorageDirectory().absolutePath + "/$fileName.3gp"
    }
}