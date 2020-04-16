static int[] ints() throws IOException {
    String[] line = br.readLine().split(" ");
    int[] ints = new int[line.length];
    for (int i = 0; i < line.length; i++) ints[i] = Integer.parseInt(line[i]);
    return ints;
}