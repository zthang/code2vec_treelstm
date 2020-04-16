public long sum(int i) {
    long total = 0;
    int node = i;
    while (node > 0) {
        total += arr[node];
        node -= node & (-node);
    }
    return total;
}