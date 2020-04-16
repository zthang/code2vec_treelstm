void DFS(int u, boolean addStack, boolean addQueue) {
    vis[u] = true;
    for (int v : adjL[u]) {
        if (!vis[v])
            DFS(v, addStack, addQueue);
    }
    if (addStack)
        st.add(u);
    if (addQueue)
        q.add(u);
}