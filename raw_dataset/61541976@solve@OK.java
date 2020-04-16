private static void solve() {
    int n = sc.nextInt(), m = sc.nextInt();
    ArrayList<HashSet<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new HashSet<>());
    while (m-- > 0) {
        int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    int[] id = new int[n], parent = { 0, -1 };
    for (int i = 0; i < n; i++) {
        if (graph.get(i).size() < 2) {
            pw.println(-1);
            return;
        }
    }
    parent[0] = 0;
    parent[1] = graph.get(0).iterator().next();
    id[0] = 1;
    id[parent[1]] = 2;
    int flag = 0;
    for (int i = 1; i < n; i++) {
        if (parent[1] == i)
            continue;
        if (graph.get(0).contains(i)) {
            if (graph.get(parent[1]).contains(i)) {
                id[i] = 3;
                flag = 1;
            } else
                id[i] = 2;
        } else if (graph.get(parent[1]).contains(i))
            id[i] = 1;
        else {
            pw.println(-1);
            return;
        }
    }
    if (flag == 0) {
        pw.println(-1);
        return;
    }
    int[] size = { 0, 0, 0 };
    for (int i = 0; i < n; i++) {
        size[id[i] - 1]++;
    }
    for (int i = 0; i < n; i++) {
        for (Integer child : graph.get(i)) {
            if (id[child] == id[i]) {
                pw.println(-1);
                return;
            }
        }
        if (graph.get(i).size() + size[id[i] - 1] != n) {
            pw.println(-1);
            return;
        }
    }
    for (int i = 0; i < n; i++) pw.print(+id[i] + " ");
    pw.println();
}