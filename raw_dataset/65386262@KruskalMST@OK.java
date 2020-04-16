// The main function to construct MST using Kruskal's algorithm
void KruskalMST(int K, int[] nodes) {
    // Tnis will store the resultant MST
    Edge[] result = new Edge[V];
    // An index variable, used for result[]
    int e = 0;
    // An index variable, used for sorted edges
    int i = 0;
    for (i = 0; i < V; ++i) result[i] = new Edge();
    // Step 1:  Sort all the edges in non-decreasing order of their
    // weight.  If we are not allowed to change the given graph, we
    // can create a copy of array of edges
    Arrays.sort(edge);
    Integer start = 0;
    Integer end = 0;
    int counter = 0;
    long cost = 0;
    ArrayList<Edge> rem = new ArrayList<>();
    // for(int p=0;i<edge.length;i++)
    // {
    // rem.add(edge[i]);
    // }
    int[] indegree = new int[V];
    // Allocate memory for creating V ssubsets
    subset[] subsets = new subset[V];
    for (i = 0; i < V; ++i) subsets[i] = new subset();
    // Create V subsets with single elements
    for (int v = 0; v < V; ++v) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
    }
    // Index used to pick next edge
    i = 0;
    // Number of edges to be taken is equal to V-1
    while (e < V - 1) {
        // Step 2: Pick the smallest edge. And increment
        // the index for next iteration
        Edge next_edge = new Edge();
        if (i < edge.length)
            next_edge = edge[i++];
        else
            next_edge = rem.remove(0);
        int x = find(subsets, next_edge.src);
        int y = find(subsets, next_edge.dest);
        // of result for next edge
        if (x != y && indegree[next_edge.src] < 2 && indegree[next_edge.dest] < 2) {
            result[e++] = next_edge;
            Union(subsets, x, y);
            cost = cost + next_edge.weight;
            indegree[next_edge.src]++;
            indegree[next_edge.dest]++;
            // System.out.println(next_edge.src+" "+next_edge.dest);
            K--;
        } else {
            rem.add(next_edge);
        }
    // Else discard the next_edge
    }
    if (K <= 0) {
        System.out.println("-1");
    } else if (K == 1) {
        for (int z = 0; z < indegree.length; z++) {
            if (indegree[z] == 1 && start == null) {
                start = z;
            } else if (indegree[z] == 1) {
                end = z;
                break;
            }
        }
        cost = cost + nodes[start] + nodes[end];
        K--;
        System.out.println(cost);
        System.out.println((start + 1) + " " + (end + 1));
        for (i = 0; i < e; ++i) System.out.println((result[i].src + 1) + " " + (result[i].dest + 1));
    }
}