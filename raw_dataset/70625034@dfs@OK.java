static void dfs(int root) {
    if (vec[root].size() == 0) {
        son[root] = 0;
        return;
    } else
        for (int i = 0; i < vec[root].size(); i++) {
            if (pre[root] != vec[root].get(i))
                dfs(vec[root].get(i));
            else
                continue;
            son[root] += (1 + son[vec[root].get(i)]);
        }
}