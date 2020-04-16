public int[][] readGraph(int N, int M, boolean zeroIndexed, boolean bidirectional) throws Exception {
    int[][] adj = new int[N][];
    int[] numNodes = new int[N];
    int[][] input = new int[M][2];
    for (int i = 0; i < M; i++) {
        int a = nextInt();
        int b = nextInt();
        if (zeroIndexed) {
            a--;
            b--;
        }
        input[i][0] = a;
        input[i][1] = b;
        numNodes[a]++;
        if (bidirectional)
            numNodes[b]++;
    }
    for (int i = 0; i < N; i++) {
        adj[i] = new int[numNodes[i]];
        numNodes[i] = 0;
    }
    for (int i = 0; i < M; i++) {
        int a = input[i][0];
        int b = input[i][1];
        adj[a][numNodes[a]++] = b;
        if (bidirectional)
            adj[b][numNodes[b]++] = a;
    }
    return adj;
}