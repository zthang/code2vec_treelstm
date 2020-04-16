int dfs(int p) {
    visit[p] = true;
    int answer = 1;
    for (int q : adj.get(p)) {
        if (visit[q] == null) {
            answer += dfs(q);
        }
    }
    return answer;
}