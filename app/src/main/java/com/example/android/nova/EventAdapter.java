package com.example.android.nova;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    public EventAdapter(Context context, ArrayList<Event> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Event currentEvent = getItem(position);

        TextView eventNameTextView = (TextView) listItemView.findViewById(R.id.event_name_text_view);
        eventNameTextView.setText(currentEvent.getEventName());

        TextView eventTypeTextView = (TextView) listItemView.findViewById(R.id.event_type_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        eventTypeTextView.setText(currentEvent.getEventType());

        // Return the list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
