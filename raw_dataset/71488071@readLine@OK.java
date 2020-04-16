private static String readLine(BufferedReader in) {
    try {
        return in.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}