static void dfs(int curr, int parent) {
    // System.out.println(curr + "  " + parent + " " + c[curr]);
    int add = c[curr];
    // if(c[curr]>=set.size()) {
    // System.out.println("NO");
    // fail = true;
    // return;
    // }
    ret[curr] = set.get(add);
    set.remove(add);
    for (int next : tree[curr]) {
        if (next != parent) {
            dfs(next, curr);
        }
    }
}