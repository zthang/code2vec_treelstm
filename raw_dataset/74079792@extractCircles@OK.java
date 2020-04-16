public List<IntegerList> extractCircles(int threshold) {
    List<IntegerList> ans = new ArrayList<>(n);
    for (int i = 0; i < n; i = r[i] + 1) {
        int size = r[i] - l[i] + 1;
        if (size < threshold) {
            continue;
        }
        IntegerList list = new IntegerList(r[i] - l[i] + 1);
        for (int j = l[i]; j <= r[i]; j++) {
            list.add(g[j]);
        }
        ans.add(list);
    }
    return ans;
}