public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] flag = new int[n];
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < k; ++i) {
        if (isNew(i, sc)) {
            flag[i] = 0;
            list.add(i);
        } else
            flag[i] = 1;
    }
    for (int i = k; i < n; i += (k + 1) / 2) {
        int l = i;
        int r = min(n - 1, i + ((k + 1) / 2) - 1);
        for (int j = 0; j < list.size(); j += (k + 1) / 2) {
            reset();
            for (int p = j; p < min(list.size(), j + ((k + 1) / 2)); ++p) isNew(list.get(p), sc);
            for (int p = l; p <= r; ++p) {
                if (!isNew(p, sc))
                    flag[p] = 1;
            }
        }
        for (int j = l; j <= r; ++j) {
            if (flag[j] == 0)
                list.add(j);
        }
    }
    System.out.println("! " + list.size());
    System.out.flush();
}