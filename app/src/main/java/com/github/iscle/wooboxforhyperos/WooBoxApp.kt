package com.github.iscle.wooboxforhyperos

import android.app.Application
import de.robv.android.xposed.XposedBridge
import timber.log.Timber

class WooBoxApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.plant(object : Timber.Tree() {
            override fun log(
                priority: Int,
                tag: String?,
                message: String,
                t: Throwable?
            ) {
                XposedBridge.log("$tag: $message")
                if (t != null) {
                    XposedBridge.log(t)
                }
            }
        })
    }
}