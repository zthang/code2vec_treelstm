List<List<Integer>> convert(int[][] arr) {
    int n = arr.length;
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int j = 0; j < arr[i].length; j++) tmp.add(arr[i][j]);
        ret.add(tmp);
    }
    return ret;
}