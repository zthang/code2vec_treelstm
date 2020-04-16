static void dfs(int i) {
    if (v[i]) {
        return;
    }
    v[i] = true;
    if (i < max) {
        f = true;
    }
    max1 = Math.max(max1, i);
    Iterator itr = arr[i].iterator();
    while (itr.hasNext()) {
        int x = (int) itr.next();
        dfs(x);
    }
}