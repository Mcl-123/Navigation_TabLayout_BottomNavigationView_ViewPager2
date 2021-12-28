package com.maxus.intelligentlife.ui.intelligent

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.maxus.intelligentlife.ui.intelligent.device.DeviceFragment
import com.maxus.intelligentlife.ui.intelligent.scene.SceneFragment

/**
 * @User: machenglong
 * @Date: 2021/12/28
 * @Describe:
 */
class IntelligentFragmentStateAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeviceFragment()
            else -> SceneFragment()
        }
    }
}