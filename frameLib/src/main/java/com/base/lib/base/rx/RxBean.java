package com.base.lib.base.rx;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib
 * @FileName     : RxBean.java
 * @Author       : chao
 * @Date         : 2019/1/23
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class RxBean {

    public RxBean(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
