int[] dfs(int node) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int k : arrayList[node]) {
        int[] temp = dfs(k);
        if (temp == null)
            return null;
        for (int p : temp) list.add(p);
    }
    if (list.size() < c[node]) {
        ans = false;
        return null;
    } else {
        int[] aa = new int[list.size() + 1];
        int p = 0;
        for (int i = 0; i < aa.length; i++) {
            if (i == c[node]) {
                aa[i] = node;
            } else {
                aa[i] = list.get(p++);
            }
        }
        return aa;
    }
}