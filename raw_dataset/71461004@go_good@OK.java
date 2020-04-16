static boolean go_good(int v, int pr) {
    if (!bad[v])
        return true;
    taked[v] = true;
    for (int to : gr[v]) {
        if (to == pr)
            continue;
        if (go_good(to, v))
            return true;
    }
    taked[v] = false;
    return false;
}