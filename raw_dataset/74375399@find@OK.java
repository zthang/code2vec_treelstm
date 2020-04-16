static boolean find(int N) {
    String r = "";
    int rem = 1 % N;
    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
    while ((rem != 0) && !h.containsKey(rem)) {
        h.put(rem, r.length());
        rem = rem * 10;
        r = r + (rem / N);
        rem = rem % N;
    }
    if (rem == 0)
        return (false);
    else
        return (true);
}