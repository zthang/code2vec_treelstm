        public int function(int i)
        {
            
            int left=0,right=0;
            if(i-a[i]>=0){
            if(a[i-a[i]]%2!=a[i]%2) return 1;
            else {  left=1+function(i-a[i]); }
            }
         
            if(a[i]+i<n)
            {
            if(a[a[i]+i]%2!=a[i]%2) return 1;
            else {  right=1+function(a[i]+i); }
            }
            
            if(left==0&&right!=0) entry[i]=right;
            else if(right==0&&left!=0) entry[i]=left;
            else if(left==0&&right==0) { entry[i]=-1; return -1;}
            else
            entry[i]=Math.min(left,right);
            return entry[i];
        }