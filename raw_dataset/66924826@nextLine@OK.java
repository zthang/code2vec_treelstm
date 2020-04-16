String nextLine() {
    try {
        return in.readLine();
    } catch (IOException e) {
        return "";
    }
}