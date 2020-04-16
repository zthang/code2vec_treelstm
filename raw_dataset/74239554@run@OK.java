public void run() {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- != 0) {
        int n = in.nextInt();
        int[] que = new int[n + 1];
        int[] king = new int[n + 1];
        int x = 0;
        int y = 0;
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            x = in.nextInt();
            for (int j = 0; j < x; j++) {
                y = in.nextInt();
                if (que[i] == 0 && king[y] == 0) {
                    que[i] = 1;
                    king[y] = 1;
                    count++;
                }
            }
        }
        if (count == n)
            w.println("OPTIMAL");
        else if (count == 0) {
            w.println("IMPROVE");
            w.println("1 1");
        } else {
            for (int i = 1; i < n + 1; i++) {
                if (que[i] == 0) {
                    x = i;
                    break;
                }
            }
            for (int i = 1; i < n + 1; i++) {
                if (king[i] == 0) {
                    y = i;
                    break;
                }
            }
            w.println("IMPROVE");
            w.println(x + " " + y);
        }
    }
    w.flush();
    w.close();
}