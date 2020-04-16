public static void solve() {
    int t = s.nextInt();
    while (t-- > 0) {
        int n = s.nextInt();
        boolean[] used = new boolean[n];
        ArrayList<Integer>[] d = new ArrayList[n];
        int count = 0;
        ArrayList<Integer> left = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            d[i] = new ArrayList<Integer>();
            int x = s.nextInt();
            for (int j = 0; j < x; j++) {
                d[i].add(s.nextInt() - 1);
            }
            Collections.sort(d[i]);
            boolean flag = false;
            for (int j = 0; j < x; j++) {
                if (!used[d[i].get(j)]) {
                    used[d[i].get(j)] = true;
                    count++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                left.add(i);
            }
        }
        if (count == n) {
            out.println("OPTIMAL");
            continue;
        }
        out.println("IMPROVE");
        int left_ = -1;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                left_ = i;
                break;
            }
        }
        out.println((left.get(0) + 1) + " " + (left_ + 1));
    }
}