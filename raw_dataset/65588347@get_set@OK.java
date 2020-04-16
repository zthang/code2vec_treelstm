private static void get_set(int[] arr, int n, int m) {
    if (n > m || n <= 2) {
        System.out.println(-1);
        return;
    }
    int sum = 0;
    for (int ele : arr) {
        sum += ele;
    }
    System.out.println(2 * sum);
    for (int i = 1; i < arr.length; i++) {
        System.out.println(i + " " + (i + 1));
    }
    System.out.println(1 + " " + n);
}