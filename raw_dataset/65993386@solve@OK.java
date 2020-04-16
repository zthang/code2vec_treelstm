public static void solve(FastIO io) {
    int n = io.nextInt();
    int sqrt = (int) Math.sqrt(n);
    TreeSet<Integer> nums = new TreeSet<>();
    nums.add(0);
    for (int i = 1; i <= sqrt; i++) {
        nums.add(i);
        nums.add(n / i);
    }
    io.println(nums.size());
    for (int k : nums) {
        io.print(k + " ");
    }
    io.println();
}