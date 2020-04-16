public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int T = Integer.parseInt(ar[0]);
    for (int t = 0; t < T; t++) {
        int ret2 = 0;
        boolean dig2 = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig2 = true;
                ret2 = ret2 * 10 + ch - '0';
            } else if (dig2)
                break;
        }
        int n = ret2;
        ret2 = 0;
        dig2 = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig2 = true;
                ret2 = ret2 * 10 + ch - '0';
            } else if (dig2)
                break;
        }
        int m = ret2;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            int ret = 0;
            boolean dig = false;
            for (int ch = 0; (ch = fin.read()) != -1; ) {
                if (ch >= '0' && ch <= '9') {
                    dig = true;
                    ret = ret * 10 + ch - '0';
                } else if (dig)
                    break;
            }
            a[i] = ret;
        }
        if (n == 2) {
            System.out.println(-1);
            continue;
        }
        if (m < n) {
            System.out.println(-1);
            continue;
        }
        long ans = 0;
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;
        int min1ind = 0;
        int min2ind = 0;
        for (int i = 0; i < n; i++) {
            ans += 2 * a[i];
            if (a[i] < min1) {
                min1 = Math.min(min1, a[i]);
                min1ind = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != min1ind) {
                if (a[i] < min2) {
                    min2 = Math.min(min2, a[i]);
                    min2ind = i;
                }
            }
        }
        ans += (n - m) * (min1 + min2);
        System.out.println(ans);
        StringBuffer sb = new StringBuffer("");
        for (int i = 1; i < n; i++) {
            sb.append(i);
            sb.append(' ');
            sb.append(i + 1);
            sb.append('\n');
        }
        sb.append(n);
        sb.append(' ');
        sb.append(1);
        if (n - m > 0) {
            sb.append('\n');
        }
        for (int i = 0; i < n - m; i++) {
            sb.append(min1ind + 1);
            sb.append(' ');
            sb.append(min2ind + 1);
        }
        System.out.println(sb);
    }
}