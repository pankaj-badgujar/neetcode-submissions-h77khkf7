/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        // we could maintain a minHeap that wll order by rooms ending earliest.
        // if our meeting starts after it, we can just use that room and replace with new end time
        // if not, we add new room with its end time.

        // in the end, size of heap is no of rooms required.

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Interval interval : intervals){
            // if not empty, we check which is earliest time a room becomes free
            if (rooms.isEmpty() || interval.start < rooms.peek()){
                // we need another room
                rooms.add(interval.end);
            } else {
                // remove that end time, and add new meeting's end time
                rooms.poll();
                rooms.add(interval.end);
            }
        }
        return rooms.size();
    }
}
