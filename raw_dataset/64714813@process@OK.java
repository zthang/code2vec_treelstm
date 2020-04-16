static void process() throws Exception {
    // arrayTest();
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int n = reader.readInt();
    int m = reader.readInt();
    ArrayList<Integer>[] enemy = new ArrayList[n];
    ArrayList<Integer>[] friends = new ArrayList[n];
    for (int u = 0; u < n; u++) {
        enemy[u] = new ArrayList<Integer>();
        friends[u] = new ArrayList<Integer>();
    }
    int[] cnt = new int[n];
    for (int i = 0; i < m; i++) {
        int u = reader.readInt() - 1;
        int v = reader.readInt() - 1;
        enemy[u].add(v);
        enemy[v].add(u);
        cnt[u]++;
        cnt[v]++;
    }
    Composite[] ar = new Composite[n];
    for (int u = 0; u < n; u++) {
        Collections.sort(friends[u]);
        ar[u] = new Composite(u, cnt[u]);
    }
    Arrays.sort(ar);
    int LM = (n - 1) / 2;
    // zer is a symbol
    int zer = 1;
    time = 1;
    stack = new int[n];
    visited = new boolean[n];
    target = new int[n];
    Arrays.fill(target, -1);
    tm = new int[n];
    connect = 0;
    // start by putting all below LM in the same group, which is zer
    ArrayList<Integer> cand = new ArrayList<Integer>();
    for (int u = 0; u < n; u++) {
        if (cnt[u] <= LM) {
            target[u] = zer;
            log("puttint in zer:" + u);
            connect++;
        } else {
            time++;
            cand.add(u);
            for (int v : enemy[u]) tm[v] = time;
            for (int v = 0; v < n; v++) {
                if (tm[v] < time) {
                    friends[u].add(v);
                }
            }
        }
    }
    // log("cand size:"+cand.size());
    res = 0;
    if (connect == 0)
        res = -1;
    for (int u : cand) {
        if (!visited[u]) {
            // log("processing u:"+u);
            boolean gozer = false;
            int r = 0;
            int w = 0;
            visited[u] = true;
            stack[w++] = u;
            while (r < w) {
                int a = stack[r++];
                // log("processing a:"+a);
                for (int b : friends[a]) {
                    if (target[b] == zer) {
                        gozer = true;
                    // log("found gozer for a:"+a+" through b:"+b);
                    } else {
                        if (!visited[b]) {
                            visited[b] = true;
                            stack[w++] = b;
                        // log("stacking b:"+b);
                        }
                    }
                }
            }
            if (!gozer) {
                res++;
            }
            for (int t = 0; t < w; t++) {
                int v = stack[t];
                target[v] = zer;
            }
        }
    }
    output(res);
    try {
        out.close();
    } catch (Exception e) {
    }
}