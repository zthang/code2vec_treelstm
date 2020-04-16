private static void getChains(int N, int M, int[] w) {
    if (N == 2) {
        System.out.println("-1");
        return;
    }
    if (M < N) {
        System.out.println("-1");
        return;
    }
    Fridge[] fridges = new Fridge[N];
    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += w[i];
        fridges[i] = new Fridge(i + 1, w[i]);
    }
    Arrays.sort(fridges);
    Fridge m1 = fridges[0];
    Fridge m2 = fridges[1];
    int extraChains = (M - N);
    int answer = (2 * sum) + (extraChains * (m1.weight + m2.weight));
    System.out.println(answer);
    for (int i = 1; i < N; i++) {
        System.out.println(i + " " + (i + 1));
    }
    System.out.println(1 + " " + N);
    for (int i = 0; i < extraChains; i++) {
        System.out.println(m1.index + " " + m2.index);
    }
}