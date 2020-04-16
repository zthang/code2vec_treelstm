void dfs(int N) {
    for (int ch : tree[N].ch) {
        dfs(ch);
        tree[N].nums.merge(tree[ch].nums);
    }
    if (!tree[N].nums.insert(N)) {
        flag = false;
    }
}