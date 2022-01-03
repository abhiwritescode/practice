//find the maximum sum over all subarrays of a given array of integer

/**
Use Dp
store 
int[][] - sum[start][end]

for i= 0..len-1
  for L=1..< len -i  
    start=i
    end = i+L-1
    sum[start][end]= A[start] + sum[start+1, end]


*/


int getMaxSum(int []A){
    
    int[][] sums = new int[A.length][A.length];
    // initialize
    int max = INteger.MINVALUE;
    for ( int i = 0; i< A.length; i++){
        sums[i][i] = A[i];
        if (sums[i][i] > max)
            max = sums[i][i];
    }
    
    
    for ( int i = 0; i< A.length; i++){
        for ( int L = 2; L<A.lrngth - i ; L++){
            start = i;
            end = i+L-1;
            sums[start][end] = A[start] + sums[start+1][end];
            if (sums[start][end] > max)
                max = sums[start][end];

        }
    }
    return max;
}	

//2, 3, and 7 point plays the number of combinations of plays that result in the finalscore

/*

p[0]=0
p[1]=0
p[2]=1
p[3]=1

for (i = 1..P)
   p[i] = i>=2 ? p[i-2] + 1
      +   i>=3 ? p[i-3] + 1
      +   i>=7 ? p[i-7] + 1
*/

int getPlays (int score){
    // init 
    int[] plays = new int[score+1];
    plays[0]=0;
    plays[1]=0;
    
    for ( int i = 1; i<=score; i++)
      plays[i] = i>=2 ? plays[i-2] + 1
      +   i>=3 ? p[i-3] + 1
      +   i>=7 ? p[i-7] + 1;
}


// Get play combos only ( like bin fulling)
/*
plays[i] = {2 3 7}
i= 0.. plays -1
score[j] = all possible scores
    
ways[i][j] -> ways to get score j with the upto i plays

S = score
for i = 0.. plays-1
for j=0 .. S
  if plays[i] <= j ways[i][j] is possible = ways[i][j-plays[i]]	  
                    + ways without ways[i-1][j]
  else             not posisble  = ways[i-1][j]


for i= 0..plays-1 
    for j=1
      ways[i][j] = 0 i.e. ways[0,0] 
      ways[0,0][1,0][2,0] = 1
      ways[0,1][1,1][2,1] = 0
i = 2 3 4 
j = 1 2 3 4 5 6 7 8 9 10

0,1 ways[2][1] = ways [1][1] -> 0
0,2 ways[0=2][2] = = ways[0][0]= 1
0,3 ways   possible  ways[0=2][3-2] = ways[0][1] = 0
0,4 way  possible  ways[0=2][4-2] = ways[0][2] =1 
0,5 way  possible  ways[0=2][5-2] = ways[0][3] =0

1,1 ways[1=3][1] = ways [1][1] -> 0
1,2 ways[1=3][2] = not possnle -> ways[0,2] = 1
1,3 ways   possible  ways[1=3][3-3] = ways[0][0] = 1
1,4 way  possible  ways[1=3][4-3] = ways[1][1] =1 +  

to find wways, add the one with out ways

values[i] {2 3 7}
scores[j] 1 2 3 4 5 6 7 8 
max[i,j]
ways[i,j]
for i = 0..values-1
    for j= 0.. scores-1
        
        ways [i,j] = if j is possible with values[i] i.e. j>= values[i] 
                        ways[i , j - values[i]] - < with play of 3 to get to score -3 
                        
                        + without play of 3 to get to score 
                        
                        
        for optimal value
          max [i,j] = if j is possible then
                    value of max[i-1 , j] i.e. without ith item
                    or value of max[i-1, j- value[i]] + value[i]
        


*/



// levensteoin distance
/*
String A String B

dist(A, a, B, b){
    if 

    if (A[a] != B[b]){
        dist = 1 + min(
            dist(A, a+1, B,b+1),
            dist(A, a, B,b+1),
            dist(A, a+1, B,b));
      } else {
        dist - dist(A, a+1, B, b+1);
*/



int distance(Srting strA, String strB){
    
    char [] A = A.ticharArray();
    char [] B = B.ticharArray();
    int dist[][] = new int[A.length -1][B.length -1];
    
    dist[0][0] = A[a] == B[b] ? 0 ; 1;
     for ( int a= 0; a< A.length ; a++){
        for (int b = 0; b< B.length; b++){
            dist[a][b] = MAXVALUE;
        }
     }
    
    for ( int a= 0; a< A.length ; a++){
        for (int b = 0; b< B.length; b++){
            if (A[a] == B[b])
                dist[a][b] =  dist[max(0,a-1)][max(0,b-1)];
            else {
                int dist01 = dist[a][max(0,b-1)];
                int dist11 = dist[max(0,a-1)][max(0,b-1)];
                int dist10 = dist[max(0,a-1)][b];
                dist[a][b] = 1+  min(dist01, min(dist11, dist10));
            }
        }
    }
    return dist[A.length - 1][B.length-1];
}

/*

A: cat
B: cbt

0 0 : 0
0 1 : d01 = 0 d10 = 0 d11 = 0 -> 1
0 2 : c!=t d01=[0 1] = 1  d11=[0 1] = 1 d10 = [02] =MAX -> 1+1 = 2
1 0 : != d01=[10] = MAX  d11 = [00] = 0 d01=[10] = MAX -> 1+0 = 1
1 1 : != d01=[10] = 1 d11=[00] = 0 d10=[01] = 1 = 0 -> 1+0 = 1
1 2 : != d01=[11] = 1 d11=[01] = 1 d10[02] = 2 -> 1+1= 2
2 0 : != d01=[20] = MAX  d11=[10] = 1 d10=[10] = 1 -> 1+1=2
2 1 : != d01[20] = 2 d11[10] = 1 d10=[11] = 1  -> 1+1=2
2 2 :==  d11 = 1



*/

//, if is "gtaa" and s2 is "atc", then "gattaca" and "gtataac" can be
//formed by interleaving s2 and s2 but "gatacta" cannot. Design an algorithm that takes
//as inputstringsslr s2 and t,and determinesif t is an interleaving of and s2.
/*


gtataac ? gtaa atc

gtataa ? gtaa,at 
  -> gtata ? gta,at 
  -> gtat ? gt , at
  -> gta  ? g, at OR gta  ?gt,a
  -> false OR gt ? gt, ""
  -> 

T, A, a , B , b

if ( A[a] == B[b] ) 

bool[][] isweavw
if A[0] != T[0] && B[0] !=T[0]
    return false;

Check [0,0] = 

for Tl = 1...T.len-1
  for a= 0.. (len of A)
     b= TL - a -1
     
     T[TL] = T[TL-1] ? A[a],B[b-1] || A[a-1],B[b]

*/


boolean isWeave(String strT, String strA, String strB){
    
    char[] T = strT.toCharArray();   
    char[] A = strA.toCharArray();   
    char[] B = strB.toCharArray();   
    
    boolean isWeave[][] = new int[A.len+1][B.len+1];
    isWeave[0][0] = true; //base init
    
    for (int tl = 1; tl<=T.length; tl++){
        for (int al=0; al<=A.length; al++){
            int bl = tl-al;//length os b
            
            if (((bl > 0 &&  B[bl-1] != T[tl-1])|| bl<=0) 
                
                && (( al > 0 && A[al-1] != T[tl-1]) || al <=0)){
                isWeave[al][bl] = false;
                continue;
            }
                        
            isWeave[al][bl] = ( bl > 0 && B[bl-1] == T[tl-1] && isWeave[al]bl-1])
                           || ( al >0 && A[al-1] == T[tl-1] && isWeave[al-1][bl]);
        }
    }
    return isWeave[A.length][B.length];
}



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
    
    
///  stack of n boxes, with widths w1 , heights hi , and depths di
// stacked on top of one another if each box in the stack is strictly
// larger than the box above it in width, height, and depth. Implement a method to compute the
// height of the tallest possible stack                     

// dont start witj greedy algo, try each combo
// sort by wi 
// maxstack[wi]
//          assume sorted by one dimen - Wi, W1 being smallest

class Box {int width; int height; int depth;}
class BoxStack{
    Box base;
    Set<Box> boxes ; 
    int getHeight(){
        int sum=0;
        boxes.stream().forEach(box -> sum+=box.height;);
    }
    
    BoxStack(Box box, BoxStack stack){
        
        base = box;
        boxes = ImmutableSet.newBuilder().addAll(stack.getBoxes()).add(box).build();
    }
}
                     
                     
int getMaxHeight(Collection<Box> boxes){
    
    Collections.sort(boxes);
    int N = boxes.size();
    
    BoxStack[] stacks = new BoxStack[N]; // Use as a 1-based index map
    stacks[0] = new BoxStack(boxes.get(0));

    // Initialize W1

    for (int W = 1; W <N){ // box under
        for (int = 0 ; U < W; U++){
            if (canFit(stacks[U], boxes.get(W))){
                stacks[W] = new BoxStack(boxes.get(W),  stacks[U]);
            }
        }
    }
                     
                     
    return new PriorityQueue<BoxStack>({ new Comparator<BoxStack> ({
        (stack1, stack2) -> INteger.compare(s1.getHeight(), s2.getHeight());
    }).poll();
}

boolean canFit(BoxStack){
}
                                       
// boolean expression consisting of the symbols 0 (false), 1 (true), &
// (AND), I (OR), and /\ (XOR), and a desired boolean result value result, implement a function to
// count the number of ways of parenthesizing the expression such that it evaluates to result

                                       
// countEval("l/\01011", false) -> 2
// countEval("0&0&0&1All0", true)-> 10
    
String be;
Set<String> falses = new HashSet<>();                                       
Set<String> trues = new HashSet<>(); 
Map<String, Boolean> beToValue = new HashMap<>();                                       
Map<String, Integer> falseCnt = new HashMap<>();
Map<String, Integer> trueCnt = new HashMap<>();
                                       
                                       Map
// init all indiviausl 
for ( int i = 1; i<be.length() ; i+=2){
    beToValue.put("" + be.charAt(i) , i == 1 );   
}
for (int S = 0..N-1, S+=2)
    for (int E = S+2..N-1, E+=2)
        for (int M = S+1..N-2; M+=2){
            //starts at be[S] to be[M-1] 
            cond1 = be.substring(S,M-1);
            cond2 = be.substring(M+1,E);
            oper = be.charAt(M);
            String expressn = be.substring(S,E-1);
            int newfalseCnt = getFalseCnt(cond1, oper, cond2);
            Integer currFalseCnts = falseCnt.get(expressn);
            if(currFalseCnts == null ){
                currFalseCnts = 0;
            }
            // Add to main map for new expression.
            falseCnt.put(expressn, currFalseCnts + newfalseCnt);

            int newtrueCnt = getTrueCnt(cond1, oper, cond2);
            Integer currtrueCnts = trueCnt.get(expressn);
            if(currtrueCnts == null ){
                currtrueCnts = 0;
            }
            trueCnt.put(expressn, currtrueCnts + newtrueCnt);
          
            
            
Expression[][] expressions = new Expression[N+1]N+1];
                                       
                                       
for ( int S=0;S<N;S++){ //start index
    for (int E=S; E<N; E++) {//end index
        for (int M=S; M<=E; M++){ // break - will be after M
            
                                       
                                       
List<Character> positions;
populate with ( ' ' and )
                                       
class Combo{
    List<Character> occupied = new ArrarList<>();
    boolean infeasible;
    boolean matches;
    boolean complete;
    add(Character char){...}
    //const
    Combo(List<Character> occupied,Character char){...}
    Combo(Character char){...}
}
                                       
Queue<Combo> inflight;                                       
queue.offer                                       
                                       
while(){
    combo = queue.poll();
    combo.add(' ');
                                       
                                       
                                       

                                       
                                       
