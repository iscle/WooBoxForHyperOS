package com.github.iscle.wooboxforhyperos.hooks

import android.app.Activity
import com.github.iscle.wooboxforhyperos.data.WooBoxPreferences
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge.hookAllMethods
import de.robv.android.xposed.callbacks.XC_LoadPackage
import timber.log.Timber

object SecurityCenterHooks : BaseHook {
    private lateinit var classLoader: ClassLoader

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "com.miui.securitycenter") return
        else Timber.d("Hooking security center")

        classLoader = lpparam.classLoader
        bypassAdbInputApply()
    }

    /*
     * USB debugging (Security settings)
     */
    private fun bypassAdbInputApply() {
        if (WooBoxPreferences.bypassAdbInputApply) {
            hookAllMethods(
                classLoader.loadClass("com.miui.permcenter.install.AdbInputApplyActivity"),
                "onCreate",
                object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam) {
                        Timber.d("Bypassing AdbInputApply")
                        classLoader.loadClass("android.os.SystemProperties")
                            .getMethod("set", String::class.java, String::class.java)
                            .invoke(null, "persist.security.adbinput", "1")
                        (param.thisObject as Activity).finish()
                    }
                }
            )
        }
    }
}