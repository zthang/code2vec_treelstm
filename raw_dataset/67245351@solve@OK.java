public void solve() throws QuickAnswer {
    n = nextInt();
    parent = new int[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }
    int[][] lr = nextInts(n, 2);
    int[] l = lr[0];
    int[] r = lr[1];
    int[] link = new int[2 * n];
    for (int i = 0; i < n; i++) {
        --l[i];
        --r[i];
        link[l[i]] = i;
        link[r[i]] = i;
    }
    int[] order = new int[n];
    int last = 0;
    for (int i = 0; i < 2 * n; i++) {
        int index = link[i];
        if (l[index] == i) {
            order[index] = last++;
        }
    }
    TreeSet<Integer> open = new TreeSet<>();
    for (int i = 0; i < 2 * n; i++) {
        if (i != 0 && open.isEmpty()) {
            print("NO");
            return;
        }
        int index = link[i];
        if (l[index] == i) {
            open.add(order[index]);
            continue;
        }
        open.remove(order[index]);
        for (Iterator<Integer> it = open.descendingIterator(); it.hasNext(); ) {
            int next = it.next();
            if (next < order[index])
                break;
            if (!join(next, order[index])) {
                print("NO");
                return;
            }
        }
    }
    int p = getParent(0);
    for (int i = 1; i < n; i++) {
        if (p != getParent(i)) {
            print("NO");
            return;
        }
    }
    print("YES");
}