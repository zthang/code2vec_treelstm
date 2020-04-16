static void dfs(int i, int p) {
    int co = c[i] + 1;
    for (int j : set) {
        ans[i] = j;
        co--;
        if (co == 0)
            break;
    }
    set.remove(ans[i]);
    for (int j : arr[i]) {
        if (j != p)
            dfs(j, i);
    }
}