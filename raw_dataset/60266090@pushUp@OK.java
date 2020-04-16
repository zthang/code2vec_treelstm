public void pushUp() {
    if (this == NIL) {
        return;
    }
    size = left.size + right.size + 1;
    containEdge = null;
    if (chain != null) {
        containEdge = this;
    } else if (left.containEdge != null) {
        containEdge = left.containEdge;
    } else {
        containEdge = right.containEdge;
    }
    infoWithMaxLevel = null;
    if (info != null) {
        infoWithMaxLevel = this;
    }
    if (left.infoWithMaxLevel != null && (infoWithMaxLevel == null || infoWithMaxLevel.info.level < left.infoWithMaxLevel.info.level)) {
        infoWithMaxLevel = left.infoWithMaxLevel;
    }
    if (right.infoWithMaxLevel != null && (infoWithMaxLevel == null || infoWithMaxLevel.info.level < right.infoWithMaxLevel.info.level)) {
        infoWithMaxLevel = right.infoWithMaxLevel;
    }
}