private void solve(InputReader inp, PrintWriter out) {
    int n = inp.nextInt(), k = inp.nextInt();
    int[] index = new int[n];
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = inp.nextInt() - 1;
        index[a[i]] = i;
    }
    for (int i = 0; i < n; i++) b[i] = inp.nextInt() - 1;
    ArrayList<Integer>[] segments = new ArrayList[n];
    for (int i = 0; i < n; i++) segments[i] = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int u = b[i], v = b[i + 1];
        // out.println("U: " + u + " V: " + v + ": " + index[u] + " " + index[v]);
        if (index[u] > index[v]) {
            segments[index[v]].add(index[u]);
        } else {
            edges.add(new Edge(u, v));
        }
    }
    // out.println("Segments:");
    // for (ArrayList<Integer> seg: segments) out.println(seg);
    ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
    int max = 0;
    ArrayList<Integer> component = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        component.add(a[i]);
        for (int j : segments[i]) max = Math.max(max, j);
        if (max == i) {
            max = i + 1;
            comp.add(component);
            component = new ArrayList<>();
        }
    }
    if (component.size() != 0)
        comp.add(component);
    // out.println("Components:");
    // for (ArrayList<Integer> z: comp) out.println(z);
    int sets = comp.size();
    if (sets < k) {
        out.println("NO");
        return;
    }
    int[] set = new int[n];
    for (int i = 0; i < sets; i++) {
        ArrayList<Integer> s = comp.get(i);
        for (int j : s) {
            set[j] = i;
        }
    }
    ArrayList<Integer>[] graph = new ArrayList[sets];
    for (int i = 0; i < sets; i++) graph[i] = new ArrayList<>();
    for (Edge e : edges) {
        graph[set[e.u]].add(set[e.v]);
    }
    int[] topo = topologicalSort(graph);
    char[] letter = new char[sets];
    for (int i = 0; i < k; i++) {
        letter[i] = (char) ('a' + i);
    }
    for (int i = k; i < sets; i++) {
        letter[i] = (char) ('a' + k - 1);
    }
    char[] res = new char[n];
    for (int i = 0; i < n; i++) {
        res[i] = letter[set[i]];
    }
    out.println("YES");
    for (char c : res) out.print(c);
}