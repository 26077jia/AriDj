package com.aritime.aridj.base;

/**
 * Created by jiajia on 2016/10/18.
 */

public interface BaseView<T> {
    /**
     * 使用fragment作为view时，将activity中的presenter传递给fragment
     * @param presenter
     */
    void setPresenter(T presenter);
}
