    static void fun(int cur) {
        if (cur == k / 2) {
            int cnt = 0;
            for (int i = 1; i <= cur; i++) {
                int j = 0;
                while (used[d[even[i - 1]][even[i]].get(j).v] != 0) j++;
                cnt += d[even[i - 1]][even[i]].get(j).d;
            }
            ans = Math.min(ans, cnt);
            return;
        }
        for (int v = 0; v < n; v++) {
            even[cur] = v;
            used[v]++;
            fun(cur + 1);
            used[v]--;
        }
    }