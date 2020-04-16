List<List<String>> convert(String[][] arr) {
    int n = arr.length;
    List<List<String>> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        ArrayList<String> tmp = new ArrayList<String>();
        for (int j = 0; j < arr[i].length; j++) tmp.add(arr[i][j]);
        ret.add(tmp);
    }
    return ret;
}