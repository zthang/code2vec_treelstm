static void union(int a, int b, int[] par) {
    if (a > b) {
        par[b] = a;
    } else {
        par[a] = b;
    }
}