static void MainSolution() {
    n = ni();
    m = ni();
    long[] bal = new long[n + 1];
    for (int i = 0; i < m; i++) {
        int x = ni(), y = ni(), z = ni();
        bal[x] -= z;
        bal[y] += z;
    }
    Stack<two> st = new Stack<>();
    Stack<two> ans = new Stack<>();
    for (int i = 1; i <= n; i++) {
        if (bal[i] < 0)
            st.push(new two(i, -bal[i]));
    }
    for (int i = 1; i <= n; i++) {
        while (bal[i] > 0) {
            long val = min(bal[i], st.peek().b);
            ans.push(new two(st.peek().a, i, val));
            bal[i] -= val;
            st.peek().b -= val;
            if (st.peek().b == 0)
                st.pop();
        }
    }
    pl(ans.size());
    while (!ans.isEmpty()) {
        p(ans.peek().a);
        p(ans.peek().b);
        pl(ans.peek().c);
        ans.pop();
    }
}