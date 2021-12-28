package com.maxus.intelligentlife

import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED
import com.maxus.intelligentlife.databinding.ActivityMainBinding
import com.maxus.intelligentlife.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        mBinding.bottomNavigationView.labelVisibilityMode = LABEL_VISIBILITY_LABELED

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        mBinding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun initData() {

    }
}