package com.maxus.intelligentlife.ui.intelligent

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.maxus.intelligentlife.R
import com.maxus.intelligentlife.databinding.FragmentIntelligentBinding
import com.maxus.intelligentlife.ui.base.BaseFragment
import com.maxus.intelligentlife.utils.logD

class IntelligentFragment : BaseFragment<FragmentIntelligentBinding>() {

    companion object {
        val tabs = arrayOf("设备", "场景")
    }

    override fun getLayoutId(): Int = R.layout.fragment_intelligent

    override fun initView() {

        mBinding.viewPager.adapter = IntelligentFragmentStateAdapter(requireActivity())
        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }
}