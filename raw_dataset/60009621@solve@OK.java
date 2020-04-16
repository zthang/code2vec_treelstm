public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] D = in.readIntArray(n);
    int[] order = ArrayUtils.order(D);
    ArrayUtils.reverse(order);
    int[] from = new int[2 * n - 1], to = new int[2 * n - 1];
    int idx = 0;
    IntList list = new IntArrayList();
    for (int i = 0; i < n; i++) {
        list.add(2 * order[i]);
        if (i > 0) {
            from[idx] = 2 * order[i - 1];
            to[idx++] = 2 * order[i];
        }
    }
    for (int i = 0; i < n; i++) {
        int id = order[i], d = D[id], x = 2 * id, y = 2 * id + 1;
        if (d == list.size() - i) {
            list.add(y);
        }
        int p = list.get(i + d - 1);
        from[idx] = p;
        to[idx++] = y;
    }
    MiscUtils.increaseByOne(from, to);
    for (int i = 0; i < from.length; i++) {
        out.printLine(from[i], to[i]);
    }
}