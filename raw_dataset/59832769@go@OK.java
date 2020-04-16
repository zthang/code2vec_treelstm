public void go() throws IOException {
    ntok();
    int n = ipar();
    int k = ipar();
    Vertex[] vertices = new Vertex[n];
    for (int i = 0; i < n; i++) {
        vertices[i] = new Vertex(i);
    }
    int[] arr = new int[n];
    ntok();
    arr[0] = ipar() - 1;
    int u = arr[0];
    for (int i = 1; i < n; i++) {
        int v = ipar() - 1;
        arr[i] = v;
        vertices[u].add(vertices[v]);
        u = v;
    }
    ntok();
    u = ipar() - 1;
    for (int i = 1; i < n; i++) {
        int v = ipar() - 1;
        vertices[u].add(vertices[v]);
        u = v;
    }
    ArrayDeque<Vertex> order = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    for (Vertex v : vertices) {
        dfs(v, visited, order, false, 0);
    }
    Arrays.fill(visited, false);
    int comp = 0;
    while (!order.isEmpty()) {
        Vertex v = order.pop();
        if (!visited[v.index]) {
            dfs(v, visited, order, true, comp);
            comp++;
        }
    }
    if (comp >= k) {
        out.println("YES");
        HashMap<Integer, Character> map = new HashMap<>();
        char c = 'a';
        for (int x : arr) {
            if (!map.containsKey(vertices[x].comp)) {
                map.put(vertices[x].comp, c);
                c = (char) Math.min(c + 1, 'z');
            }
        }
        for (Vertex v : vertices) {
            out.print(map.get(v.comp));
        }
        out.println();
    } else {
        out.println("NO");
    }
    out.flush();
    in.close();
}