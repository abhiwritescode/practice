// return a matrix of the same shape storing in the cell of each start location the coordinates of the corresponding end location

/*
scan and update as minimum if lower than all neighbors

take cell if not lowest , put on stack
if lowest , 
  update all neighbors
  if neigh has entry , override if this is lower 

memoization -> saving in grid or matric
*/
class Cell{
  int row;
  int col;
  int ht;
}

Cell[][] markWithLowest(int[][] M){

  Cell[][] lowest = new Cell[M.length][M.length];
  
  Stack<Cell> stk = new Stack<>();
  stk.push(new Cell(0,0,M[0][0]));
  
  while(!stk.empty()){
    Cell curr = stk.peek();
    if ( isLowest(curr))
        lowest[curr.row][curr.col] = curr;
          
    if (lowest[curr.row][curr.col] != null){
      // has a route to lowest
      markLowestOnNeighbors(curr, M, lowest);
      stk.pop();// remove current from stack
    } else {
      // put all neighbors on stack
      getAllNeighbors(cell, M).stream()
        .forEach(c -> stk.push(c);
      
    }
  }
           
  
}

// trivial helper method to check if all neighbors are hoigher than me
boolean isLowest(Cell cell, int [][] M){
  
}

// 
void markLowestOnNeighbors(Cell cell, int[][]M, Cell[][] lowest){
  //for each neighbor check if lowest[][] is higher than cell's lowest, then mark with cell's lowestr.
}
List<Cell> getAllNeighbors(Cell cell, int[][]M){
  List<Cell> result = new LinkedList<>();
  
  for (int i = -1; i<=1;i++){
    for (int j = -1; j<=1;j++){
      if(Math.abs(i) + abs(j) != 1)
        continue;
      int row = cell.row+i;
      int col = cell.col+j;
      
      if(!(row >=0 && row < M.length
         && col >=0 && col < M[0].length))
        continue;
      
      result.add(new Cell(row, col, M[row][col]));
    }
  }
  return result;
}

/* given a matrix of size nxm
each cell containing a positive integer number
we can interpret this matrix as a map of an island where the numbers are the average altitude of each location.
if we drop water on a location it will flow to the neighbouring cell with lowest value (N/S/W/E not diagonally)
if a cell has no neighbour with lower value the water stays in the location/cell.
if a cell has multiple lower neighbours with same number, then any choosing any neighbour is correct.


*/

class Cell{
  int row;
  int col;
  int ht;
}

Cell flowTo(int [][] M, int row, int col){

  Cell cell = new Cell(row,col, M[row][col]);
  while(true){ //later
    Cell lowest = getLowestNeighbor(cell);
    if ( lowest == null){
      return cell;
    }
    cell = lowest;
    
  }
  return null;
}

Cell getLowestNeighbor(Cell cell, int [][] M){
  Cell lowest = null;
  for ( inr r = -1; r<=1; r++){
    for ( inr c = -1; c<=1; c++){
      if ( Math.abs(r) + Math.abs(c) != 1)
        continue;
      
      int row = cell.row+r;
      int col = cell.col+c;
      if ( !(row >=0 && row < M.length 
            && col >=0 && col < M.length )){
        continue;
      }
      if( M[row][col]  >= cell.ht){
        continue;
      }
      if ( lowest == null){
        lowest = new Cell(row, col, M[row][col]);
      } else if (M[row][col] < lowest.ht) {
        lowest = new Cell(row, col, M[row][col]);
      }
    }
  }
  return lowest;
        
      
          
}










//  robot starts moving from one end of the room at (0,0). Find if the robot can reach the other end at (n-1, n-1) by demolishing at most 1 wal
// function which will takes N and the 2D array as an argument, and return the boolean value true if the robot can go from (0,0) to (n-1,n-1)

/*

DFS 
Node { walls , iswall}

Stk.push(Node(root, 0)

whiel (stk.empty not || node == n-1,n-1){
  nodes = getNeighbors(node)
  if node.hasdemolished
    only consider iswall = false
    
  for each node add walls demo from noe

*/

class Node{
  int row; // 0based
  int col;
  int demolished; /* demd*/
}

boolean hasRoute(int[][] N){

  Node root = new Node(0,0, N[0][0] == 1, N[0][0]);
  Stack<Node> stk = new Stack<>();
  stk.push(root);
  Node node = root;
  
  
  while ( !stk.empty() ){
    node = stk.pop();
    if ( (node.row == N.length-1 && node.col == N.length-1))
      return true;
    
    List<Node> neighs = getNeighbors(N , node, node.demolished); 
    
    neighs.stream()
      .forEach(n -> stk.push());
  }
  return false;
}

         

// trivial/helper method to get neighbors
List<Node> getNeighbors(int[][] N , Node node, int demolished){
  // if demolished > 0 , only get non-walls
  // new Node..
  List<Node> result = new LinkedLIst<>();
  for ( int r=-1; r>=1; r++){
    for ( int c=-1; c>=1; c++){
      if ( Math.abs(r)  + abs(c) != !)
        cotinue;
      
      int row = node.row + r;
      int col = node.col+ c ;
      if (row >=0 && row+ r <= N.length -1
          && col >=0 && col <= N.length -1){
        int newdemolished = demolished + N[row][col];
        if ( newdemolished < 2){
          result.add(new Node(row , col, newdemolished)); 
        }
      }
    }
  }
}
         
        
         
         
         

         
         
         
