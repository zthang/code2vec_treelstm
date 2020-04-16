static long[] longs() throws IOException {
    String[] line = br.readLine().split(" ");
    long[] longs = new long[line.length];
    for (int i = 0; i < line.length; i++) longs[i] = Long.parseLong(line[i]);
    return longs;
}