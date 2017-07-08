package com.mobilization.yamblz_timeline.presentation.activity;

import com.mobilization.yamblz_timeline.domain.Event;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.mobilization.yamblz_timeline.R;
import com.mobilization.yamblz_timeline.presentation.adapter.EventAdapter;
import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.view.ScheduleView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements ScheduleView {

    List<Event> mSchedule;
    @BindView(R.id.current_day) TextView mCurrentDay;
    @BindView(R.id.homework_deadline) TextView mHomeworkDeadline;
    @BindView(R.id.events_schedule) RecyclerView mEventsSchedule;
    Unbinder unbinder;

    @Inject
    SchedulePresenter mSchedulePresenter;

    EventAdapter mEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getAppComponent().plus(new EventModule()).plus(new ScreenModule()).inject(this);
        setContentView(R.layout.activity_main);

        mSchedulePresenter.getSchedule();
        mSchedule = new ArrayList<>();
        mEventAdapter = new EventAdapter(mSchedule, this);
        mEventsSchedule.setAdapter(mEventAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSchedulePresenter.bindView(this);
    }

    @Override
    public void showSchedule(List<Event> events) {
        mSchedule.addAll(events);
    }
}
