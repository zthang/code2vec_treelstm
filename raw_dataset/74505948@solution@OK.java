// static Iterator<Integer> Qiter;
public static void solution() {
    // println("Hello?");
    n = in.nextInt();
    m = in.nextInt();
    // problems = new int[n];
    tree = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<Integer>());
    }
    tree.get(0).add(1);
    tree.get(1).add(0);
    // println("Hello?");
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        tree.get(a).add(b);
        tree.get(b).add(a);
    }
    parent = new int[n + 1];
    depth = new int[n + 1];
    t = 0;
    ins = new int[n + 1];
    outs = new int[n + 1];
    outs[0] = Integer.MAX_VALUE;
    DFS(1, 0, 1);
    // println("Setup complete");
    for (int i = 0; i < m; i++) {
        int p = in.nextInt();
        int[] q = new int[p];
        int maxdepth = 0;
        int rootq = 0;
        for (int j = 0; j < p; j++) {
            int k = parent[in.nextInt()];
            q[j] = k;
            int de = depth[k];
            if (de > maxdepth) {
                maxdepth = de;
                rootq = k;
            }
        }
        boolean works = true;
        for (int k : q) {
            if (!(ins[k] <= ins[rootq] && ins[rootq] < outs[k])) {
                works = false;
            }
        }
        println(works ? "YES" : "NO");
    }
}