class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
       while(tx > sx && ty > sy){
            if(tx>ty) tx=tx%ty;
            else ty=ty%tx;
        }
       // we check extra conditions because we might end up 
       //a lower value than sx, sy while doing modulo
        return (sx==tx && sy<=ty && (ty-sy)%sx==0) || 
                (sy==ty && sx<=tx && (tx-sx)%sy==0); 
    }
    
}