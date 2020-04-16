public int find(int i) {
    int ans = nodes[i];
    if (ans < 0) {
        return i;
    } else {
        return nodes[i] = find(ans);
    }
}