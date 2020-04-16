static void assign(int u, int color) {
    target[u] = color;
    for (int e = 0; e < 3; e++) {
        if (e != color)
            forbid[u][e] = true;
        else
            forbid[u][e] = false;
    }
}