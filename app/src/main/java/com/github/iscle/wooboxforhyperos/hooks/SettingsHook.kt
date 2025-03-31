package com.github.iscle.wooboxforhyperos.hooks

import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.XposedHelpers.findClass
import de.robv.android.xposed.XposedHelpers.findMethodExact
import de.robv.android.xposed.callbacks.XC_LoadPackage
import timber.log.Timber

object SettingsHook : BaseHook {
    private lateinit var classLoader: ClassLoader

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "com.android.settings") return
        classLoader = lpparam.classLoader

        hookToggleAccessibilityServicePreferenceFragment()
    }

    private fun hookToggleAccessibilityServicePreferenceFragment() {
        try {
            val clazz = findClass(
                "com.android.settings.accessibility.ToggleAccessibilityServicePreferenceFragment",
                classLoader
            )
            val replacementMethod = findMethodExact(
                clazz,
                "showPopupDialog",
                Int::class.javaPrimitiveType
            )
            findAndHookMethod(
                clazz,
                "showAppBarrierFreeTip",
                Int::class.javaPrimitiveType,
                object : XC_MethodReplacement() {
                    override fun replaceHookedMethod(param: MethodHookParam): Any? {
                        return replacementMethod.invoke(param.thisObject, *param.args)
                    }
                }
            )
        } catch (e: Exception) {
            Timber.e(e, "Could not hook ToggleAccessibilityServicePreferenceFragment")
        }
    }
}