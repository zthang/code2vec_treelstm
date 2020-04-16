static void dfs(int x) {
    visit[x] = 1;
    ans1++;
    for (int i = 0; i < li[x].size(); i++) {
        if (visit[li[x].get(i)] == 0) {
            dfs(li[x].get(i));
        }
    }
}