public String toDot() {
    StringBuilder sb = new StringBuilder("graph{\n");
    sb.append("graph[rankdir=LR];\n");
    sb.append("node[shape=circle];\n");
    for (int i = 0; i < 20; i++) {
        Level lv = lvs[i];
        for (Node node : lv.forest) {
            if (node != null) {
                // if(node.up == null && node.from < node.to){
                if (node.from < node.to) {
                    sb.append("\"" + node.from + "\"").append("--").append("\"" + node.to + "\"").append("[label=\"" + i + "\"];\n");
                }
                for (Node x = node.next; x != node; x = x.next) {
                    // if(x.up == null && x.from < x.to){
                    if (x.from < x.to) {
                        sb.append("\"" + x.from + "\"").append("--").append("\"" + x.to + "\"").append("[label=\"" + i + "\"];\n");
                    }
                }
            }
        }
    // for(int from = 0;from < lv.auxis.size();from++){
    // if(lv.auxis.get(from) != null){
    // for(int to : lv.auxis.get(from)){
    // if(from < to){
    // sb.append("\"" + from + "\"")
    // .append("--")
    // .append("\"" + to + "\"")
    // .append("[style=dashed,label=\"" + i +"\"];\n");
    // }
    // }
    // }
    // }
    }
    sb.append("}\n");
    return sb.toString();
}