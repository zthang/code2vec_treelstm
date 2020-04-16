void solve() throws IOException {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            boolean done = false;
            for (int j = 0; j < k; j++) {
                int d = sc.nextInt();
                if (a[d] == 0 && !done) {
                    done = true;
                    a[d] = 1;
                }
            }
            if (!done)
                x.add(i);
        }
        int idx = -1, c = -1;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) {
                if (x.size() > 0) {
                    idx = x.get(0);
                    c = i;
                    break;
                }
            }
        }
        if (idx == -1)
            System.out.println("OPTIMAL");
        else
            System.out.println("IMPROVE\n" + (idx + 1) + " " + c);
    }
}