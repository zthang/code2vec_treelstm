public void solve(int testNumber, InputReader in, PrintWriter out) {
    while (testNumber-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        if (k > 4 * n * m - 2 * n - 2 * m) {
            out.println("NO");
            continue;
        }
        int i = 1;
        out.println("YES");
        ArrayList<String> a = new ArrayList<>();
        if (m == 1) {
            if (k >= n - 1) {
                a.add(Integer.toString(n - 1) + " D");
                k -= (n - 1);
            } else {
                a.add(Long.toString(k) + " D");
                k = 0;
            }
            if (k <= 0) {
                printAns(a, out);
                break;
            }
            a.add(Long.toString(k) + " U");
            printAns(a, out);
            break;
        }
        while (i < n && k > 0) {
            if (k >= (m - 1)) {
                k -= (m - 1);
                a.add(Integer.toString(m - 1) + " R");
            // out.println((m-1) + " R");
            } else {
                a.add(Long.toString(k) + " R");
                // out.println(k + " R");
                k = 0;
            }
            if (k <= 0)
                break;
            if (k >= (m - 1) * 3) {
                k -= (m - 1) * 3;
                a.add(Integer.toString(m - 1) + " DUL");
            // out.println((m-1) + " DUL");
            } else {
                long count = k / 3;
                if (count != 0) {
                    a.add(Long.toString(count) + " DUL");
                    // out.println(count + " DUL");
                    k -= count * 3;
                }
                if (k == 1) {
                    a.add("1 D");
                // out.println("1 D");
                } else if (k == 2) {
                    a.add("1 DU");
                // out.println("2 UD");
                }
                k = 0;
            }
            if (k <= 0)
                break;
            a.add("1 D");
            // out.println("1 D");
            k--;
            i++;
        }
        if (k <= 0) {
            printAns(a, out);
            break;
        }
        if (k >= m - 1) {
            a.add(Integer.toString(m - 1) + " R");
            // out.println((m-1) + " R");
            k -= (m - 1);
        } else {
            a.add(Long.toString(k) + " R");
            // out.println(k + " R");
            k = 0;
            printAns(a, out);
            break;
        }
        if (k <= 0) {
            printAns(a, out);
            break;
        }
        if (k >= m - 1) {
            a.add(Integer.toString(m - 1) + " L");
            // out.println((m-1) + " L");
            k -= (m - 1);
        } else {
            a.add(Long.toString(k) + " L");
            // out.println(k + " L");
            k = 0;
            printAns(a, out);
            break;
        }
        if (k <= 0) {
            printAns(a, out);
            break;
        }
        a.add(Long.toString(k) + " U");
        // out.println(k + " U");
        printAns(a, out);
    }
}