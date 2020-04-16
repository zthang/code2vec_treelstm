public static int children(int node) {
    int ans = tree[node].size();
    for (int child : tree[node]) {
        if (numChildren[child] >= 0) {
            ans += numChildren[child];
        } else {
            ans += children(child);
        }
    }
    numChildren[node] = ans;
    return ans;
}