package ir.aryanmo.utilsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.aryanmo.utils.BaseActivity
import ir.aryanmo.utils.utils.checkDir

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logE("salam")

        logError("salam","error")
    }
}
