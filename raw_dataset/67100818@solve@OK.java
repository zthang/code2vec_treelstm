public Object solve() {
    int N = sc.nextInt(), M = sc.nextInt();
    int[][] E = dec(sc.nextInts(M), 2);
    long[] T = new long[N];
    for (int[] e : E) {
        T[e[0]] -= e[2];
        T[e[1]] += e[2];
    }
    Queue<long[]> A = new LinkedList<>(), B = new LinkedList<>();
    for (int i : rep(N)) {
        if (T[i] < 0)
            A.add(new long[] { i + 1, -T[i] });
        if (T[i] > 0)
            B.add(new long[] { i + 1, T[i] });
    }
    List<long[]> res = new ArrayList<>();
    while (!A.isEmpty()) {
        long[] a = A.peek(), b = B.peek();
        long v = min(a[1], b[1]);
        res.add(new long[] { a[0], b[0], v });
        a[1] -= v;
        b[1] -= v;
        if (a[1] == 0)
            A.poll();
        if (b[1] == 0)
            B.poll();
    }
    print(res.size());
    for (long[] r : res) print(r);
    return null;
}