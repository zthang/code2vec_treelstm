public static void add(int v) {
    for (int q : qs[v]) {
        q_c[q]++;
        if (q_c[q] == q_v[q])
            res[q] = 1;
    }
}