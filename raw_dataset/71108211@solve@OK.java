static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni(), k = ni();
    int cx = 0;
    ArrayList<Integer> times = new ArrayList<>();
    ArrayList<String> sym = new ArrayList<>();
    while (cx < n) {
        if (cx == 0) {
            if (m - 1 > 0) {
                sym.add("R");
                times.add((m - 1));
                sym.add("L");
                times.add((m - 1));
            }
        } else {
            if (m - 1 > 0) {
                sym.add("RUD");
                times.add((m - 1));
                sym.add("L");
                times.add((m - 1));
            }
        }
        if (cx + 1 < n) {
            sym.add("D");
            times.add(1);
        }
        cx++;
    }
    if (n - 1 > 0) {
        sym.add("U");
        times.add((n - 1));
    }
    int len = 0, sz = sym.size();
    ArrayList<Integer> times_ = new ArrayList<>();
    ArrayList<String> sym_ = new ArrayList<>();
    for (int i = 0; i < sz; ++i) {
        String s = sym.get(i);
        int count = times.get(i);
        if (s.length() * count + len <= k) {
            times_.add(count);
            sym_.add(s);
            len += s.length() * count;
        } else {
            // pl("else");
            // pl("len : "+len);
            int left = (k - len);
            int can_times_full = left / s.length();
            if (can_times_full > 0) {
                sym_.add(s);
                times_.add((can_times_full));
            }
            StringBuilder last_move = new StringBuilder();
            left -= can_times_full * s.length();
            if (left > 0) {
                for (int j = 0; j < left; ++j) {
                    last_move.append(s.charAt(j));
                }
                sym_.add(last_move.toString());
                times_.add(1);
            }
            len = k;
            break;
        }
    }
    if (len < k) {
        pl("NO");
    } else {
        sb.append("YES\n");
        sb.append(times_.size());
        sb.append("\n");
        for (int i = 0; i < times_.size(); ++i) {
            sb.append(times_.get(i));
            sb.append(" ");
            sb.append(sym_.get(i));
            sb.append("\n");
        }
        psb(sb);
    }
    pw.flush();
    pw.close();
}