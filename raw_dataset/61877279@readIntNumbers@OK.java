public int[] readIntNumbers() throws IOException {
    String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int[] parsedToInt = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
    return parsedToInt;
}