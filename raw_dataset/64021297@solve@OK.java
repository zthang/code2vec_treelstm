public void solve(int testNumber, InputReader in, PrintWriter out) {
    ArrayList<Edge> arr = new ArrayList<>();
    int N = in.nextInt();
    long[] k = new long[N];
    long[] ci = new long[N];
    long[][] loc = new long[N][2];
    for (int i = 0; i < N; i++) {
        loc[i][0] = in.nextInt();
        loc[i][1] = in.nextInt();
    }
    for (int i = 0; i < N; i++) {
        ci[i] = in.nextInt();
        arr.add(new Edge(i, i, ci[i]));
    }
    for (int i = 0; i < N; i++) {
        k[i] = in.nextInt();
    }
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            arr.add(new Edge(i, j, (Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1])) * (k[i] + k[j])));
        }
    }
    Collections.sort(arr, new Comparator<Edge>() {

        public int compare(Edge o1, Edge o2) {
            return Long.compare(o1.dist, o2.dist);
        }
    });
    DisjointSet d = new DisjointSet(N);
    for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i).a == arr.get(i).b) {
            d.turnOn(arr.get(i).a, arr.get(i));
        } else {
            d.merge(arr.get(i).a, arr.get(i).b, arr.get(i));
        }
    }
    boolean[] parVisited = new boolean[N];
    ArrayList<Integer> powerStation = new ArrayList<>();
    ArrayList<Edge> connections = new ArrayList<>();
    long costTotal = 0;
    for (int i = 0; i < N; i++) {
        int par = d.find(i);
        if (!parVisited[par]) {
            parVisited[par] = true;
            for (Edge edge : d.e[par]) {
                if (edge.a == edge.b) {
                    powerStation.add(edge.a + 1);
                } else {
                    connections.add(edge);
                }
                costTotal += edge.dist;
            }
        }
    }
    out.println(costTotal);
    out.println(powerStation.size());
    for (int i = 0; i < powerStation.size(); i++) {
        out.print(powerStation.get(i) + " ");
        out.println();
    }
    out.println(connections.size());
    for (int i = 0; i < connections.size(); i++) {
        out.println((connections.get(i).a + 1) + " " + (connections.get(i).b + 1));
    }
}