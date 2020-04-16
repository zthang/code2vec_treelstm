public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int n = Integer.parseInt(ar[0]);
    int m = Integer.parseInt(ar[1]);
    int[] edgea = new int[m];
    int[] edgeb = new int[m];
    for (int i = 0; i < m; i++) {
        in = fin.readLine();
        ar = in.split(" ");
        edgea[i] = Integer.parseInt(ar[0]) - 1;
        edgeb[i] = Integer.parseInt(ar[1]) - 1;
    }
    int max = 0;
    for (int i = 0; i < Math.pow(7, n); i++) {
        String tmp = ("0000000000" + Integer.toString(i, 7));
        String s = tmp.substring(tmp.length() - n);
        // System.out.println(s);
        char[] c = s.toCharArray();
        int[] intc = new int[n];
        for (int j = 0; j < n; j++) {
            intc[j] = c[j] - 48;
        }
        int cnt = 0;
        boolean[] used = new boolean[36];
        for (int j = 0; j < m; j++) {
            int a = intc[edgea[j]];
            int b = intc[edgeb[j]];
            // System.out.println(a + " " + b);
            if (a == 0 || b == 0) {
                continue;
            }
            int conv = conv(a, b);
            if (!used[conv]) {
                used[conv] = true;
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
    System.out.println(max);
}