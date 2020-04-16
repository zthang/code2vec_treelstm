static int[] parseArray(BufferedReader gi) throws IOException {
    String[] line = gi.readLine().split(" ");
    int[] rez = new int[line.length];
    for (int k = 0; k < line.length; k++) {
        rez[k] = Integer.parseInt(line[k]);
    }
    return rez;
}