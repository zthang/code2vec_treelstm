  public void setGraph(){
    Scanner sc=new Scanner(System.in);
    numVertices=sc.nextInt();
    numEdges=sc.nextInt();
    String u=sc.nextLine();
    for (int i=1;i<=numVertices;i++){
      a[i]=sc.nextInt();
    }
    u=sc.nextLine();
  }