String nextLine() {
    String x = "";
    try {
        x = br.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return x;
}