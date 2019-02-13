package com.base.lib.base;

import android.databinding.ViewDataBinding;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib.base
 * @FileName     : BaseView.java
 * @Author       : chao
 * @Date         : 2019/1/27
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public abstract class BaseView<T extends ViewDataBinding> implements BaseContract.View {

    public abstract <Q extends BaseContract.ViewModel> void bindData(Q model);

}
