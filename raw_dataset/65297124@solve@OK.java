public static void solve() {
    // Input
    String[] firstline = in.nextLine().split(" ");
    int nodeCount = Integer.parseInt(firstline[0]);
    int edgeCount = Integer.parseInt(firstline[1]);
    // Create disjoint union set
    DisjointUnionSets dsu = new DisjointUnionSets(nodeCount);
    // Keep track of max element of each set
    HashMap<Integer, Integer> maxes = new HashMap<>();
    for (int i = 0; i < nodeCount; i++) {
        // Each element is in a solo set
        maxes.put(i, i);
    }
    // For each edge
    for (int i = 0; i < edgeCount; i++) {
        // Read the input
        String[] line = in.nextLine().split(" ");
        int node1 = Integer.parseInt(line[0]) - 1;
        int node2 = Integer.parseInt(line[1]) - 1;
        // Find the max of the two sets before merging
        int max = Math.max(maxes.get(dsu.find(node1)), maxes.get(dsu.find(node2)));
        // Merge
        dsu.union(node1, node2);
        // Find which element was chosen as representative, and store max
        int repr = dsu.find(node1);
        maxes.put(repr, max);
    }
    // Track union count
    int unionCount = 0;
    // For each node, union with all nodes until the maximum of the set
    int currentUnionRoot = 0;
    for (int i = 0; i < nodeCount; i++) {
        // Get both nodes
        int node1 = currentUnionRoot;
        int node2 = i;
        // Find the max of the two sets before merging
        int max = Math.max(maxes.get(dsu.find(node1)), maxes.get(dsu.find(node2)));
        // Merge
        if (dsu.find(node1) != dsu.find(node2)) {
            unionCount++;
            dsu.union(node1, node2);
        }
        // Find which element was chosen as representative, and store max
        int repr = dsu.find(node1);
        maxes.put(repr, max);
        // Is the new max equal to the current element, then create new group
        if (max == i) {
            currentUnionRoot = i + 1;
        }
    }
    System.out.println(unionCount);
}