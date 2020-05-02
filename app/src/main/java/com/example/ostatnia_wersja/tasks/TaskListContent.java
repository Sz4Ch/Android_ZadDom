package com.example.ostatnia_wersja.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {


    public static final List<Task> ITEMS = new ArrayList<Task>();


    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();


    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Task createTask(int position) {
        return new Task(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
    public static void removeItem(int position) {
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    public static class Task implements Parcelable{
        public final String id;
        public final String name;
        public final String surname;
        public final String date;
        public final String picPath;
        public final String number;

        public Task(String id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.date = "";
            this.picPath = "";
            this.number = "";
        }

        public Task(String id, String name, String surname, String date, String picPath, String number) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.date = date;
            this.picPath = picPath;
            this.number = number;
        }
        protected Task(Parcel in) {
            id = in.readString();
            name = in.readString();
            surname = in.readString();
            date = in.readString();
            picPath = in.readString();
            number = in.readString();
        }
        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };

        @Override
        public String toString() {
            String content = null;
            return content;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(surname);
            dest.writeString(date);
            dest.writeString(picPath);
            dest.writeString(number);
        }
    }

}