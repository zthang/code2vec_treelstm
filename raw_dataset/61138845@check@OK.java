static public int check(int[] colors, int[][] vertex) {
    boolean[] dominosUsed = new boolean[100];
    int cnt = 0;
    for (int[] v : vertex) {
        int a = colors[v[0]];
        int b = colors[v[1]];
        if (a > b) {
            b = colors[v[0]];
            a = colors[v[1]];
        }
        if (a == 0 || dominosUsed[a * 10 + b]) {
            continue;
        }
        cnt++;
        dominosUsed[a * 10 + b] = true;
    }
    return cnt;
}