    public static void DFS(int s,int prec,ArrayList<Case>[] graphe,boolean[] V,long[] score,Max M)
    {
        int b=0;
        int i=0;
        
        if(graphe[s].size()!=1)
        {
            M.max+=score[s];  
        }
        V[s]=true;
        //System.out.print(s+" ");
        for(i=0;i<graphe[s].size();i++)
        {
            if(V[graphe[s].get(i).sommet] != true)
            {  
                b=1;
                DFS(graphe[s].get(i).sommet,s,graphe,V,score,M);
            }
        }
        
        
        
        
       /*if(b==0)
       {      
           int l=0;
           for(i=0;i<V.length;i++)
           {
               if(V[i]==false){
                   l=1;
                   break;
               }
           }
           if(l==0) 
            return;
           
           for(i=0;i<graphe[s].size();i++)
           {
               if(graphe[s].get(i).sommet!=prec)
               {
                   b=1;
                   DFS(graphe[s].get(i).sommet,s,graphe,V,score,M);
               }
           }    
           if(b==0)
           {
               M.max-=score[s];
           }
       }*/
    }