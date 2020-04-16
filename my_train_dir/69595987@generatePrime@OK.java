private static void generatePrime(int n) {
    // O(NloglogN)
    boolean[] arr = new boolean[n + 5];
    Arrays.fill(arr, true);
    for (int i = 2; i * i <= n; i++) {
        if (arr[i] == true) {
            for (int j = i * i; j <= n; j += i) {
                arr[j] = false;
            }
        }
    }
    int count = 0;
    int start = 0;
    for (int i = 2; i <= n; i++) {
        if (arr[i] == true) {
            // System.out.println(i + " ");
            count++;
        }
        if (count == (start * 100) + 1) {
            // System.out.println(i);
            start++;
        }
    }
    System.out.println();
    System.out.println(count);
}