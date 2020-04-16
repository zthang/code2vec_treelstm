static HashMap<Integer, Character> topoSort(int K) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < SCC; ++i) if (inDegree[i] == 0)
        q.add(i);
    HashMap<Integer, Character> map = new HashMap<>();
    char c = 'a';
    int count = 0;
    while (!q.isEmpty()) {
        int cur = q.remove();
        map.put(cur, c);
        if (count < K - 1)
            c = (char) ((int) (c) + 1);
        count++;
        for (int v : DAG[cur]) {
            inDegree[v]--;
            if (inDegree[v] == 0)
                q.add(v);
        }
    }
    return map;
}