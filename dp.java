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
    

//Write a method to return all subsets of a set.
// Get subsets of 0 to n-1 and add n to each

List<List<Integer>> getSubsets(LIst<Integer> list){
    
    getSubsets(list,  list.size() -1 ); // end index not inclusive
    
}
List<List<Integer>> getSubsets(LIst<Integer> list,int size){
    
    if (size ==1){
        return list.stream()
            .map(element -> ImmutableList.of(element))
            .collect(toImmutableList());
    } //O n
    List<List<Integer>> subsets = getSubsets(list, size-1);
    int extraElement = list.get(size-1); //last element
    return subsets.stream()
        .map(subset -> ImmutableList<INteger>.newBuilder().addAll(subset).add(lastElement).build())
        .collect(toImmutableLIst());
}
    
    
// Iterative
List<List<INteger>> getSubsets(List<INteger> list){
    List<List<Integer>> subSets = new ArrayList<Integer>();
    
    List<List<Integer>> subSet1 = list.stream()
        .map(element -> ImmutableList.of(element)) //O n
        .collect(toImmutableList());
    subSets.addAll(subSet1);
    
    for (int i=2;i< list.size(); i++){
        Integer newElement = list.get(i);
        List<List<Integer>>  newSubses = subSets.stream() // O subset count
            .map(subset -> ImmutableList.<Integer>newBuilder().addAll(subset).add(newElement).build())
            .collect(toImmutableList());
        subSets.addAll(newSubSets);
    }
    return subSets;
    
}




// multiply two positive integers without using the * operator (or / operator). You can use addition, subtraction, and bit shifting

// 12 x 17
// 24 x 8.5
// 48 4.25
// 96 2.125
// 192 1.0625

// = 192 (1+.0625)
//     192 * .0625 -> 192/16 -> 192 4 right bit shifts
    
int multiply(int A, int B){
    
    
    int m1=A;
    int m2=B;
    int shifts = 0;
    while (m2 >=2 ){
        m1 = m1 << 1;
        m2 = m2 >> 1;
        shifts++;
    }// log (B)
    
    // need to right shift m1 by shifts
    decimalPart =  m1 >> shifts;
    return m1 + decimalPart;
}


// towers of hanoi
//move(n, A, B , C) -> move(n-1, A, C, B) , move(1, A , C)

void move(Stack A, Stack B, Stack C){
 
    
}
    
void move(int n, Stack<Integer> A,  /* target */ Stack<Integer> B, /*temp*/ Stack<Integer> C){
    if (n==1){
        C.push(A.pop());
        return;
    }
    
    move(n-1, A, C, B);
    move(1, A, B, C);
    move(n-1, C, B, A);
}
    
    
//compute all permutations of a string of unique characters
// a b c d e -> a interweave perms(bc d e)
//  interweave -> p(n-1) -> n positions x (n-1)! perms -> n! + (n-1)! + (n-2)! + ... 1

List<String> getPerms(String inputStr){
 
    
    
}

List<String> interweave (Character C, String perm){

    String laggingStr /* LS */ = perm.substring(1);
    Character firstChar = perm.getCharAt(0);
    
    // doBaseCase here
    if (LS.length == 1){
    
    }
    List<String> prevPerms = interweave(firstChar, laggingStr);
    
    // initialise with prev list.
    List<String> permsToReturn = new ArrayList<>(prevPerms);
    
    prevPerms.stream()
        .map(prevPerm -> interweave(firstChar, prevPerm))
        .forEach(modPerm -> permsToReturn.add(modPerm));
    
    return prevPerms;
}

abcde
iw(a, bcde) 
    -> iw (
    
List<String> interweave(Character C, String baseStr){
    List<String> woven = new ArrayList<>();
    woven.add("" + C + baseStr);
    for (i=1; i== baseStr.length; i++){
        String part1 = baseStr.subString(0,i-1);
        String part2 = baseStr.subString(i);
        woven.add(part1 + C + part2);
    }
}
    
        
        
    
    // return AB & BA   
}
    
    
// print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses. 
/*
1->()
    2-> [1] = () ; add before -> () (); add around -> (()) -> add after > ()();  = { ()() , (()) }
    3-> [2], [1] ; weave [1] into [2];  add around    -> ()()() , ()(()), (())(), 
    3-> [2] ; add before ()()(),()(()). add after ()()(),(())(), add around (()()),((())) -> ()()(),()(()),(())(),(()()),((()))
    4-> [3] ; before 
    
    paren[k] -> for (m=1..k-1) parens[m], parens[k-m] -> combine(?)
    for (S in parens[m]) for (S2 in parens[k-m]) concat(S,S2) and add to list for k 
    for (S in parens[k-1]) concat '(', S, ')' and add to list for k
*/
String getAllParens(int N){

    Map<Integer, Set<String>> parensByCOunt = new HashMap<>();
    parensByCount.put(1, ImmutableSet.of("()"));
    
    for (int s = 2; s< N ; s++){ // each possible size - 
        for ( int m = 1; m<=s; m++){ // each intermediate split
            int sz1 = m;
            int sz2 = s-m;
            Set<String> parens1 = parensByCount.get(sz1);
            Set<String> parens2 = parensByCount.get(sz2);
            // cobine 1 and 2
            Set<String> combined = combine(parens1, parens2);
            parensByCount.put(s, combined);
        }
    }
    

    
    
    
}
    
    
    
//  given a screen (represented by a two-dimensional array of colors), a point, and a new color, 
// fill in the surrounding area until the color changes from the original color. 

// BFS
    //paint and put all green neoghbors ona queue
    //keep till queue is empty
    
class Point{
    int x;
    int y;
    POint(int x, int y){
        this.x=x;
        ..
}
int maxX,maxY;
    
void paint(int[][] canvas, int initcolor, int initX, int initY){
    maxX = canvas.length-1;
    maxY = canvas[0].length-1;
    
    Queue<Point> queue = new Queue<>();
    if (canvas[initX][initY] == initColor){
        qeueu.offer(new Point(initX,initY)));
    }
    
    while (!queue.isEmpty()){
        Point p = queue.get();
        // get all initcolor neighbors
        queue.addAll(getNeighbors(p, initColor));
    }
        
}
Set<Point> getNeighbors(POint p, int color){
    
    
}
    
// Given an infinite number of quarters (25 cents), dimes (1 O cents), nickels (5 cents), and
// pennies (1 cent), write code to calculate the number of ways of representing n cents.

// ways[n] = ways[n-1] + ways[n-5] + ways[n-10] + ways[n-25];    

int getWays(int N){
    
    int[] ways = int[N+1];
    //Alternative use Map<Integer, Integer> ways = new HashMap<>();
    
    ways[0] = 1; // when the target value is the value os a given coin
    ways[1] = 1;
    
    for (int val = 2; val <=N ; val++){
        int newWays = ways[val-1]; // initialize with adding one coin to previous
        if( val >= 5){
            newWays += ways[val-5];
        }
        if( val >= 10){
            newWays += ways[val-10];
        }
        if( val >= 25){
            newWays += ways[val-25];
        }
    }
    return ways[N];
        
    
    
//eight queens on an 8x8 chess board so that none of them share the same row, column, or diagonal.

class Cell{int row; int column;}
    
queue of occupied cells list - > call next row occu
    
class Combo {
    Set<Cell> occupied;
    boolean feasible;
    add(Cell cell);
}

// All indexes rows and columns are 1 based    
void arrange(List<Cell> occupied){
    // occupation always starts from row 1, 2 dwnwrdas
    Queue<Combo> combos = new Queue<>();
    Set<Conbo> completed = new HashSet<>();
    
    //fill for first row
    for (int col = 1..8){
        combos.offer(new Combo(ImmutableSet.of(new Cell(1,col)));
    }
    while(!queue.isEmpty()){
        
        Combo combo = queue.poll();
        // Get the next fea
        int nextRow = combo.getOccupied().size() + 1;
        for (int col = 1..8){
            Cell nextCell = new Cell(nextRow, col);
            if (!violates(combo.getOccupied(), nextCell)){
                Combo newCombo = new Combo(ImmutableSet.newBuilder()
                                           .addAll(combo.getOccupied())
                                           .add(nextCell)).build()));
                if (combo.getOccupied().getSize() == 8){
                    completed.add(combo);
                } else {
                    combos.offer(combo);
                }
            }
        }
    }
    return completed.size();
                     
}
    
boolean violates(Set<Cell> occupied, Cell newCell){
    return occupied.stream()
        .filter(occupiedCell -> occupiedCell.getRow() == newCell.getRow()
                || occupiedCell.getColumn() == newCell.getColumn()
                || Math.abs(occupiedCell.getColumn() - newCell.getColumn())
                 == Math.abs(occupiedCell.getRow() - newCell.getRow()))
        .anyMatch();
}
    
    
    
    
