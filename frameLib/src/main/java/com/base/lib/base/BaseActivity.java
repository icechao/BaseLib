package com.base.lib.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class BaseActivity<T extends BasePresenter, Q extends ViewDataBinding> extends AppCompatActivity {

    private T presenter;
    private Q binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initPresenter((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        getLifecycle().addObserver(presenter);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), getViewId(), null, false);
        setContentView(binding.getRoot());
    }

    protected void initPresenter(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(BaseContract.View.class);
            presenter = constructor.newInstance(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public abstract int getViewId();

}
