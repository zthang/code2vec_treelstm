void work() {
    int ret = 9999999;
    int n = ni();
    int[] A = nia(n);
    int[] color = nia(n);
    boolean[] vis = new boolean[n];
    out1: for (int i = 0; i < n; i++) {
        if (vis[i])
            continue;
        int s = i;
        int cur = A[i];
        vis[cur] = true;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        while (cur != s) {
            list.add(cur);
            vis[cur] = true;
            cur = A[cur];
        }
        int len = list.size();
        ArrayList<Integer> rec = new ArrayList<>();
        for (int j = 1; j * j <= len; j++) {
            if (len % j == 0) {
                rec.add(j);
                if (j * j != len) {
                    rec.add(len / j);
                }
            }
        }
        Collections.sort(rec);
        for (int j = 0; j < rec.size(); j++) {
            int l = rec.get(j);
            out2: for (int k = 0; k < l; k++) {
                int col = color[list.get(k)];
                for (int p = k; p < len; p += l) {
                    if (color[list.get(p)] != col) {
                        continue out2;
                    }
                }
                ret = Math.min(ret, l);
                continue out1;
            }
        }
    }
    out.println(ret);
}