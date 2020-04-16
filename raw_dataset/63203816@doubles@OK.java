static double[] doubles() throws IOException {
    String[] line = br.readLine().split(" ");
    double[] doubles = new double[line.length];
    for (int i = 0; i < line.length; i++) doubles[i] = Double.parseDouble(line[i]);
    return doubles;
}