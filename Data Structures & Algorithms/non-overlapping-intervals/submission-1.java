class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 > s2) {
                count++;
                e1 = Math.min(e1, e2);
            } else {
                e1 = e2;
            }
        }
        return count;
    }
}
