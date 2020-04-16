public long[] readLongNumbers() throws IOException {
    String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    long[] parsedToLong = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
    return parsedToLong;
}