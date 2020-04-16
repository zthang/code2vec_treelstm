private static void solve() throws IOException {
    int n = sc.nextInt(), k = sc.nextInt();
    dsu dsu = new dsu(n + 1);
    person[] in = new person[k];
    for (int i = 0; i < k; ++i) in[i] = new person(sc.nextInt(), sc.nextInt(), i + 1);
    long anss = 0;
    for (int i = 0; i < k; ++i) {
        if (dsu.dad(in[i].f1) != dsu.dad(in[i].f2)) {
            dsu.merge(dsu.dad(in[i].f1), dsu.dad(in[i].f2));
        } else
            ++anss;
    }
    pr.println(anss);
}