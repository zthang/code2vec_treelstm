static ArrayList<Integer> divList(int n) {
    ArrayList<Integer> div = new ArrayList<Integer>();
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            div.add(i);
            if (i * i != n) {
                div.add((int) (n / i));
            }
        }
    }
    return div;
}