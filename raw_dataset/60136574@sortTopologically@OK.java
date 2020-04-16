public static int[] sortTopologically(int[][][] G) {
    // 1 based. return first element 0.
    // 0 based, fine.
    int[] result = new int[G.length];
    int[] in_degree = new int[G.length];
    for (int i = 0; i < G.length; i++) for (int[] j : G[i]) in_degree[j[0]]++;
    int q = 0;
    for (int i = 0; i < G.length; i++) if (in_degree[i] == 0)
        result[q++] = i;
    for (int i = 0; i < q; i++) {
        for (int[] j : G[result[i]]) {
            if (--in_degree[j[0]] == 0)
                result[q++] = j[0];
        }
    }
    for (int i = 0; i < G.length; i++) if (in_degree[i] > 0)
        return null;
    return result;
}