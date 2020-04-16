public int readIntValue() throws IOException {
    String line = bufferedReader.readLine().replaceAll("\\s+$", "");
    int parsedToInt = Integer.parseInt(line);
    return parsedToInt;
}