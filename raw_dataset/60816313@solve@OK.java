private long solve(int n, int[] w, int m, int[] u, int[] v, int s) {
    int[][] g = buildGraph(n, m, u, v);
    boolean[] used = new boolean[n];
    boolean[] cycled = new boolean[n];
    goCycles(-1, s, g, used, cycled);
    long answer = 0;
    for (int i = 0; i < n; i++) {
        if (cycled[i]) {
            answer += w[i];
            w[i] = 0;
        }
    }
    used = new boolean[n];
    long appendix = findMax(-1, s, g, w, used);
    answer += appendix;
    return answer;
}