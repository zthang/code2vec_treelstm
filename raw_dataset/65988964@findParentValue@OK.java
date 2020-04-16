public String findParentValue(String data) {
    Node node = map.get(data);
    return findParentNode(node).data;
}