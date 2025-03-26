package com.github.iscle.wooboxforhyperos

import com.github.iscle.wooboxforhyperos.data.WooBoxPreferences
import com.github.iscle.wooboxforhyperos.hooks.AndroidHook
import com.github.iscle.wooboxforhyperos.hooks.BaseHook
import com.github.iscle.wooboxforhyperos.hooks.SecurityCenterHooks
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookZygoteInit, IXposedHookLoadPackage {
    private val hooks: List<BaseHook> = listOf(
        AndroidHook,
        SecurityCenterHooks
    )

    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        if (!WooBoxPreferences.mainSwitch) return

        hooks.forEach { hook ->
            hook.initZygote(startupParam)
        }
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (!WooBoxPreferences.mainSwitch) return

        hooks.forEach { hook ->
            hook.handleLoadPackage(lpparam)
        }
    }

}