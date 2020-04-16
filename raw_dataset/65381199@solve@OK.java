public void solve() throws IOException {
    int t = readInt();
    for (int f = 0; f < t; f++) {
        int n = readInt();
        int m = readInt();
        int[] arr = new int[n + 1];
        long cost = 0;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = readInt();
            cost = cost + 2 * arr[i + 1];
        }
        if (n != 2 && m == n) {
            out.println(cost);
            for (int i = 1; i < n; i++) out.println(i + " " + (i + 1));
            out.println(n + " " + 1);
        } else {
            out.println(-1);
        }
    }
}