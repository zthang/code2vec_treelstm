public static long dfs(int cPrev2, int cPrev, int currN) {
    if (list[currN].adj.size() == 1) {
        list[currN].color = 6 - cPrev - cPrev2;
        return list[currN].costs[6 - cPrev - cPrev2 - 1];
    }
    list[currN].visited = true;
    for (int node : list[currN].adj) {
        if (!list[node].visited) {
            list[currN].color = 6 - cPrev - cPrev2;
            return list[currN].costs[6 - cPrev - cPrev2 - 1] + dfs(cPrev, 6 - cPrev - cPrev2, node);
        }
    }
    return 0;
}