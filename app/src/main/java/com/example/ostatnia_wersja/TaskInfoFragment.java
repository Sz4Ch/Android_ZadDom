package com.example.ostatnia_wersja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ostatnia_wersja.tasks.TaskListContent;


import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskInfoFragment extends Fragment {

    public TaskInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false);
    }
    public void displayTask(TaskListContent.Task task) {
        FragmentActivity activity = getActivity();

        TextView taskInfoName = activity.findViewById(R.id.taskInfoName);
        TextView taskInfoSurname = activity.findViewById(R.id.taskInfoSurname);
        TextView taskInfoDate = activity.findViewById(R.id.taskInfoDate);
        TextView taskInfoNumber = activity.findViewById(R.id.taskInfoNumber);
        ImageView taskInfoImage = activity.findViewById(R.id.taskInfoImage);

        taskInfoName.setText(task.name);
        taskInfoSurname.setText(task.surname);
        taskInfoDate.setText(task.date);
        taskInfoNumber.setText(task.number);

        Drawable taskDrawable;
        int[] images = {
                R.drawable.avatar_1,
                R.drawable.avatar_2,
                R.drawable.avatar_3,
                R.drawable.avatar_4,
                R.drawable.avatar_5,
                R.drawable.avatar_6,
                R.drawable.avatar_7,
                R.drawable.avatar_8,
                R.drawable.avatar_9,
                R.drawable.avatar_10,
                R.drawable.avatar_11,
                R.drawable.avatar_12,
                R.drawable.avatar_13,
                R.drawable.avatar_14,
                R.drawable.avatar_15,
                R.drawable.avatar_16
        };
        Random rand = new Random();
        taskDrawable = activity.getResources().getDrawable(images[rand.nextInt(images.length)]);
        taskInfoImage.setImageDrawable(taskDrawable);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        if(intent != null){
            TaskListContent.Task receiverTask = intent.getParcelableExtra(MainActivity.taskExtra);
            if(receiverTask != null){
                displayTask(receiverTask);
            }
        }
    }
}