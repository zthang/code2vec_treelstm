static int minKey(long[] key, Boolean[] mstSet, int V) {
    long min = Integer.MAX_VALUE;
    int min_index = -1;
    for (int v = 0; v < V; v++) if (mstSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
    }
    return min_index;
}