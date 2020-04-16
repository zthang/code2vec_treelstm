static boolean cycle(int u) {
    color[u] = 1;
    for (Integer v : g[u]) {
        if (color[v] == 1) {
            return true;
        } else if ((color[v] == 0) && cycle(v)) {
            return true;
        }
    }
    color[u] = 2;
    return false;
}