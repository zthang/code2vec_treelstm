static void computeSub(int node) {
    // log("comput sub:"+node);
    for (int v : friends[node]) {
        computeSub(v);
        sub[node] += sub[v];
    }
    sub[node]++;
}