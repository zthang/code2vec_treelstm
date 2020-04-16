public static int down(int u) {
    int sum = 0;
    for (int x : adjList[u]) {
        if (x != p[u]) {
            p[x] = u;
            sum += Math.max(down(x), 0);
        }
    }
    return down[u] = sum + clr[u];
}