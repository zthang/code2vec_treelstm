public void printf(String format, Object... args) {
    buf.append(String.format(format, args));
}