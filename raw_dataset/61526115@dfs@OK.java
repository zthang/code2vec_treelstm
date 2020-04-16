static boolean dfs(int v) {
    was[v] = true;
    nVert[0]++;
    boolean answer = true;
    for (int son : vert[v]) {
        if (!was[son])
            answer &= dfs(son);
        else {
            if (ans[son] == ans[v] && ans[son] == 0)
                return false;
        }
    }
    return answer;
}