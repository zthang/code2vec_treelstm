public void solve() throws IOException {
    int n = nextInt(), m = nextInt();
    v = new ArrayList<>();
    edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        edges.add(new Pair(nextInt() - 1, nextInt() - 1));
    }
    max = 0;
    build();
    out.println(max);
}