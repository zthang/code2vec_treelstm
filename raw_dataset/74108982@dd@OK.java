public static ArrayList<Integer> dd(int n) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            list.add(n / i);
            list.add(i);
        }
    }
    return list;
}