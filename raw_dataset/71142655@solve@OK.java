void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = s.nextInt();
    dir = new char[N + 1];
    dir[0] = '>';
    dir[N] = '<';
    inp = s.next().toCharArray();
    for (int i = 1; i < N; i++) dir[i] = inp[i - 1];
    {
        qLarge.clear();
        ins = new int[N + 2];
        ans = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            if (dir[i - 1] == '>')
                ins[i]++;
            if (dir[i] == '<')
                ins[i]++;
            if (ins[i] == 2)
                qLarge.add(i);
        }
        int id = 1;
        while (!qLarge.isEmpty()) {
            int cur = qLarge.poll();
            ans[cur] = id++;
            if (++ins[cur - 1] == 2)
                qLarge.add(cur - 1);
            if (++ins[cur + 1] == 2)
                qLarge.add(cur + 1);
        }
        for (int i = 1; i <= N; i++) out.print(ans[i] + (i == N ? "" : " "));
        out.println();
    }
    {
        qSmall.clear();
        ins = new int[N + 2];
        ans = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            if (dir[i - 1] == '>')
                ins[i]++;
            if (dir[i] == '<')
                ins[i]++;
            if (ins[i] == 2)
                qSmall.add(i);
        }
        int id = 1;
        while (!qSmall.isEmpty()) {
            int cur = qSmall.poll();
            ans[cur] = id++;
            if (++ins[cur - 1] == 2)
                qSmall.add(cur - 1);
            if (++ins[cur + 1] == 2)
                qSmall.add(cur + 1);
        }
        for (int i = 1; i <= N; i++) out.print(ans[i] + (i == N ? "" : " "));
        out.println();
    }
}