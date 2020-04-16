/*
    	 * int[] a=new int[n];
    	 * for(int i=0;i<n;i++){
    	 * 		a[i]=in.nextInt()
    	 */
public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    long[] c1 = new long[n];
    long[] c2 = new long[n];
    long[] c3 = new long[n];
    int[] a = new int[n];
    int z = -1;
    ArrayList<Integer>[] e = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        e[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < n; i++) {
        c1[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
        c2[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
        c3[i] = in.nextInt();
    }
    for (int i = 0; i < n - 1; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        e[x].add(y);
        e[y].add(x);
    }
    int s = -1;
    for (int i = 0; i < n; i++) {
        if (e[i].size() > 2) {
            out.println(-1);
            return;
        }
        if (s == -1 && e[i].size() == 1) {
            z = i;
            s = i;
        }
    }
    int[] vis = new int[n];
    // out.println(s);
    long cost12 = 0, cost13 = 0, cost21 = 0, cost23 = 0, cost31 = 0, cost32 = 0;
    int j = 0;
    while (j != n) {
        // System.out.println(j+" "+s);
        int i = 0;
        if (j % 3 == 0) {
            cost12 += c1[s];
            cost13 += c1[s];
            cost21 += c2[s];
            cost23 += c2[s];
            cost31 += c3[s];
            cost32 += c3[s];
        } else if (j % 3 == 1) {
            cost12 += c2[s];
            cost13 += c3[s];
            cost21 += c1[s];
            cost23 += c3[s];
            cost31 += c1[s];
            cost32 += c2[s];
        } else {
            cost12 += c3[s];
            cost13 += c2[s];
            cost21 += c3[s];
            cost23 += c1[s];
            cost31 += c2[s];
            cost32 += c1[s];
        }
        if (j != n - 1 && vis[e[s].get(i)] == 1) {
            i++;
        }
        vis[s] = 1;
        s = e[s].get(i);
        j++;
    }
    // out.println("costs");
    long ans = Math.min(cost12, cost13);
    // out.println(ans);
    ans = Math.min(ans, cost21);
    // out.println(ans);
    ans = Math.min(ans, cost23);
    // out.println(ans);
    ans = Math.min(ans, cost31);
    // out.println(ans);
    ans = Math.min(ans, cost32);
    out.println(ans);
    j = 0;
    for (int i = 0; i < n; i++) {
        vis[i] = 0;
    }
    while (j != n) {
        // out.println(j+" "+z);
        if (j % 3 == 0) {
            if (cost12 == ans) {
                a[z] = 1;
            } else if (cost13 == ans) {
                a[z] = 1;
            } else if (cost21 == ans) {
                a[z] = 2;
            } else if (cost23 == ans) {
                a[z] = 2;
            } else if (cost31 == ans) {
                a[z] = 3;
            } else if (cost32 == ans) {
                a[z] = 3;
            }
        } else if (j % 3 == 1) {
            if (cost12 == ans) {
                a[z] = 2;
            } else if (cost13 == ans) {
                a[z] = 3;
            } else if (cost21 == ans) {
                a[z] = 1;
            } else if (cost23 == ans) {
                a[z] = 3;
            } else if (cost31 == ans) {
                a[z] = 1;
            } else if (cost32 == ans) {
                a[z] = 2;
            }
        } else {
            if (cost12 == ans) {
                a[z] = 3;
            } else if (cost13 == ans) {
                a[z] = 2;
            } else if (cost21 == ans) {
                a[z] = 3;
            } else if (cost23 == ans) {
                a[z] = 1;
            } else if (cost31 == ans) {
                a[z] = 2;
            } else if (cost32 == ans) {
                a[z] = 1;
            }
        }
        int i = 0;
        if (j != n - 1 && vis[e[z].get(i)] == 1) {
            i++;
        }
        vis[z] = 1;
        z = e[z].get(i);
        j++;
    }
    for (int i = 0; i < n; i++) {
        out.print(a[i] + " ");
    }
    out.println();
}