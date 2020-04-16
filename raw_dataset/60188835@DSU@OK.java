public static void DSU(int v) {
    was[v] = true;
    firstTime[v] = time;
    time++;
    for (int a : vert[v]) {
        if (!was[a]) {
            DSU(a);
        }
    }
    lastTime[v] = time;
    time++;
}