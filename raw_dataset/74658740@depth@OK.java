public int depth(int src, int depth, int parent) {
    int max = depth;
    arr[src][0] = depth;
    for (int key : vtces.get(src).nbrs.keySet()) {
        if (parent != key)
            max = Math.max(max, depth(key, depth + 1, src));
    }
    return max;
}