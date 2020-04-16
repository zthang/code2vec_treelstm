static ArrayList<Integer> dfs(int root) {
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> al = new ArrayList<>();
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
    int i = 0;
    for (i = 0; i < c[root]; i++) {
        al.add(ans.get(i));
    }
    al.add(root);
    while (i < ans.size()) {
        al.add(ans.get(i));
        i++;
    }
    return al;
}