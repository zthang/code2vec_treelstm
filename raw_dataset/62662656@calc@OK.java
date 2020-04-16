private static long calc(Node[] G, int[] p, String s) {
    long ret = 0;
    for (int i = 1; i < G.length; i++) {
        ret += G[p[i]].c[s.charAt((i - 1) % 3) - 49];
    }
    return ret;
}