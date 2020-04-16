private static void find(int a, Map<Integer, ArrayList<Integer>> map, int[] prime) {
    ArrayList<Integer> A = new ArrayList<>();
    for (int i = 2; i * i <= a; i++) {
        if (a % i == 0) {
            A.add(i);
            A.add(a / i);
            prime[i] = 1;
            prime[a / i] = 1;
            map.put(a, A);
            return;
        }
    }
    A.add(a);
    A.add(1);
    prime[a] = 1;
    map.put(a, A);
}