public void println(Object... objects) {
    for (int i = 0; i < objects.length; i++) {
        sb.append(objects[i]);
    }
    res.add(sb.toString());
    sb = new StringBuilder("");
}