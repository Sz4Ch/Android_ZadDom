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

import java.util.Random;

public class ContactAdder extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_adder);
    }

    public void addClick(View view) {
        EditText taskNameEdit = findViewById(R.id.taskName);
        EditText taskSurnameEdit = findViewById(R.id.taskSurname);
        EditText taskDateEdit = findViewById(R.id.taskDate);
        EditText taskNumberEdit = findViewById(R.id.taskNumber);

        String taskName = taskNameEdit.getText().toString();
        String taskSurname = taskSurnameEdit.getText().toString();
        String taskDate = taskDateEdit.getText().toString();
        String taskNumber = taskNumberEdit.getText().toString();



        Random rand = new Random();
        int random_number = rand.nextInt(6);


        if(taskName.isEmpty() && taskSurname.isEmpty() && taskDate.isEmpty() && taskNumber.isEmpty()) {
            TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size()+1,
                    getString(R.string.default_name),
                    getString(R.string.default_surname),
                    getString(R.string.default_date),
                    getString(R.string.default_image),
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
            if(random_number == 1){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }else if(random_number == 2){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }else if(random_number == 3){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }else if(random_number == 4){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }else if(random_number == 5){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }else if(random_number == 6){
                final String random_pic = Integer.toString(random_number);
                TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                        taskName,
                        taskSurname,
                        taskDate,
                        random_pic,
                        taskNumber));

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
                        intent.putExtra("Zdjęcie", random_pic);
                        intent.putExtra("Numer", finalTaskNumber);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
            }


        }
        taskNameEdit.setText("");
        taskSurnameEdit.setText("");
        taskDateEdit.setText("");
        taskNumberEdit.setText("");
    }

}