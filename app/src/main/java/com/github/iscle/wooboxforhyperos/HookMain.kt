package com.github.iscle.wooboxforhyperos

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage

class HookMain : IXposedHookZygoteInit, IXposedHookLoadPackage {
    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        TODO("Not yet implemented")
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        TODO("Not yet implemented")
    }
}