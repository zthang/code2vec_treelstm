void solve() {
    StringBuffer sb = new StringBuffer();
    int N = ni();
    int M = ni();
    int K = ni();
    List<Item> l = new ArrayList<Item>();
    for (int i = 0; i < N; i++) {
        if (M > 1) {
            l.add(new Item(M - 1, "R"));
            if (i == 0)
                l.add(new Item(M - 1, "L"));
            else
                l.add(new Item(M - 1, "UDL"));
        }
        if (i < N - 1)
            l.add(new Item(1, "D"));
        else
            l.add(new Item(N - 1, "U"));
    }
    int rem = K;
    int i = 0;
    for (; i < l.size(); i++) {
        rem -= l.get(i).len();
        if (rem <= 0) {
            l = l.subList(0, i + 1);
            break;
        }
    }
    if (rem < 0) {
        Item it = l.remove(i);
        rem += it.len();
        int cnt = rem / it.str.length();
        if (cnt > 0) {
            l.add(new Item(cnt, it.str));
            rem -= cnt * it.str.length();
        }
        if (rem > 0)
            l.add(new Item(1, it.str.substring(0, rem)));
        rem = 0;
    }
    if (rem > 0)
        out.println(NO);
    else {
        out.println(YES);
        out.println(l.size());
        for (Item it : l) sb.append(it.n).append(' ').append(it.str).append(System.lineSeparator());
        out.print(sb);
    }
}