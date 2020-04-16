public String joinElements(Object[] ar) {
    StringBuilder sb = new StringBuilder();
    for (Object itr : ar) sb.append(itr).append(" ");
    return sb.toString().trim();
}