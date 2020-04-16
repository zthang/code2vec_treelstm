private static void fill(int[] arr, Node[] G, int s, int n) {
    boolean[] tmp = new boolean[arr.length];
    for (int node : G[n].e) tmp[node] = true;
    for (int i = 1; i < arr.length; i++) if (!tmp[i])
        if (arr[i] == 0)
            arr[i] = s;
        else
            exit();
}