public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int[] pi = new int[n];
    for (int i = 0; i < n; i++) pi[i] = in.scanInt() - 1;
    int[] ci = new int[n];
    for (int i = 0; i < n; i++) ci[i] = in.scanInt() - 1;
    int ans = n;
    boolean[] done = new boolean[n];
    Arrays.fill(done, false);
    for (int i = 0; i < n; i++) {
        if (done[i])
            continue;
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(i);
        int temp = pi[i];
        while (temp != i) {
            done[temp] = true;
            cycle.add(temp);
            temp = pi[temp];
        }
        int size = cycle.size();
        for (int j = 1; j * j <= size; j++) {
            if (size % j == 0) {
                for (int k = 0; ans > j && k < j; k++) {
                    boolean flag = true;
                    for (int l = k; l < size && flag; l += j) {
                        if (ci[cycle.get(l)] != ci[cycle.get(k)])
                            flag = false;
                    }
                    if (flag) {
                        ans = Math.min(ans, j);
                        break;
                    }
                }
                for (int k = 0; ans > size / j && k < size / j; k++) {
                    boolean flag = true;
                    for (int l = k; l < size && flag; l += size / j) {
                        if (ci[cycle.get(l)] != ci[cycle.get(k)])
                            flag = false;
                    }
                    if (flag) {
                        ans = Math.min(ans, size / j);
                        break;
                    }
                }
            }
        }
    }
    out.println(ans);
}