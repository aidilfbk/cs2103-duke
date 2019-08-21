public class Event extends Task {
    protected String eventDateTime;

    public Event(String description, String dateTime) {
        super(description);
        this.eventDateTime = dateTime;
    }

    /**
     * Getter for when this Event occurs.
     *
     * @return Date and time of this Event.
     */
    public String getEventDateTime() {
        return eventDateTime;
    }
}