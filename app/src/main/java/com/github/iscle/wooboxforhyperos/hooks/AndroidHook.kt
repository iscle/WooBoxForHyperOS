package com.github.iscle.wooboxforhyperos.hooks

import de.robv.android.xposed.callbacks.XC_LoadPackage

class AndroidHook : BaseHook {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "android") return


    }

    private fun disableFlagSecure() {

    }
}