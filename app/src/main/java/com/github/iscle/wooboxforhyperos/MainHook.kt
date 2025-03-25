package com.github.iscle.wooboxforhyperos

import android.util.Log
import com.github.iscle.wooboxforhyperos.data.WooBoxPreferences
import com.github.iscle.wooboxforhyperos.hooks.BaseHook
import com.github.iscle.wooboxforhyperos.hooks.SecurityCenterHooks
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookZygoteInit, IXposedHookLoadPackage {
    private val hooks: List<BaseHook> = listOf(
        SecurityCenterHooks
    )

    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        if (!WooBoxPreferences.mainSwitch) return

        hooks.forEach { hook ->
            Log.d("WooBox", "initZygote: $hook")
            hook.initZygote(startupParam)
        }
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (!WooBoxPreferences.mainSwitch) return

        hooks.forEach { hook ->
            Log.d("WooBox", "handleLoadPackage: $hook")
            hook.handleLoadPackage(lpparam)
        }
    }

}