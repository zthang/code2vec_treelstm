int backtrack(int node, int[] mask) {
    if (node == n)
        return process(mask);
    int ans = 0;
    for (int i = 0; i < 6; i++) {
        mask[node] = i;
        ans = max(ans, backtrack(node + 1, mask));
    }
    return ans;
}