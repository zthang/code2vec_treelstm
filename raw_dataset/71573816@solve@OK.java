public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    String x = in.next();
    int gt = 0;
    int lt = 0;
    for (int i = 0; i < n - 1; i++) {
        if (x.charAt(i) == '<')
            lt++;
        else
            gt++;
    }
    int[] ansa = new int[n];
    int[] ansb = new int[n];
    int c = n - lt + 1;
    for (int i = 0; i < n - 1; i++) {
        if (x.charAt(i) == '<')
            ansa[i + 1] = c++;
    }
    c = 1;
    for (int i = n - 1; i >= 0; i--) {
        if (ansa[i] == 0)
            ansa[i] = c++;
    }
    c = gt;
    for (int i = 0; i < n - 1; i++) {
        if (x.charAt(i) == '>')
            ansb[i + 1] = c--;
    }
    c = n;
    for (int i = 0; i < n; i++) {
        if (ansb[i] != 0) {
            int j = i - 1;
            while (j >= 0 && ansb[j] == 0) {
                ansb[j] = c--;
                j--;
            }
        }
    }
    int j = n - 1;
    while (j >= 0 && ansb[j] == 0) {
        ansb[j] = c--;
        j--;
    }
    for (int xx : ansb) {
        out.print(xx + " ");
    }
    out.println();
    for (int xx : ansa) {
        out.print(xx + " ");
    }
    out.println();
}