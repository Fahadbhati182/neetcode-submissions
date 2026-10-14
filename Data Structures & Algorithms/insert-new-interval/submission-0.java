class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> newIntervals = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();

        boolean isInterval = false;

        for (int i = 0; i < n; i++) {
            if (!isInterval && newInterval[0] < intervals[i][0]) {
                newIntervals.add(newInterval);
                isInterval = true;
            }

            newIntervals.add(intervals[i]);
        }
        if (!isInterval) {
            newIntervals.add(newInterval);
        }

        int s1 = newIntervals.get(0)[0];
        int e1 = newIntervals.get(0)[1];

        for (int i = 1; i < newIntervals.size(); i++) {
            int s2 = newIntervals.get(i)[0];
            int e2 = newIntervals.get(i)[1];

            if (e1 >= s2) {
                s1 = s1;
                e1 = Math.max(e1, e2);
                continue;
            }
            ans.add(new int[] {s1, e1});
            s1 = s2;
            e1 = e2;
        }
        ans.add(new int[] {s1, e1});

        return ans.toArray(new int[ans.size()][]);
    }
}
