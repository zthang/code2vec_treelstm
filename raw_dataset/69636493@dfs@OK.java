static ArrayList<Integer> dfs(int root) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.ensureCapacity(c.length);
    for (Integer ch : gr[root]) {
        ArrayList<Integer> res = dfs(ch);
        ans.addAll(res);
    }
    if (f == false)
        return ans;
    if (c[root] > ans.size()) {
        f = false;
        return ans;
    }
    ans.add(c[root], root);
    return ans;
}