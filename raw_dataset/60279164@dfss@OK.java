public static void dfss(int src, int par) {
    // pr.println("par:"+par+" src:"+src);
    if (rec[src]) {
        path[par][src] = 2;
        return;
    }
    if (visited[src]) {
        path[par][src] = 1;
        return;
    }
    if (par != -1)
        path[par][src] = 1;
    visited[src] = true;
    rec[src] = true;
    for (int v : list[src]) dfss(v, src);
    rec[src] = false;
}