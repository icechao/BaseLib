package com.base.lib.base;

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

        <Q extends BaseContract.ViewModel> void setViewModel(Q model);

        <Q extends BaseContract.ViewModel> Q getViewModel();
    }

    interface Presenter<T extends BaseContract.View> {

    }

    interface DataLogicWork {

    }

    interface ViewModel extends Serializable {

    }
}
