boolean dfs(int i) {
    if (visited[i])
        return instack[i];
    visited[i] = instack[i] = true;
    for (int l = ao[i]; l != 0; l = next[l]) {
        int j = jj[l];
        if (dfs(j))
            return true;
    }
    instack[i] = false;
    return false;
}