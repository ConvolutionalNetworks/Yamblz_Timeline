package com.mobilization.yamblz_timeline.presentation.activity;

import com.mobilization.yamblz_timeline.domain.Event;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mobilization.yamblz_timeline.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    List<Event> mSchedule;
    @BindView(R.id.current_day) TextView mCurrentDay;
    @BindView(R.id.homework_deadline) TextView mHomeworkDeadline;
    @BindView(R.id.events_schedule) TextView mEventsSchedule;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSchedule = new ArrayList<>();
    }
}
