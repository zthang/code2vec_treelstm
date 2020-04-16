void print(Object... args) {
    String prefix = "";
    for (Object arg : args) {
        out.append(prefix);
        out.append(arg);
        prefix = " ";
    }
}