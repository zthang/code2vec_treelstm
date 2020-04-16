void solve() throws Exception {
    int i, j, k;
    int N = hp.nextInt(), M = hp.nextInt();
    TreeSet<Integer>[] graph = new TreeSet[N];
    for (i = 0; i < N; ++i) graph[i] = new TreeSet<>();
    for (i = 0; i < M; ++i) {
        int a = hp.nextInt() - 1, b = hp.nextInt() - 1;
        graph[a].add(b);
        graph[b].add(a);
    }
    long[] keys = new long[N];
    for (i = 0; i < N; ++i) keys[i] = hash(graph[i].toString());
    HashMap<Long, Integer> freq = new HashMap<>();
    for (long key : keys) {
        freq.put(key, freq.getOrDefault(key, 0) + 1);
    }
    boolean ok = freq.size() == 3;
    for (i = 0; i < N; ++i) {
        ok = ok && graph[i].size() + freq.get(keys[i]) == N;
    }
    if (!ok) {
        System.out.println(-1);
        return;
    }
    k = 0;
    for (Map.Entry<Long, Integer> ent : freq.entrySet()) {
        ent.setValue(++k);
    }
    for (long key : keys) hp.printsp(freq.get(key));
    hp.flush();
}