package com.example.android.nova;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ResourcesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        // Create a list of words
        ArrayList<Event> words = new ArrayList<>();
        words.add(new Event("Waterloo Mates", "Workshop"));
        words.add(new Event("Waterloo Therapy", "Program"));
        words.add(new Event("Waterloo Therapy", "Workshop"));
        words.add(new Event("Waterloo Also Therapy", "Program"));
        words.add(new Event("Waterloo Help Desk", "Program"));
        words.add(new Event("Waterloo CS Help", "Workshop"));
        words.add(new Event("Waterloo Therapy", "Program"));
        words.add(new Event("Waterloo Therapy", "Program"));
        words.add(new Event("Waterloo Therapy", "Workshop"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        EventAdapter adapter = new EventAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
