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
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int k = 0;
        for (Interval i : intervals){
            start[k] = i.start;
            end[k] = i.end;
            k++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int res = 0;

        int i = 0, j = 0;
        while (i < start.length){
            if (start[i] < end[j]){
                count++;
                res = Math.max(res, count);
                i++;
            } else if (start[i] > end[j]){
                count--;
                j++;
            } else {
                j++;
                i++;
            }
        }
        return res;
    }
}
