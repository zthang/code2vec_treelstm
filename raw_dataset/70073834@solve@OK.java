public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    k = in.readInt();
    int[] status = new int[n];
    for (int i = 0; i < n; i++) {
        status[i] = in.readChar() - '0';
    }
    IntegerList[] appearance = new IntegerList[n];
    for (int i = 0; i < n; i++) {
        appearance[i] = new IntegerList(2);
    }
    for (int i = 0; i < k; i++) {
        int c = in.readInt();
        for (int j = 0; j < c; j++) {
            int x = in.readInt() - 1;
            appearance[x].add(i);
        }
    }
    dsu = new XorDeltaDSU(k + 1);
    for (int i = 0; i < k; i++) {
        dsu.req[0][i] = 1;
    }
    dsu.fixed[k] = k;
    for (int i = 0; i < n; i++) {
        if (status[i] == 0) {
            if (appearance[i].size() == 1) {
                asTrue(appearance[i].first());
            } else {
                merge(appearance[i].first(), appearance[i].tail(), 1);
            }
        } else {
            if (appearance[i].size() == 0) {
            } else if (appearance[i].size() == 1) {
                asFalse(appearance[i].first());
            } else {
                merge(appearance[i].first(), appearance[i].tail(), 0);
            }
        }
        out.println(total);
    }
}