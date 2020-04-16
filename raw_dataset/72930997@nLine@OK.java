String nLine() {
    try {
        return br.readLine();
    } catch (IOException e) {
        return "-1";
    }
}