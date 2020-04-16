public void run(FastScanner sc, FastPrinter out) throws Exception {
    n = sc.nextInt();
    m = sc.nextInt();
    adj = sc.readGraph(n, m, true, true);
    int[] nums = new int[n];
    assignNums(0, nums, new int[6]);
    System.out.println(ans);
}