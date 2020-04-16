private void run() {
    int t = cin.nextInt();
    while (t > 0) {
        t--;
        int n = cin.nextInt();
        String s = cin.nextLine();
        int countDown = n;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < n && s.charAt(i) == '<') {
                int cnt = 0;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) == '<') {
                        cnt++;
                    } else {
                        break;
                    }
                }
                for (int j = i + cnt; j >= i; j--) {
                    a[j] = countDown--;
                }
                i = i + cnt;
            } else {
                a[i] = countDown--;
            }
        }
        countDown = n;
        int[] b = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && s.charAt(i) == '>') {
                int cnt = 0;
                for (int j = i; j >= 1; j--) {
                    if (s.charAt(j) == '>') {
                        cnt++;
                    } else {
                        break;
                    }
                }
                for (int j = i - cnt; j <= i; j++) {
                    b[j] = countDown--;
                }
                i = i - cnt;
            } else {
                b[i] = countDown--;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(a[i] + " ");
        }
        out.println("");
        for (int i = 0; i < n; i++) {
            out.print(b[i] + " ");
        }
        out.println("");
    }
    out.close();
}