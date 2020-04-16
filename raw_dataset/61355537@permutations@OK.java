void permutations(int idx, int tmpVal) {
    if (idx >= n) {
        int count = 0;
        TreeSet<Pair> set = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 6; j++) {
                set.add(new Pair(i, j));
            }
        }
        for (int i = 0; i < shuff.length; i++) {
            if (shuff[i] == 6) {
                shuff[i] = tmpVal;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int curD = shuff[cur];
                    for (int v : g[cur]) {
                        int vD = shuff[v];
                        Pair x = new Pair(curD, vD);
                        if (set.contains(x)) {
                            set.remove(x);
                            count++;
                        }
                        if (!visited[v]) {
                            visited[v] = true;
                            q.add(v);
                        }
                    }
                }
            }
        }
        max = Math.max(max, count);
        return;
    }
    for (int i = 0; i <= 6; i++) {
        if (!vis[i]) {
            vis[i] = true;
            shuff[idx] = i;
            permutations(idx + 1, tmpVal);
            vis[i] = false;
        }
    }
}