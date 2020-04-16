private int solve(int n, int m, int k, int[] a, int[] x, int[] y) {
    int[][] g = graph(n, m, x, y);
    int[] dist0 = dist(0, g);
    int[] distn = dist(n - 1, g);
    int basedist = dist0[n - 1];
    int[][] aa = new int[k][2];
    for (int i = 0; i < k; i++) {
        aa[i][0] = dist0[a[i]];
        aa[i][1] = distn[a[i]];
    }
    Arrays.sort(aa, new Comparator<int[]>() {

        @Override
        public int compare(int[] arg0, int[] arg1) {
            return Integer.compare(arg0[0], arg1[0]);
        }
    });
    int answer = 0;
    int farest = aa[k - 1][1];
    for (int i = k - 2; i >= 0; i--) {
        int dist = Math.min(basedist, aa[i][0] + 1 + farest);
        answer = Math.max(answer, dist);
        farest = Math.max(farest, aa[i][1]);
    }
    return answer;
}