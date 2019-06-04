package com.aryanmo.utilsexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aryanmo.utils.utils.getExtra
import com.aryanmo.utils.utils.log.logE

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        logE("getExtra is -> " + getExtra("key", Int::class.java)!!)

    }

}
