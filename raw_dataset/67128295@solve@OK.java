void solve() throws IOException {
    int n = ni(), m = ni();
    long[] A = new long[n + 1];
    for (int x = 0; x < m; x++) {
        int u = ni(), v = ni();
        long d = nl();
        A[u] -= d;
        A[v] += d;
    }
    ArrayList<Integer> B = new ArrayList();
    ArrayList<Integer> C = new ArrayList();
    ArrayList<Long> D = new ArrayList();
    int p = 1;
    int q = 1;
    while (p <= n && A[p] >= 0) p++;
    while (q <= n && A[q] <= 0) q++;
    while (p <= n && q <= n) {
        B.add(p);
        C.add(q);
        if (A[p] * -1 >= A[q]) {
            D.add(A[q]);
            A[p] += A[q];
            A[q] = 0;
        } else {
            D.add(A[p] * -1);
            A[q] += A[p];
            A[p] = 0;
        }
        while (p <= n && A[p] >= 0) p++;
        while (q <= n && A[q] <= 0) q++;
    }
    out.println(B.size());
    for (int x = 0; x < B.size(); x++) out.println(B.get(x) + " " + C.get(x) + " " + D.get(x));
    out.flush();
}