void solve() throws Exception {
    int n = sc.nextInt();
    int k = sc.nextInt();
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<>());
    int sad = 0;
    for (int i = 0; i < k; i++) {
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        if (graph.get(a).contains(b)) {
            sad++;
            continue;
        }
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    boolean[] visited = new boolean[n];
    int components = 0;
    for (int i = 0; i < n; i++) {
        if (visited[i])
            continue;
        components++;
        // start dfs from i
        // count edges
        ArrayList<Integer> fringe = new ArrayList<>();
        fringe.add(i);
        visited[i] = true;
        int edges = 0, vertices = 1;
        while (!fringe.isEmpty()) {
            ArrayList<Integer> next = new ArrayList<>();
            for (Integer u : fringe) {
                edges += graph.get(u).size();
                for (Integer v : graph.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        next.add(v);
                    }
                }
            }
            fringe = next;
            vertices += fringe.size();
        }
        edges = edges / 2;
        if (vertices - 1 < edges)
            sad += edges - (vertices - 1);
    }
    System.out.println(sad);
}