//grid with r rows and c columns.
//The robot can only move in two directions, right and down, but certain cells are "off limits
//find a path for the robot from the top left to the bottom right. 

Cell{
    int x,y;
    boolean allowed;
}

Map<Cell, INteger> numPaths ;// Store cell to paths from it


// recursive - simplerr
// Stack - buggy

int R;
int C;
Cell[][] M;
int getnumPaths(Cell[][] matrix){
    
    if (M.length ==0 || M[0].length ==0){
        return 0;
    }
    R = matrix.length;
    C= matrix[0].length;
    M = matrix;
    return getPathsFRom[0][0];
    
    
}

int getPathsFRom(Cell cell){
    
    if ( !cell.allowed) {
        return 0;
    }
    if ( cell.row == R-1 && cell.columne == C-1){
        return 1;
    }
    return
        cell.row + 1 < R-1 ?   getPathsFrom(M[cell.row+1], M[cell.column]) : 0
        + cell.column + 1 < R-1 ?   getPathsFrom(M[cell.column+1], M[cell.row]) : 0;
    
}
  
//Stack non-recursive approach
int getPathsFRom(Cell cell){

    
    Stack stack = new Stack();
    Map<Cell, INteger> numPaths = new HashMap<>();// Store cell to paths from it

//    stack.push(M[0][0]);
    for (int r=0; r< R;r++){ //O(RC)
        for (int c<0;c<C; c++){
            
            if (M[r][c].allowed) {
                stack.push(M[r][c]);
            }
        }
    }
    
    while (!stack.empty()){ O(RC)
        
        Cell cell = stack.pop();
        int pathsFromCell;
        if (cell.row == R-1 || cell.col = C-1){
            paths = 1;
        }
        else {
            if ( cell.row + 1] < R-1 && M[cell.row+1][cell.col].allowed){
                //can go down
                paths+= numPaths.getOrDefault(M[cell.row+1][cell.col] ,0) ;
            }
            if ( cell.col + 1] < C-1 && M[cell.row][cell.col+1].allowed){
                //can go right
                paths+= numPaths.getOrDefault(M[cell.row][cell.col+1] ,0) ;
            }
        }
        numPaths.put(M[cell.row][cell.col], paths);
    }
    return numPaths.put(M[0][0]);
    
}




// : A magic index in an array A [ 0 ••• n -1] is defined to be an index such that A[ i] =
//i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
//array A.


int findMagicIndex(int[] A){

    int start =0;
    int end =A.length -1  ;
    
    while (end-start >= 0 ){
        
        int mid = getMidpoint(start, end);
        if (A[mid] == mid ){
            return mid;
        }
        if (A[mid] < mid){ 
            //go right
            start=mid+1;
        } else if (A[mid] > mid){ 
            //go right
            end=mid - 1;
        }
    }
    return -1;
}

int getMidpoint(int start, int end){
    if (start == end){
        return start;
    } 
    int mid = start +  (end-start)/2;
}
    
