void work() {
    int n = in.nextInt(), m = in.nextInt();
    long[] A = new long[n];
    for (int i = 0; i < m; i++) {
        int s = in.nextInt() - 1, e = in.nextInt() - 1;
        long w = in.nextInt();
        A[s] -= w;
        A[e] += w;
    }
    ArrayList<long[]> ret = new ArrayList<>();
    for (int i = 0, j = 0; ; ) {
        while (i < n && A[i] >= 0) {
            i++;
        }
        while (j < n && A[j] <= 0) {
            j++;
        }
        if (j == n || i == n)
            break;
        long d = Math.min(-A[i], A[j]);
        A[i] += d;
        A[j] -= d;
        ret.add(new long[] { i + 1, j + 1, d });
    }
    out.println(ret.size());
    for (long[] r : ret) {
        out.println(r[0] + " " + r[1] + " " + r[2]);
    }
}