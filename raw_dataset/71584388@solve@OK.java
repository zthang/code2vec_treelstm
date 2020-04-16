public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    long k = sc.nextLong();
    ArrayList<Node> al = new ArrayList();
    long all = 0;
    for (int i = 1; i <= n; i++) {
        Node tmp = new Node(m - 1, "R");
        if (m > 1) {
            al.add(tmp);
            all += m - 1;
        }
        if (i > 1) {
            if (m > 1) {
                tmp = new Node(m - 1, "UDL");
                al.add(tmp);
                all += tmp.t * tmp.s.length();
            }
        } else {
            if (m > 1) {
                tmp = new Node(m - 1, "L");
                al.add(tmp);
                all += tmp.t * tmp.s.length();
            }
        }
        if (i < n) {
            tmp = new Node(1, "D");
            al.add(tmp);
            all++;
        } else {
            tmp = new Node(n - 1, "U");
            al.add(tmp);
            all += n - 1;
        }
    }
    // out.println();
    if (all < k) {
        out.print("NO");
        return;
    }
    out.println("YES");
    ArrayList<Node> ans = new ArrayList();
    long tot = 0;
    for (int i = 0; i < al.size(); i++) {
        if (tot == k)
            break;
        Node now = al.get(i);
        String s = now.s;
        long t = now.t;
        if (tot + t * s.length() <= k) {
            ans.add(now);
            tot += t * s.length();
            continue;
        }
        long rest = k - tot;
        if (rest / s.length() != 0) {
            ans.add(new Node(rest / s.length(), s));
            tot += (rest / s.length()) * s.length();
        }
        if (rest % s.length() != 0) {
            int to = (int) rest % s.length();
            ans.add(new Node(1, s.substring(0, to)));
            tot += to;
        }
    }
    out.println(ans.size());
    for (Node nd : ans) {
        out.println(nd.t + " " + nd.s);
    }
}