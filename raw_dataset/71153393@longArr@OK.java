public long[] longArr(String[] strings) throws IOException {
    long[] longs = new long[strings.length];
    int i = 0;
    for (String s : strings) {
        longs[i] = Long.parseLong(s);
        i++;
    }
    return longs;
}