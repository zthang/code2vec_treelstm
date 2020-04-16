public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int k = in.scanInt();
    ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) arrayLists[i] = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        int x = in.scanInt();
        int y = in.scanInt();
        arrayLists[x].add(y);
        arrayLists[y].add(x);
    }
    boolean[] done = new boolean[n + 1];
    long ans = 0;
    for (int i = 1; i <= n; i++) {
        if (done[i])
            continue;
        done[i] = true;
        Stack<Integer> st = new Stack<>();
        st.push(i);
        while (!st.isEmpty()) {
            int tl = st.pop();
            for (int j : arrayLists[tl]) {
                if (!done[j] && j != i) {
                    ans++;
                    done[j] = true;
                    st.push(j);
                }
            }
        }
    }
    out.println(k - ans);
}