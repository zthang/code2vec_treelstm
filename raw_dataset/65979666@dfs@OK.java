public void dfs(int index) {
    visited[index] = true;
    for (String s : graph[index]) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!visited[s.charAt(i) - 'a']) {
                dfs(s.charAt(i) - 'a');
            }
        }
    }
}