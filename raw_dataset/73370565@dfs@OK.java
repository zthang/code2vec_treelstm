static void dfs(int u) {
    vis[u] = true;
    stack.add(u);
    c[u] = stack.size();
    for (int v : adjList[u]) {
        if (oo)
            return;
        if (!vis[v])
            dfs(v);
        else {
            if (c[u] - c[v] + 1 >= k) {
                out.println(2);
                out.println(c[u] - c[v] + 1);
                while (stack.peek() != v) out.print((stack.pop() + 1) + " ");
                out.print(stack.pop() + 1);
                out.close();
                oo = true;
                return;
            }
        }
    }
    if (oo)
        return;
    if (!taken[u])
        for (int v : adjList[u]) taken[v] = true;
    stack.pop();
}