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


public class TaskInfoFragment extends Fragment {

    public TaskInfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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


        if(task.picPath != null && !task.picPath.isEmpty())
        {
            Drawable taskDrawable;
            switch (task.picPath){
                case "1":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);
                    break;
                case "2":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_2);
                    break;
                case "3":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_3);
                    break;
                case "4":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_4);
                    break;
                case "5":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_5);
                    break;
                case "6":
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_6);
                    break;
                default:
                    taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_7);
            }
            taskInfoImage.setImageDrawable(taskDrawable);
        }
        else {
            taskInfoImage.setImageDrawable(activity.getResources().getDrawable(R.drawable.avatar_7));
        }

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