package com.mobilization.yamblz_timeline.presentation.fragment;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobilization.yamblz_timeline.R;
import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.Teacher;
import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.EventPresenter;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    @BindView(R.id.map_image_view)
    ImageView mapImageView;
    @BindView(R.id.name_text_view)
    TextView nameTextView;
    @BindView(R.id.time_text_view)
    TextView timeTextView;
    @BindView(R.id.teacher_linear_layout)
    LinearLayout teacherLinearLayout;

    private Event event;

    @Inject
    EventPresenter presenter;

    public static EventFragment newInstance() {
        return new EventFragment();

    }


    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getAppComponent().plus(new EventModule()).plus(new ScreenModule()).inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        presenter.setModel();

        event = presenter.getEvent();

        nameTextView.setText(event.getTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM EEEE");
        timeTextView.setText(sdf.format(new Date(event.getTimestamp())));

        Picasso.with(getActivity()).load(event.getLocationLink().getLink()).into(mapImageView);

        for (Teacher teacher : event.getTeachers()) {
            addTeacherToLinearLayout(teacher);
        }

    }

    private void addTeacherToLinearLayout(Teacher teacher) {
        View teacherView = View.inflate(getActivity(), R.layout.teacher_item_layout, null);
        ImageView teacherImageView = (ImageView) teacherView.findViewById(R.id.teacher_image_view);
        TextView nameTextView = (TextView) teacherView.findViewById(R.id.name_text_view);
        TextView telegramTextView = (TextView) teacherView.findViewById(R.id.telegram_image_view);

        nameTextView.setText(teacher.getName());
        telegramTextView.setText(teacher.getTelegram());

        try{
            AssetManager mngr = getActivity().getAssets();
            InputStream BulletImgInput = mngr.open(teacher.getPhotoPath());
            //InputStream BulletImgInput = mngr.open("image/Malay/bullet.png");

            Bitmap bitmapBullet = BitmapFactory.decodeStream(BulletImgInput);
            teacherImageView.setImageBitmap(bitmapBullet);
        }catch(final IOException e){
            e.printStackTrace();
        }

        teacherLinearLayout.addView(teacherView);

    }
}
