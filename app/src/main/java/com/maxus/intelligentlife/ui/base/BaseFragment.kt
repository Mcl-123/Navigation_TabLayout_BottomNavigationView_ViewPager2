package com.maxus.intelligentlife.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * @User: machenglong
 * @Date: 2021/12/28
 * @Describe:
 */
abstract class BaseFragment<T: ViewDataBinding> : Fragment() {

    lateinit var mBinding: T
     val TAG = "${javaClass.simpleName} == mcl"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    open fun initView() {}

    open fun initData() {}
}