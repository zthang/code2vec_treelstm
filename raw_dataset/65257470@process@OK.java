static void process() throws Exception {
    // arrayTest();
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int n = reader.readInt();
    int m = reader.readInt();
    sz = new int[n];
    id = new int[n];
    mx = new int[n];
    mn = new int[n];
    for (int i = 0; i < n; i++) {
        id[i] = i;
        mx[i] = i;
        mn[i] = i;
        sz[i] = 1;
    }
    for (int i = 0; i < m; i++) {
        int u = reader.readInt() - 1;
        int v = reader.readInt() - 1;
        qunion(u, v);
    }
    boolean[] visited = new boolean[n];
    int res = 0;
    for (int u = 0; u < n; u++) {
        int r = root(u);
        if (!visited[r]) {
            visited[r] = true;
            int a = mn[r];
            int b = mx[r];
            int s = sz[r];
            // log("r:"+r+" a:"+a+" b:"+b+" s:"+s);
            if (s < b - a + 1) {
                // log("need to do something");
                int i = a;
                while (i <= b) {
                    if (root(i) != r) {
                        res++;
                        qunion(i, r);
                        r = root(r);
                        visited[r] = true;
                        b = mx[r];
                    }
                    i++;
                }
            }
        }
    }
    output(res);
    try {
        out.close();
    } catch (Exception e) {
    }
}