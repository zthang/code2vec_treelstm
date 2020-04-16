public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        boolean[] married = new boolean[n];
        boolean flag = false;
        int temp = -1;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            boolean f = false;
            int[] a = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                if (!married[a[j] - 1]) {
                    married[a[j] - 1] = true;
                    f = true;
                    break;
                }
            }
            if (!f) {
                flag = true;
                temp = i;
            }
        }
        if (!flag)
            System.out.println("OPTIMAL");
        else {
            System.out.println("IMPROVE");
            for (int i = 0; i < n; i++) {
                if (!married[i]) {
                    System.out.println((temp + 1) + " " + (i + 1));
                    break;
                }
            }
        }
    }
    System.out.flush();
    w.close();
}