void work() {
    int n = in.nextInt();
    int[][] A = new int[n][2];
    for (int i = 0; i < n; i++) {
        A[i][0] = in.nextInt();
        A[i][1] = i + 1;
    }
    Arrays.sort(A, new Comparator<int[]>() {

        public int compare(int[] arr1, int[] arr2) {
            return arr2[0] - arr1[0];
        }
    });
    ArrayList<Integer>[] rec = (ArrayList<Integer>[]) new ArrayList[2 * n];
    for (int i = 0; i < 2 * n; i++) rec[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int node1 = A[i][1] * 2 - 1;
        int node2 = A[i][1] * 2;
        int l = A[i][0];
        rec[i].add(node1);
        rec[i + l].add(node2);
    }
    for (int i = 0; i < 2 * n - 1; i++) {
        int node = rec[i].get(rec[i].size() - 1);
        for (int j = 0; j < rec[i + 1].size(); j++) {
            out.println(node + " " + rec[i + 1].get(j));
        }
        if (rec[i + 1].size() == 0)
            break;
    }
}