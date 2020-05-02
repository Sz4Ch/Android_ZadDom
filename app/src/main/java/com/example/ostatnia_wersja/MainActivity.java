package com.example.ostatnia_wersja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ostatnia_wersja.tasks.TaskListContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements
        TaskFragment.OnListFragmentInteractionListener,
        DeleteDialog.OnDeleteDialogInteractionListener,
        CallDialog.OnCallDialogInteractionListener{

    private int currenItemPosition = -1;
    public static final String taskExtra = "taskExtra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContacts();
            }
        });


    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {
        Toast.makeText(this,getString(R.string.item_selected_msg) + position, Toast.LENGTH_SHORT).show();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            displayTaskInfoFragment(task);
        }else{
            startSecondActivity(task, position);
        }

    }

    @Override
    protected void onActivityResult(int requestedCode, int resultCode, Intent data) {
        super.onActivityResult(requestedCode, resultCode, data);

        if(requestedCode == 1 ) {
            if(resultCode == RESULT_OK) {
                Intent intent = getIntent();
                String taskImie = intent.getStringExtra("Imie");
                String taskNazwisko = intent.getStringExtra("Nazwisko");
                String taskUrodziny = intent.getStringExtra("Urodziny");
                String taskZdjecie = intent.getStringExtra("Zdjęcie");
                String taskNumer = intent.getStringExtra("Numer");
                TaskListContent.addItem(new TaskListContent.Task("Task" + TaskListContent.ITEMS.size() +1,
                        taskImie,
                        taskNazwisko,
                        taskUrodziny,
                        taskZdjecie,
                        taskNumer));

            }
        }
        ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();

    }
    private void showDeleteDialog(){
        DeleteDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.delete_dialog_question_tag));
    }

    private void showCallDialog(){
        CallDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.call_dialog_tag));
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {

        showCallDialog();
    }

    @Override
    public void onListFragmentDeleteInteraction(int position) {
        Toast.makeText(this,getString(R.string.delete_click_msg) + position,Toast.LENGTH_SHORT).show();
        showDeleteDialog();
        currenItemPosition = position;
    }

    public void openContacts() {
        Intent intent = new Intent(this, ContactAdder.class);
        startActivityForResult(intent, 1);
    }

    private void startSecondActivity(TaskListContent.Task task, int position) {
        Intent intent = new Intent(this, TaskInfoActivity.class);
        intent.putExtra(taskExtra, task);
        startActivity(intent);
    }
    private void displayTaskInfoFragment(TaskListContent.Task task){
        TaskInfoFragment taskInfoFragmet = ((TaskInfoFragment) getSupportFragmentManager().findFragmentById(R.id.displayFragment));
        if(taskInfoFragmet != null){
            taskInfoFragmet.displayTask(task);
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if(currenItemPosition != -1 && currenItemPosition < TaskListContent.ITEMS.size()){
            TaskListContent.removeItem(currenItemPosition);
            ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        View v = findViewById(R.id.item_image_button);
        if(v != null){
            Snackbar.make(v,getString(R.string.delete_cancel_msg),Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.retry_msg), new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            showDeleteDialog();
                        }
                    }).show();
        }
    }

    @Override
    public void onCallDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onCallDialogNegativeClick(DialogFragment dialog) {

    }
}