package com.leet_code;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0 }
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        minHeap.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            Interval min = minHeap.remove();
            if (min.end < intervals[i].start) {
                min.end = intervals[i].end;
            } else {
                minHeap.add(intervals[i]);
            }
            
            minHeap.add(min);
        }
        return minHeap.size();
    }
}
