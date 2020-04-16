static void solve() throws IOException {
    scan();
    Integer[] id = new Integer[k];
    int temp = 0;
    for (int i = 0; i < n; i++) {
        if (good[i])
            id[temp++] = i;
    }
    Arrays.sort(id, new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(dist2[o1], dist2[o2]) * 2 + Integer.compare(o1, o2);
        }
    });
    int[] suf = new int[k];
    suf[k - 1] = dist1[id[k - 1]];
    for (int i = k - 2; i >= 0; i--) {
        suf[i] = Math.max(suf[i + 1], dist1[id[i]]);
    }
    int max_ans = 0;
    for (int i = 0; i < k - 1; i++) {
        max_ans = Math.max(max_ans, dist2[id[i]] + suf[i + 1] + 1);
    }
    max_ans = Math.min(max_ans, dist1[n - 1]);
    pw.println(max_ans);
}