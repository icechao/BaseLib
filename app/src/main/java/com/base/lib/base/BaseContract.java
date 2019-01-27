package com.base.lib.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ViewDataBinding;

import java.io.Serializable;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib
 * @FileName     : BaseContract.java
 * @Author       : chao
 * @Date         : 2019/1/26
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public interface BaseContract {

    /**
     * View类型所有的Activity或Fragment都需要实现
     */
    interface View {

        public <Q extends BaseContract.ViewModel> void bindData(Q model);

        public <T extends BaseContract.ViewModel> T getViewModel();
    }

    interface Presenter<T extends BaseContract.View> {

    }

    interface NetWork {

    }

    interface ViewModel extends Serializable {

    }
}
