static void dfs(int x, Stack<Integer> st) {
    st.push(x);
    level[curr][x] = st.size();
    path[curr][x] = new ArrayList<>();
    for (int e : st) {
        path[curr][x].add(e);
        path_set[curr][x][e] = true;
    }
    for (int e : adj[curr][x]) {
        dfs(e, st);
    }
    st.pop();
}