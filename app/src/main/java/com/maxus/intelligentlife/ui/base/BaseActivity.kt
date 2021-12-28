package com.maxus.intelligentlife.ui.base

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import com.maxus.intelligentlife.utils.logD

/**
 * @User: machenglong
 * @Date: 2021/12/28
 * @Describe:
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private val TAG = "${javaClass.simpleName} == mcl"
    private var backPressTime = 0L
    lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR)
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<T>(this, getLayoutId())
        initView()
        initData()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            processBackPressed()
        }
    }

    private fun processBackPressed() {
        val now = System.currentTimeMillis()
        if (now - backPressTime > 2000) {
            Toast.makeText(this, "再次点击退出应用", Toast.LENGTH_SHORT).show()
            backPressTime = now
        } else {
            super.onBackPressed()
        }
    }

    abstract fun getLayoutId(): Int

    open fun initView() {}

    open fun initData() {}

}