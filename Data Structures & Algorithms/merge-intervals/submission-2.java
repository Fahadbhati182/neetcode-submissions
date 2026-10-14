class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 >= s2) {
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
