static boolean dfs3(int v, int color) {
    was[v] = true;
    boolean flag = true;
    if (ans[v] != 0) {
        ans[v] = color;
        nVert[color]++;
        for (int son : vert[v]) {
            if (!was[son])
                flag &= dfs3(son, 3 - color);
            else {
                if (ans[son] == ans[v])
                    return false;
            }
        }
    }
    return flag;
}