package com.mobilization.yamblz_timeline.presentation.mvp.common;

public interface BasePresenter<View>  {

    void setModel();

    void bindView(View view);
}
