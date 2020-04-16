public int[] intArr(String[] strings) throws IOException {
    int[] ints = new int[strings.length];
    int i = 0;
    for (String s : strings) {
        ints[i] = Integer.parseInt(s);
        i++;
    }
    return ints;
}