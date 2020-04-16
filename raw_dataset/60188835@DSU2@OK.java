public static void DSU2(int v) {
    was[v] = true;
    for (int a : vert[v]) {
        if (firstTime[a] < firstTime[v] && lastTime[a] > lastTime[v]) {
            ans[order.get(new pair(v, a))] = 1;
            flag = false;
        } else if (!was[a]) {
            DSU2(a);
        }
    }
}