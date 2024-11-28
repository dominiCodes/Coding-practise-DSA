class MyCalendarTwo {

    // To store all events that are booked once
    List<Pair> events;
    
    // To store all double-booked time intervals
    List<Pair> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    // Step 1: Check if the new event overlaps with any already double-booked interval
    for (Pair overlap : overlaps) {
        // This condition checks if there is an overlap between the new event and any double-booked interval
        if (Math.max(start, overlap.start) < Math.min(end, overlap.end)) {
            // Triple booking detected, return false
            return false;
        }
    }

    // Step 2: Check for overlap with existing single-booked events
    for (Pair event : events) {
        // This condition checks if there is an overlap with a single-booked event
        if (Math.max(start, event.start) < Math.min(end, event.end)) {
            // If an overlap is found, we add this overlap to the `overlaps` list
            overlaps.add(new Pair(Math.max(start, event.start), Math.min(end, event.end)));
        }
    }

    // Step 3: Add the new event to the list of booked events
    events.add(new Pair(start, end));
    return true;
}
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */