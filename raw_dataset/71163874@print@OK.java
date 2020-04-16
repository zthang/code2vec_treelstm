public <T> void print(T obj) throws IOException {
    sb.append(obj.toString());
    commit();
}