public static void primMST(Map<Integer, List<Node>> graph, int V) {
    TreeSet<Node> pq = new TreeSet<>((u, v) -> {
        if (u.cost - v.cost != 0)
            return (int) (u.cost - v.cost);
        else
            return (int) (u.val - v.val);
    });
    boolean[] mstSet = new boolean[V + 1];
    Node[] dist = new Node[V + 1];
    List<Integer> powerStations = new ArrayList<>();
    List<long[]> connections = new ArrayList<>();
    long[] parent = new long[V + 1];
    for (int i = 0; i <= V; i++) {
        if (i == 0) {
            dist[i] = new Node(0, 0);
        } else {
            dist[i] = new Node(i, Integer.MAX_VALUE - i);
        }
        pq.add(dist[i]);
        parent[i] = -1;
    }
    long totalCost = 0;
    // }
    while (!pq.isEmpty()) {
        Node node = pq.pollFirst();
        // System.out.println(node);
        if (parent[(int) node.val] == 0)
            powerStations.add((int) node.val);
        else {
            if (node.val != 0)
                connections.add(new long[] { parent[(int) node.val], node.val });
        }
        totalCost += node.cost;
        mstSet[(int) node.val] = true;
        for (Node n : graph.get((int) node.val)) {
            if (!mstSet[(int) n.val]) {
                if (dist[(int) n.val].cost >= n.cost) {
                    pq.remove(dist[(int) n.val]);
                    dist[(int) n.val].cost = n.cost;
                    // System.out.println("Updating: " + n.val + " to : " + n.cost);
                    pq.add(dist[(int) n.val]);
                    parent[(int) n.val] = node.val;
                }
            }
        }
    }
    System.out.println(totalCost);
    System.out.println(powerStations.size());
    for (long p : powerStations) System.out.print(p + " ");
    System.out.println();
    System.out.println(connections.size());
    for (long[] conn : connections) {
        System.out.println(conn[0] + " " + conn[1]);
    }
}