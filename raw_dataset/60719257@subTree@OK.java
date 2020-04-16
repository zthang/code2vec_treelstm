public static void subTree(int src, int parent, int x) {
    countSubTree[src] = 1;
    if (src == x) {
        checkpath[src] = true;
    // System.out.println("src:"+src);
    } else
        checkpath[src] = false;
    for (int v : list[src]) {
        if (v == parent)
            continue;
        subTree(v, src, x);
        countSubTree[src] += countSubTree[v];
        checkpath[src] |= checkpath[v];
    }
}