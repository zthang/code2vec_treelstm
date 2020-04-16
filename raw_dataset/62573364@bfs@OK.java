long bfs(int s, long[] c1, long[] c2, long[] c3, int[] nod_val) {
    long ans = (long) 1e14 + 10;
    for (int co1 = 1; co1 < 4; co1++) {
        for (int co2 = 1; co2 < 4; co2++) {
            if (co1 != co2) {
                int col1 = co1;
                int col2 = co2;
                Queue<Integer> q = new LinkedList<Integer>();
                int[] visit = new int[n];
                int[] tmp = new int[n];
                q.add(s);
                visit[s] = 1;
                tmp[s] = col1;
                long cost = color(col1, s, c1, c2, c3);
                int u = q.poll();
                int v;
                for (int h = 0; h < adj.get(u).size(); h++) {
                    v = adj.get(u).get(h);
                    if (visit[v] == 0) {
                        visit[v] = 1;
                        tmp[v] = col2;
                        cost += color(col2, v, c1, c2, c3);
                        q.add(v);
                    }
                }
                while (!q.isEmpty()) {
                    u = q.poll();
                    int col3 = 6 - col1 - col2;
                    for (int h = 0; h < adj.get(u).size(); h++) {
                        v = adj.get(u).get(h);
                        if (visit[v] == 0) {
                            visit[v] = 1;
                            tmp[v] = col3;
                            cost += color(col3, v, c1, c2, c3);
                            q.add(v);
                        }
                    }
                    col1 = col2;
                    col2 = col3;
                }
                if (cost < ans) {
                    ans = cost;
                    for (int l = 0; l < n; l++) {
                        nod_val[l] = tmp[l];
                    }
                }
            }
        }
    }
    return ans;
}