public Object solve() {
    int N = sc.nextInt();
    D = sc.nextLongs(N);
    C = sc.nextLongs();
    K = sc.nextLongs();
    int[] E = rep(N);
    boolean[] T = new boolean[N];
    for (@SuppressWarnings("unused") int i : rep(N)) {
        int x = -1;
        long D = LINF;
        for (int j : rep(N)) if (!T[j])
            if (dist(j, E[j]) < D)
                D = dist(x = j, E[j]);
        T[x] = true;
        for (int j : rep(N)) if (!T[j])
            if (dist(j, x) < dist(j, E[j]))
                E[j] = x;
    }
    long res = 0;
    List<Integer> V = new ArrayList<>();
    for (int i : rep(N)) {
        res += dist(i, E[i]);
        if (E[i] == i)
            V.add(i);
    }
    print(res);
    print(V.size());
    print(inc(V));
    print(N - V.size());
    for (int i : rep(N)) if (E[i] != i)
        print(inc(i, E[i]));
    return null;
}