private void dfs2(int node, int v) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int[] arr : rec[node]) {
        list.add(arr[1]);
    }
    list.add(v);
    Collections.sort(list, new Comparator<Integer>() {

        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    int r = 1;
    if (list.size() >= 1)
        r += list.get(0);
    if (list.size() >= 2)
        r += list.get(1);
    ret = Math.max(ret, r);
    for (int i = 0; i < rec[node].size(); i++) {
        int nn = rec[node].get(i)[0];
        int c = rec[node].get(i)[1];
        int cnt = graph[node].size();
        if (c != list.get(0)) {
            dfs2(nn, list.get(0) + 1 + (cnt > 2 ? cnt - 2 : 0));
        } else {
            dfs2(nn, list.get(1) + 1 + (cnt > 2 ? cnt - 2 : 0));
        }
    }
}