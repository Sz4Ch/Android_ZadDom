package com.example.ostatnia_wersja;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ostatnia_wersja.TaskFragment.OnListFragmentInteractionListener;
import com.example.ostatnia_wersja.tasks.TaskListContent;

import java.util.List;
import java.util.Random;


public class MyTaskRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder> {

    private final List<TaskListContent.Task> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTaskRecyclerViewAdapter(List<TaskListContent.Task> items, TaskFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        TaskListContent.Task task = mValues.get(position);
        holder.mItem = task;
        holder.mContentView.setText(task.name);

        final String picPath = task.picPath;
        Context context = holder.mView.getContext();
        if(picPath !=null && !picPath.isEmpty())
        {
            Drawable taskDrawable;
            switch (picPath){
                case "1":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_1);
                    break;
                case "2":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_2);
                    break;
                case "3":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_3);
                    break;
                case "4":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_4);
                    break;
                case "5":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_5);
                    break;
                case "6":
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_6);
                    break;
                default:
                    taskDrawable = context.getResources().getDrawable(R.drawable.avatar_7);
            }
            holder.mItemImageView.setImageDrawable(taskDrawable);

        }else
        {
            holder.mItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_1));
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentClickInteraction(holder.mItem, position);
                }
            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onListFragmentLongClickInteraction(position);
                return false;
            }
        });

        holder.mItemImageButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onListFragmentDeleteInteraction(position);
            }
        });





    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final ImageView mItemImageView;
        public final ImageButton mItemImageButtonView;
        public TaskListContent.Task mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImageView = (ImageView) view.findViewById(R.id.item_image);
            mContentView = (TextView) view.findViewById(R.id.content);
            mItemImageButtonView = (ImageButton) view.findViewById(R.id.item_image_button);
        }

        @Override
        public String toString() {

            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}