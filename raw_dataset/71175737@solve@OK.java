public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    n--;
    String s = sc.next();
    ArrayList<Integer> al = new ArrayList();
    al.add(0);
    int now = 0;
    int flag = 0;
    if (s.charAt(0) == '>')
        flag = 1;
    for (int i = 0; i < n; i++) {
        if (i == n - 1) {
            if (s.charAt(i) == '>') {
                if (flag == 0)
                    al.add(now);
                now--;
                al.add(now);
                break;
            } else if (s.charAt(i) == '<') {
                if (flag == 1)
                    al.add(now);
                now++;
                al.add(now);
                break;
            }
        }
        if (s.charAt(i) == '>') {
            if (flag == 1)
                now--;
            else {
                flag = 1;
                al.add(now);
                now--;
            }
        } else {
            if (flag == 0)
                now++;
            else {
                flag = 0;
                al.add(now);
                now++;
            }
        }
    }
    ArrayList<Integer> inc = new ArrayList();
    int ind = 1;
    now = 1;
    if (al.get(1) < 0) {
        ind = 2;
        int to = Math.abs(al.get(1)) + 1;
        for (int i = to; i >= 1; i--) {
            inc.add(i);
        }
        now = to + 1;
    }
    for (int i = ind; i < al.size(); i += 2) {
        int left = al.get(i) - al.get(i - 1) - 1;
        if (i == 1 && al.get(i - 1) < al.get(i))
            left++;
        int right = 1;
        if (i + 1 < al.size()) {
            right = al.get(i) - al.get(i + 1) + 1;
        }
        while (left-- > 0) {
            inc.add(now++);
        }
        int tmp = now + right - 1;
        while (right-- > 0) {
            inc.add(tmp--);
            now++;
        }
    }
    ArrayList<Integer> dec = new ArrayList();
    ind = al.size() - 1;
    now = 1;
    if (al.get(al.size() - 2) < al.get(al.size() - 1)) {
        ind = al.size() - 2;
        int to = Math.abs(al.get(al.size() - 1) - al.get(al.size() - 2)) + 1;
        for (int i = to; i >= 1; i--) {
            dec.add(i);
        }
        now = to + 1;
    }
    for (int i = ind; i >= 0; i -= 2) {
        int left = 0;
        if (i - 1 >= 0)
            left = 1;
        if (i - 2 >= 0) {
            left = al.get(i - 1) - al.get(i - 2) + 1;
        }
        int right = 0;
        if (i - 1 >= 0)
            right = al.get(i - 1) - al.get(i) - 1;
        if (i == al.size() - 1)
            right++;
        while (right-- > 0) {
            dec.add(now++);
        }
        int tmp = now + left - 1;
        while (left-- > 0) {
            dec.add(tmp--);
            now++;
        }
    }
    for (int i = dec.size() - 1; i >= 0; i--) out.print(dec.get(i) + " ");
    out.println();
    for (int i : inc) out.print(i + " ");
    out.println();
}