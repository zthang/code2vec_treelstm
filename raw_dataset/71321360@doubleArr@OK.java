public double[] doubleArr(String[] strings) {
    double[] doubles = new double[strings.length];
    int i = 0;
    for (String s : strings) {
        doubles[i] = Double.parseDouble(s);
        i++;
    }
    return doubles;
}