public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    if (k <= n - 1) {
        w.println("YES");
        w.println(1);
        w.println(k + " D");
    } else if (k <= 2 * n - 2) {
        w.println("YES");
        w.println(2);
        w.println(n - 1 + " D");
        w.println(k - n + 1 + " U");
    } else if (k > 4 * n * m - 2 * n - 2 * m) {
        w.println("NO");
    } else if (n == 1) {
        if (k <= m - 1) {
            w.println("YES");
            w.println(1);
            w.println(k + " R");
        } else if (k <= 2 * m - 2) {
            w.println("YES");
            w.println(2);
            w.println(m - 1 + " R");
            w.println(k - m + 1 + " L");
        }
    } else {
        ArrayList<Temp> ans = new ArrayList();
        ans.add(new Temp("D", n - 1));
        ans.add(new Temp("U", n - 1));
        k = k - 2 * n + 2;
        int cnt = 0;
        while (cnt < m - 1) {
            if ((n - 1) * 3 >= k) {
                if (k >= 3) {
                    ans.add(new Temp("RDL", k / 3));
                }
                int temp = k % 3;
                if (temp == 1) {
                    ans.add(new Temp("R", 1));
                } else if (temp == 2) {
                    ans.add(new Temp("RD", 1));
                }
                k = 0;
                break;
            }
            ans.add(new Temp("RDL", n - 1));
            k = k - (n - 1) * 3;
            if (k == 1) {
                ans.add(new Temp("R", 1));
                k = 0;
                break;
            }
            ans.add(new Temp("R", 1));
            k--;
            if (k <= n - 1) {
                ans.add(new Temp("U", k));
                k = 0;
                break;
            }
            ans.add(new Temp("U", n - 1));
            k = k - (n - 1);
            cnt++;
        }
        if (k > 0) {
            ans.add(new Temp("L", k));
        }
        w.println("YES");
        w.println(ans.size());
        for (Temp t : ans) {
            w.println(t.num + " " + t.a);
        }
    }
    w.close();
}