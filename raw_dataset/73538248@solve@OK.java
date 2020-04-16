static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt(), i = 4 * n * m - 2 * (n + m), j;
    ArrayList<obj> al = new ArrayList<>();
    if (i < k)
        op.println("NO");
    else {
        op.println("YES");
        String a = "RDU", b = "L", c = "D", d = "U", e = "R";
        i = (n - 1) * (4 * m - 3);
        if (i >= k) {
            j = k / (4 * m - 3);
            while (j-- > 0) {
                if (m > 1) {
                    al.add(new obj(m - 1, a));
                    al.add(new obj(m - 1, b));
                }
                al.add(new obj(1, c));
                k -= (4 * m - 3);
            }
            if (k > 0) {
                j = Math.min(k / 3, m - 1);
                if (j > 0)
                    al.add(new obj(j, a));
                k -= (3 * j);
                if (j < (m - 1)) {
                    j = k % 3;
                    if (j != 0)
                        al.add(new obj(1, a.substring(0, j)));
                    k -= j;
                }
            }
            if (k > 0) {
                j = Math.min(m - 1, k);
                if (j > 0)
                    al.add(new obj(j, b));
                k -= j;
            }
            if (k > 0) {
                --k;
                al.add(new obj(1, c));
            }
        } else {
            j = n - 1;
            while (j-- > 0) {
                if (m > 1) {
                    al.add(new obj(m - 1, a));
                    al.add(new obj(m - 1, b));
                }
                al.add(new obj(1, c));
                k -= (4 * m - 3);
            }
            i = m - 1;
            if (i >= k) {
                j = k;
                if (j > 0)
                    al.add(new obj(j, e));
                k -= j;
            } else {
                j = m - 1;
                if (j > 0)
                    al.add(new obj(j, e));
                k -= j;
                i = m - 1;
                if (i >= k) {
                    j = k;
                    if (j > 0)
                        al.add(new obj(j, b));
                    k -= j;
                } else {
                    j = m - 1;
                    if (j > 0)
                        al.add(new obj(j, b));
                    k -= j;
                    if (k > 0)
                        al.add(new obj(k, d));
                    k = 0;
                }
            }
        }
        op.println(al.size());
        for (i = 0; i < al.size(); ++i) {
            op.print(al.get(i).ct + " ");
            for (j = 0; j < al.get(i).ar.length; ++j) op.print(al.get(i).ar[j]);
            op.println();
        }
    }
    op.flush();
    op.close();
}