public Object solve() {
    int N = sc.nextInt();
    D = sc.nextLongs(N);
    C = sc.nextLongs();
    K = sc.nextLongs();
    List<int[]> E = new ArrayList<>();
    int[] F = rep(N);
    for (@SuppressWarnings("unused") int i : rep(N)) {
        int x = -1;
        long D = LINF;
        for (int j : rep(N)) if (F[j] != -1)
            if (dist(j, F[j]) < D)
                D = dist(x = j, F[j]);
        E.add(new int[] { x, F[x] });
        F[x] = -1;
        for (int j : rep(N)) if (F[j] != -1)
            if (dist(j, x) < dist(j, F[j]))
                F[j] = x;
    }
    long res = 0;
    List<Integer> V = new ArrayList<>();
    for (int[] e : E) {
        res += dist(e[0], e[1]);
        if (e[0] == e[1])
            V.add(e[0] + 1);
    }
    print(res);
    print(V.size());
    print(V);
    print(E.size() - V.size());
    for (int[] e : E) if (e[0] != e[1])
        print(e[0] + 1, e[1] + 1);
    return null;
}