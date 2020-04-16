    static void solve() throws IOException {
        n = sc.nextInt();
        int m = sc.nextInt();
        gr = new ArrayList[n];
        for(int i = 0;i < n;i++) gr[i] = new ArrayList<>();
        deg = new int [n];
        bad = new boolean[n];
        taked = new boolean[n];
        w = new int [n];

        for(int i = 0;i < n;i++) w[i] = sc.nextInt();

        for(int i = 0;i < m;i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            gr[v1].add(v2);
            gr[v2].add(v1);
            deg[v1]++;
            deg[v2]++;
        }

        ArrayDeque<Integer> temp = new ArrayDeque<>();
        for(int i = 0;i < n;i++) if (deg[i] == 1) temp.add(i);

        while(!temp.isEmpty()) {
            int v = temp.pollFirst();
            deg[v] = 0;
            bad[v] = true;
            for(int to : gr[v]) {
                deg[to]--;
                if (deg[to] == 1) temp.add(to);
            }
        }

        int s = sc.nextInt() - 1;

        if (!go_good(s, -1)) n /= 0;

        for(int i = 0;i < n;i++) {
            if (!bad[i]) continue;
            int good = -1;
            for(int j : gr[i]) {
                if (!bad[j]) {
                    good = j;
                }
            }
            if (good != -1) go_bad(i, good, 0);
        }

        long all_ans = max;

        for(int i = 0;i < n;i++) {
            if (taked[i] || !bad[i]) all_ans += w[i];
        }

        pw.println(all_ans);
    }