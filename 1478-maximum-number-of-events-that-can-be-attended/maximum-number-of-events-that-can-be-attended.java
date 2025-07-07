import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, res = 0;

        int maxDay = 0;
        for (int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }

        for (day = 1; day <= maxDay; day++) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove all events already expired
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event with the earliest end day
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }
}
