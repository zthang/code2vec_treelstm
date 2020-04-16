void work() {
    int n = in.nextInt();
    graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    B = new int[n];
    ret = new int[n];
    int root = 0;
    for (int i = 0; i < n; i++) {
        int s = in.nextInt() - 1;
        if (s == -1) {
            root = i;
        } else {
            graph[i].add(s);
            graph[s].add(i);
        }
        int e = in.nextInt();
        B[i] = e;
    }
    ArrayList<Integer> l = dfs(root, new boolean[n]);
    if (!f) {
        out.println("NO");
        return;
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
        ret[l.get(i)] = i + 1;
    }
    for (int i = 0; i < n; i++) {
        out.print(ret[i] + " ");
    }
}