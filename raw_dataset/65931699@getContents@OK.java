public List<T> getContents() {
    List<Vertex<T>> vertices = getVertices();
    List<T> contents = new ArrayList<>();
    for (int i = 0; i < vertices.size(); i++) {
        contents.add(vertices.get(i).getValue());
    }
    return contents;
}