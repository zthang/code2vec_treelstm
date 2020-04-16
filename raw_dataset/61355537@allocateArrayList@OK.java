static ArrayList<Integer>[] allocateArrayList(int n) {
    ArrayList<Integer>[] g = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<>();
    }
    return g;
}