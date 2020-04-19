package com.example.ostatnia_wersja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.ostatnia_wersja.tasks.TaskListContent;

public class ContactAdder extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_adder);
    }

    public void addClick(View view) {
        EditText taskNameEdit = findViewById(R.id.taskName);
        EditText taskSurnameEdit = findViewById(R.id.taskSurname);
        EditText taskDateEdit = findViewById(R.id.taskDate);
        EditText taskNumberEdit = findViewById(R.id.taskDate);

        String taskName = taskNameEdit.getText().toString();
        String taskSurname = taskSurnameEdit.getText().toString();
        String taskDate = taskDateEdit.getText().toString();
        String taskNumber = taskNumberEdit.getText().toString();



        if(taskName.isEmpty() && taskSurname.isEmpty() && taskDate.isEmpty() && taskNumber.isEmpty()) {
            TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size()+1,
                    getString(R.string.default_name),
                    getString(R.string.default_surname),
                    getString(R.string.default_date),
                    getString(R.string.default_number)));
        }else{
            if(taskName.isEmpty())
                taskName = getString(R.string.default_name);
            if(taskSurname.isEmpty())
                taskSurname = getString(R.string.default_surname);
            if(taskDate.isEmpty())
                taskDate = getString(R.string.default_date);
            if(taskNumber.isEmpty())
                taskNumber = getString(R.string.default_number);
            TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                    taskName,
                    taskSurname,
                    taskDate,
                    taskNumber));
        }
        ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();
        Button buttonAdd = findViewById(R.id.addButton);
        final String finalTaskName = taskName;
        final String finalTaskSurname = taskSurname;
        final String finalTaskDate = taskDate;
        final String finalTaskNumber = taskNumber;
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactAdder.this, MainActivity.class);
                intent.putExtra("Imie", finalTaskName);
                intent.putExtra("Nazwisko", finalTaskSurname);
                intent.putExtra("Urodziny", finalTaskDate);
                intent.putExtra("Numer", finalTaskNumber);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
        taskNameEdit.setText("");
        taskSurnameEdit.setText("");
        taskDateEdit.setText("");
        taskNumberEdit.setText("");

        //InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {

    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {

    }

    @Override
    public void onListFragmentDeleteInteraction(int position) {

    }
}