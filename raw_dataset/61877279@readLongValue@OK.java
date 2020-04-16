public long readLongValue() throws IOException {
    String line = bufferedReader.readLine().replaceAll("\\s+$", "");
    long parsedToLong = Long.parseLong(line);
    return parsedToLong;
}