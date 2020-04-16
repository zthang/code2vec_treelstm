private static void solve(InputUtil input) throws Exception {
    int n = input.readLineAsInt();
    ArrayList<Integer> unmarriedPrincess = new ArrayList<>();
    boolean[] isMarried = new boolean[n];
    for (int i = 0; i < n; i++) {
        int[] princess = input.readInts();
        int j = 1;
        for (; j < princess.length; j++) {
            if (!isMarried[princess[j] - 1]) {
                isMarried[princess[j] - 1] = true;
                break;
            }
        }
        if (j == princess.length) {
            unmarriedPrincess.add(i);
        }
    }
    if (unmarriedPrincess.size() == 0) {
        System.out.println("OPTIMAL");
    } else {
        System.out.println("IMPROVE");
        System.out.print(unmarriedPrincess.get(0) + 1);
        int k = 0;
        for (; k < n; k++) {
            if (!isMarried[k])
                break;
        }
        System.out.println(" " + (k + 1));
    }
}