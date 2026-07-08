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
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int rooms = 0;

        for (Interval interval : intervals){
            if (minHeap.isEmpty()){
                minHeap.offer(interval.end);
                rooms++;
            } else {
                if (interval.start < minHeap.peek()){
                    rooms++;
                } else {
                    minHeap.poll();    
                }
                minHeap.offer(interval.end);
            }
        }
        return rooms;
    }
}
