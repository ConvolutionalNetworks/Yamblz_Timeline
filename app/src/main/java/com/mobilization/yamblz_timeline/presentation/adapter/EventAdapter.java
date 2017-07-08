package com.mobilization.yamblz_timeline.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobilization.yamblz_timeline.R;
import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.Teacher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Алексей on 08.07.2017.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Event> mValues;
    private Context context;
    private View.OnClickListener listener;





    public EventAdapter(List<Event> items, Context context, View.OnClickListener listener) {
        mValues = items;
        this.context = context;
        this.listener = listener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mItem = mValues.get(position);

        myViewHolder.title.setText(myViewHolder.mItem.getTitle());
        StringBuilder sb = new StringBuilder();
        for (Teacher teacher : myViewHolder.mItem.getTeachers()) {
            sb.append(teacher.getName());
            sb.append("\n");
        }
        long time = myViewHolder.mItem.getTimestamp();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy EEEE");
        myViewHolder.day.setText(sdf.format(new Date(time)));

        myViewHolder.teachers.setText(sb.toString());

        myViewHolder.mView.setOnClickListener(listener);






    }

    @Override
    public int getItemCount() {

        return mValues.size();

    }

    @Override
    public int getItemViewType(int position) {
       return 0;
    }





    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView day;

        public final TextView title;
        public final TextView teachers;

        public Event mItem;


        public MyViewHolder(View view) {
            super(view);
            mView = view;


            day = (TextView) view.findViewById(R.id.day);
            
            title = (TextView) view.findViewById(R.id.title);
            teachers = (TextView) view.findViewById(R.id.teachers);

        }

        
    }




}
