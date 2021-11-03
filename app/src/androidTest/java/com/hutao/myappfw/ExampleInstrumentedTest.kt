package com.hutao.myappfw

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apkfuns.logutils.LogUtils
import com.hutao.myappfw.module.main.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.hutao.myappfw", appContext.packageName)
    }

    @Test
    fun testDoLog(){
        LogUtils.d("12345!!")
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(appContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addCategory("coding")
        intent.action = "action"
        LogUtils.i(intent)
    }

}