private static void rdfs(int v, int k) {
    used[v] = true;
    cmpId[v] = k;
    for (Integer i : rG[v]) {
        if (!used[i])
            rdfs(i, k);
    }
}