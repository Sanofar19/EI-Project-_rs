package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = parseTime(startTime);
        this.endTime = parseTime(endTime);
        this.priority = priority;
        validateTimes();
    }

    private LocalTime parseTime(String time) {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
    }

    private void validateTimes() {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }

    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]", 
            startTime, endTime, description, priority);
    }
}
