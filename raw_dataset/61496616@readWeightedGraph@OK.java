public int[][][] readWeightedGraph(int N, int M, boolean zeroIndexed, boolean bidirectional) throws Exception {
    int[][][] adj = new int[N][][];
    int[] numNodes = new int[N];
    int[][] input = new int[M][3];
    for (int i = 0; i < M; i++) {
        int a = nextInt();
        int b = nextInt();
        if (zeroIndexed) {
            a--;
            b--;
        }
        int d = nextInt();
        input[i][0] = a;
        input[i][1] = b;
        input[i][2] = d;
        numNodes[a]++;
        if (bidirectional)
            numNodes[b]++;
    }
    for (int i = 0; i < N; i++) {
        adj[i] = new int[numNodes[i]][2];
        numNodes[i] = 0;
    }
    for (int i = 0; i < M; i++) {
        int a = input[i][0];
        int b = input[i][1];
        int d = input[i][2];
        adj[a][numNodes[a]][0] = b;
        adj[a][numNodes[a]][1] = d;
        numNodes[a]++;
        if (bidirectional) {
            adj[b][numNodes[b]][0] = a;
            adj[b][numNodes[b]][1] = d;
            numNodes[b]++;
        }
    }
    return adj;
}