static int dfs(int idx, int flag) {
    seen[idx] = true;
    int out = 1;
    boolean seenFlag = false;
    if (idx == flag)
        seenFlag = true;
    for (int next : (ArrayDeque<Integer>) edges[idx]) {
        if (!seen[next]) {
            int get = dfs(next, flag);
            if (get == -1)
                seenFlag = true;
            out += get;
        }
    }
    if (seenFlag)
        return -1;
    return out;
}