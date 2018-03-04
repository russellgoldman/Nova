package com.example.android.nova;

public class Event {

    /** Event Type */
    private String mEventType;

    /** Event Name*/
    private String mEventName;

    public Event(String eventName, String eventType) {
        mEventName = eventName;
        mEventType = eventType;
    }

    /**
     * Get the default translation of the word.
     */
    public String getEventName() {
        return mEventName;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getEventType() {
        return mEventType;
    }

}
