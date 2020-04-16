String nextString() {
    String res = in.nextLine();
    return res.trim().isEmpty() ? in.nextLine() : res;
}