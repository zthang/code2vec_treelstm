public static void remove(int v) {
    for (int q : qs[v]) {
        q_c[q]--;
    }
}