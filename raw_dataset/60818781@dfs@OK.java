static long dfs(int p, int at) {
    long total = 0;
    if (size[at] > 1)
        comeBack[at] = true;
    for (int i : metaGraph[at]) {
        if (i == p)
            continue;
        long get = dfs(at, i);
        if (comeBack[i]) {
            comeBack[at] = true;
            total += get;
        }
    }
    if (comeBack[at])
        total += metaWeight[at];
    return total;
}