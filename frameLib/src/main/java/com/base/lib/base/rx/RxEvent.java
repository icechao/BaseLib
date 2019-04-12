package com.base.lib.base.rx;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib
 * @FileName     : RxEvent.java
 * @Author       : chao
 * @Date         : 2019/1/23
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class RxEvent {

    private int eventThread;
    private String eventType;
    private Object data;

    public RxEvent(String eventType, int eventThread) {
        this.eventType = eventType;
        this.eventThread = eventThread;
    }

    public RxEvent(String eventType, int eventThread, Object data) {
        this.eventType = eventType;
        this.eventThread = eventThread;
        this.data = data;
    }

    public int getEventThread() {
        return eventThread;
    }

    public void setEventThread(int eventThread) {
        this.eventThread = eventThread;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
