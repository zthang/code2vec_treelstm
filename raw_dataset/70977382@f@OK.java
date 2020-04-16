static void f(int s, String q) {
    if (s == 0)
        return;
    if (k == 0)
        return;
    ans1.add(Math.min(s, k));
    ans2.add(q);
    k -= Math.min(s, k);
}