package com.baladroid.baseapp.view.base.fragments

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

interface ViewModelOwner<Binding : ViewDataBinding, out Model> {

    /**
     * Returns the layout resource for this activity.
     */
    @LayoutRes
    fun getLayoutRes(): Int

    /**
     * Returns the variable id that is used for the [ViewModel] returned by
     * [createViewModel] in the layout file.
     * ```
     * <!-- getModelId() must return BR.viewModel in the following case -->
     *  <data>
     *      <variable
     *          name="viewModel"
     *          value="com.test.abc.xyz.testViewModel"/>
     *  </data>
     * ```
     */
    fun getModelId(): Int

    /**
     * Returns the ViewModel.
     *
     * ```
     * override fun createViewModel() = ViewModelProviders.of(this).get(MyViewModel::class.java)
     * ```
     */
    fun createViewModel(): Model

    /**
     * Returns the lifecycle owner. This will be `this` in the most cases.
     */
    fun provideLifecycleOwner(): LifecycleOwner

    /**
     * Called when the [ViewDataBinding] is created. This happens in the onCreate method of
     * activities and in the onCreateView method of fragments.
     */
    fun onBindingCreated(binding: Binding)
}
