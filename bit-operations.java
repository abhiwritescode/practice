// insert M into N such that M starts at bit j and ends at bit i

int insert(int M, int N, int i, int j){
    // i> j
    //create mask from i to j
    int mask = getmaskIJ(i, j);
    N = N | mask; // replaces all bits from i to j in N to 1
    return N&M;
 
    
}
// one line unreadable
return M & ( N | (~(~0 << (i-j)))<<j )

int getmaskIJ(int i, int j){
    
    return (~(~0 << (i-j)))<<j;
//     int shift = 1;
//     for (int k = 0; k< (i-j) ; k++){
//         shift = 1+ shift<<1;
//     }
//     return shift<<j;
}

    
  
  
