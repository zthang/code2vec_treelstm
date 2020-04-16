static void dfs(int id) {
    if (id == N) {
        int cur = 0;
        for (Edge e : edges) {
            if (!(used[ar[e.a]][ar[e.b]] == iter)) {
                cur++;
                used[ar[e.a]][ar[e.b]] = used[ar[e.b]][ar[e.a]] = iter;
            }
        }
        iter++;
        max = cur > max ? cur : max;
    } else {
        for (int val = 0; val < 6; val++) {
            ar[id] = val;
            dfs(id + 1);
        }
    }
}