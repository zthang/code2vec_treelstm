public static int[] sia(int n) throws Exception {
    int[] a = new int[n];
    String line = br.readLine();
    String[] strs = line.trim().split("\\s+");
    for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(strs[i]);
    }
    return a;
}