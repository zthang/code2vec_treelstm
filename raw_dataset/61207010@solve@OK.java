private void solve() {
    FastScanner sc = new FastScanner();
    int n = sc.nextInt(), m = sc.nextInt();
    Set<Integer>[] nei = new Set[n];
    for (int i = 0; i < n; i++) nei[i] = new TreeSet<>();
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
        nei[a].add(b);
        nei[b].add(a);
    }
    int[] w = new int[n];
    Set<Domino> dominos = new HashSet<>();
    int maxCount = 0;
    while (w[0] < 6) {
        dominos.clear();
        for (int f = 0; f < n; f++) {
            for (int t : nei[f]) {
                dominos.add(new Domino(w[f], w[t]));
            }
        }
        maxCount = Math.max(maxCount, dominos.size());
        w[w.length - 1]++;
        for (int i = w.length - 1; i > 0; i--) {
            if (w[i] > 5) {
                w[i] = 0;
                w[i - 1] += 1;
            }
        }
    }
    System.out.println(maxCount);
}