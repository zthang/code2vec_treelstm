// 
void addEdge(int u, int v) {
    nex[++cnt] = hed[u];
    hed[u] = cnt;
    mys[cnt] = v;
}