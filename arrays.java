// Compute for each input timestamp, the maximum traffic over the window length time interval which ends at that timestamp
/*

[  24 3 8 5 8 3 1 6 0 5 ]
k=3
i= 0 1 2 
for i =2 ..n-1
  maxwin(i-2, i)
  
heap? - just take the peek and keep replacing till 
stack - needs iteration

*/

class Entry{
  int val;
  int index;
}
List<INteger> getMaxWin(List<integer> traffic, int W){
  if (W> traffic.size()){
    return new ArrayList<>();
  }
  
  int[] T = traffic.toArray(new int[]);
  PriorityQueue<Entry> heap = createHeap(T);
  List<Integer> maxes = new LinkedList<>();
      
  for (int i = W-1; i<T.length; i++){ // O(n)
    heap.offer(new Entry(T[i], i));   // log w
    // remove if any old ones at top
    while(heap.peek().index < i-W){   // only once for each element, not repeated
      heap.get();  
    }
    maxes.add(heap.peek().value);
    
  }
  return maxes;
}

PriorityQueue<Integer> createHeap(int[] T){
  return  new PriorityQueue<>(){
    new Comparator<Entry>(){
      int compare(Entry a, Entry b){
        return INteger.compare(b.val, a.val);
      }
    }
  };
  for ( int i=0 ; i< W-1; i++)
    heap.offer(new Entry(T[i], i));
  return heap;
  
}


// COMPUTE THE LONGEST SUBSTRING WITH MATCHING PARENS
/*
 s '"((())()(()(", then "(())()" i
 
 
 class {char ; index}
class range{st, end}
(()

2-3
()
new () 1,4
4 touhces 3
1-4

()5,6 5touhces 4
combine (1-4, 5-6) -> 1-6

8-9
7-10

Map 
1-> 1-6
6-> 1-6
8->8-9
9->8-9

*/
Enum BracketType{
  OPEN('(');
  CLOSE(')');
  BracketType get(char C){
    if ( c == '(')
      return OPEN;
    else if ( c == ')')
      return CLOSE;
    else
      throw new IllegalStateException();
}
class Entry{
  BracketType type;
  int index;
}
class Range{
  int st;
  int end;
  int width(){
    return end-st+1;
  }
}

String longestMatching(String str){
    
  char[] S = str.toCharArray();
  Stack<Entry> stk = new Stack<>();
  Map<Integer, Range> indexToRage /* i2r*/ = new HashMap<>();
  
  int i = 0;
  
  while (i< S.length){
    BracketType type = BracketType.get(S[i]);
    
    if ( typ.equals(CLOSE) 
        && stk.peek().type.equals(OPEN)){
      // matching close brack
      Entry entry = stk.pop();
      Range range = new Range(entry.index, i);
      merge(i2r, range);
    } else {
      stk.push(new Entry(type, i));
    }
  }
  Range maxR =  getLongest(i2r);
  return str.substring(maxR.st, maxR.end+1);
}
 
// Find entries with neoghbors of range and merge
void merge(Map<Integer, Range> i2r, Range rng){
  if(i2r.containsKey(st-1){
    //append new ramge to existing
    Range prev = i2r.get(st-1);
    if (prev.end == 
    
  } else if (i2r.containsKey(st+1){
    // try append surrounding
  }
}

  
Range getLongest(Map<Integer, Range> i2r){ // O(n)
  
  Range maxRange = null;
  i2r.entries().stream()
    .forEach(rng -> {
      if (maxRange == null || rng.width() > maxRange.width())
        maxRange = rng;
    });
  return maxRange;
}
 
  
  
  

  
  
//Write a program which takes asinput a 2D array A of Is and Os, where the Os encode
//the positions of rooks on an n X m chessboard, asshow in Figure 25.1(b) and updates
//the array to contain Os at all locations which can be attacked by rooks,

/*
use A[0][0] to A[0][n-1] to store if any cols are 
use A[0][0] to A[n-1][0] to store rows
*/
int[][] rook(int[][] A){
 
 for (int r=1; r<A.length; r++){
  for (int c=1; c<A[0].length; c++){
   if ( A[r][c] == 0){
    A[r][0] = 0;
    A[0][c] = 0;
   }
  }
 }
 
  for (int c=0;c<A[0].length;c++){
    if (A[0][c] == 0){
      // set all A[1][c] to A[A.length-1][c] to 0
    }
  }
   for (int r=0;r<A.length;r++){
    if (A[r][0] == 0){
      // set all A[r][1] to A[r][A[0].length-1] to 0
    }
  }
 
 
}


//You are given a string s. You can convert s to a palindrome by adding characters in front of it.

// Return the shortest palindrome you can find by performing this transformation.

/*

Input: s = "aacecaaa"
Output: "aaacecaaa"

"abcd"

brute force : add S[n-1] , check add S[n-1] S[n-2] , check
n^2

HashMap 

a-> 0 1 5 6 7 
c-> 2 4
e -> 3

for i = s.length/2 to 0 
  for j= 1..i
    s[i-j] == s[i+j]
    if j==i
      there is symmetru around i

*/



 
//Given an integer array nums, return the maximum difference between two successive elements in its sorted form. 
//If the array contains less than two elements, return 0.
/*
 nums = [3,6,9,1, 5, 2]
Output: 3

rute force - sort and then scan for diff A[i] - A[i-1]

Array store diffs
3 3 -8 4 -3

partition?

Stack - 
1 2
3 5
min=1 max =9 


*/




//find the length of the longest subarray of consecutive integers in an array
/*

ubt st = 0
i=1
longest = 0
for ( int i = 1 i < A.len 
    if (A[i] != A[i-1] +1)
        st = i
        longest max (longest, i-1 - st)
  
  
  
*/


// Maximum profit from one trade
/*

find max(A[i] - A[j]) i > j

3 2 6 4 8 5 

5 8 
add to stack ifrom the end 
for i = n-1 ..1
    if ( A[i] > 
*/

int maxProfit(int [] A){
    Stack< Integer> stk = new Stack<>();
    for ( int i = A.length -1 ; i> 0; i--){
        if (stk.empty() || A[i] > A[stk.peek()])
            stk.push(i);
    }
    
    int max =0;
    for ( int i=0; i< A.length-1;i++){
        if (i>=stk.peek())
            stk.pop();
        max = Math.max(max, A[stk.peek()] - A[i]);
    }
    return max;
}

// max profit with 2 trades
/*
trd1
trd2
prevtrd

if Ai > Ai-1
 capture pft trd1 (if trd1=0) or trd2
 max pft = trd1+trd2
 trd1 = max(trd1, trd2)
 
*/
/*

i   0   1   2   3   4   5   6   7   
A   2    6  3   8   11  4   9   12
stk
i=0 [2]
i=1 [2] 
i=2 pft = Ai-peek() = 4 [2,  3] prevpft = [A1-A0]
i=3 pft = Ai-peek = 5   [2, pft=A1-A0, 3] 
i=4 
i=5 drop pft = A[i-1] - peek = A4-A2 = 8  [0 2 5]  prevpft = [A1-A0] A4-A2
i=6 

sort the profits
*/
class Trade{
}

int max2trades(int[]A){
    int trd1=0;
    int maxpft =0;
    int /*prevminI*/ pmI = 0;
    PriorityQueue<Trade> trds = new PriorityQueue<>();
    LInkedList<Trade> 
    for ( int i = i; i < A.length; i++){
        if ( A[i] < A[i-1]) {
            int pft = A[i-1] - A[pmI];
            trds.add(new Trade(pft, i-1, pmI));
            pmI = i;
        }
    }
    return optimize(trds);
    

}

int optimize(LinkedList<Trade> trsd){ // O(n)
    List<Trades> tradesArray = new ArrayList<>(trds);
    Trades[] tAry = tradesArray.toList(new Trades[0]);
    int max =0;
    for (int i=0; i<A.length-1; i++ ){
        int pft1 = tAry[0]
    }
}


int max2trades(int[]A){
    int trd1=0;
    int maxpft =0;
    int /*prevminI*/ pmI = 0;
    
    for (int i =1 ; i< A.length; i++){ // i=0, trd1=0, pmi=0, Ai = 2
        
        
        
        if (A[i] > A[pmI]){
            int pft = A[i] - A[pmI];
            if (trd1 > 0){
                maxpft = Math.max(maxpft, trd1 + pft);
            } else {
                trd1 = pft;
            }
            trd1 = Math.max(trd1, pft);
        } else if (A[i] < A[pmI]){
            pmI = i;
        }
    }
    
}


//SORT AN INCREASING-DECREASING ARRAY
// not given k
/*
find the 
1 3 5 
5 8 10
10 13 14

merge (1 ,3 , 4, 5)
merger (5 8 9 10)


*/

class Section{
    int st;
    int end;
}

int [] sort(int[] A){

    // sections of increasing are now avail st to mid and mid + 1 to end -1 
    List<Section> sections = reverseSubLists( A);
    int s = 0;
    while (sections.size() > 1){
//         int s = 0;
        List<Section> nextSections = new LinkedList<>();
        for ( int s = 0; s< sections.size() ; s+=2){
            Section sec1 = sections.get(s);
            if ( s+1 < sections.size() ){
                Section sec2 = sections.get(s+1);
                merge(A, sec1.st, sec1.end,  sec2.st, sec2.end);
                nextSections.add(new Section(sec1.st, sec2.end));
            } else {
                nextSections.add(new Section(sec1.st, sec1.end));
            }
        }
        sections = newSections;
    }
}


// merge sections into larger ones
void merge(int[] A, int s1, int e1, int s2, int e2){
    int i1 = s1;
    int i2 = s2;
    int [] temp = new int[e2-s1+1];
    int t = 0;
    while ( i1 <=e1 && i2 <= e2 ){
        if (A[i1] < A[i2] ){
            temp[t] = A[i1];
            i1++;
        } else if ( A[i1] > A[i2] ){
            temp[t] = A[i2];
            i2++;
        } else {
            temp[t] = A[i2];
            temp[++t] = A[i2];
            i1++;
            i2++;
        }
        t++;
    }
    for ( int j=0; j<temp.legth; j++){
        A[st+j] = temp[j];
    }
}


// trivial in place reverse
int [] A reverse (int[] A, int st, int end){
    
}


List<Section> reverseSubLists(int [] A){ // O(n)
    int st = 0;
    int i = 0;
    List<Sedction> sections = new LinkedList<>();
    while (i < A.length){
        int st = i;
        while (A[i] > A[i-1] && i < A.lengt )
            i++;
        if ( i< A.length -1){
            int mid = i-1;
        }
        while (A[i] < A[i-1] && i < A.lengt )
            i++;
        if ( i< A.length -1){
            int end = i-1;
        }
        reverse(A, mid+1, end);
        sections.add(new Section(st, end);
    }
    return ;
}

// Given url array: [Foo/bar foo/biz/bar]	Convert to map :  { Foo:bar, biz:bar } I.e a map of maps

/*
foo -> {bar: {},  biz : {bar:{}}}, 

string[] S
for i = 0 .. s, new HashMap<String, ?>());
    if !contains
        map.put(S[i], new List<Map<String, ?>>());
        

*/
Map<String, ?> getMap(List<String> urls){
    Map<String, ?> topMap = new HashMap<>();
    
    for (String url : urls){
        Map<String,?> map = topMap;
        for (String sec : parse(url)){
            Map<?> list = map.get(sec);
            if (sec == null ){
                list = new HashMap<String, ?>();
                map.put(sec, list);
            }
        }
    }
    return topMap;
}

String[] parse(String S){
    return S.split("/");
}


//  Concatenate string to itself with decreasing sizes e.g.  cake -> cakecakcac
/*

// ns
C = chararray
for ( i = n-1 .. 0) // n
  for ( in c
  sb.append(S.substring(0,i)); // s



*/


//GIven n x  n matrix of letters find all words formed by moving in any direction from a letter to the next in any of the 8 directions. Do not reuse a letter

/*


DFS 
Set <point> used


*/
class Node{
    String wordSoFar;
    Point pt;
}
class Point{
    int x;
    int y;
}


List<String> getWords(int[][] A, Point start){
        
    Set<Point> used = new HashSet<>();
    Queue<Node> que = new Deque<>();
    que.offer(new Node("", start));
    List<String> result = new ArrayList<>();
    
    while(!que.isEmpty()){
        Node n = que.get();
        used.add(n.pt);
        String newWordSofar = n.wordSoFar + A[pt.x][pt.y];
        if (isEdge(n.pt))
            result.add(newWordSofar);
        
        getAvailNeighbors(n.pt, used, A).stream()
            .map(pt -> new Node(newWordSofar, pt))
            .forEach(que.add(node));
    }
}

List<Point> getAvailNeighbors(Point p, Set<Point> used, int[][] A){
    List<String> result = new ArrayList<>();

    for ( int x=-1 ; x<=1; x++){
        for (int y=-1 ; y<=1; y++){
            if (p.x + x >= && p.x + x < A.length
                && p.y + y >= && p.y + y < A.length
               && !(x==0 && y==0)){
                
                result.add(new Point(p.x + x, p.y + y));
            }
        }
    }
    return result;
}

boolean isEdge(Point p, int [][] A){
    return p.x ==0 || p.y ==0 || p.x == A.length -1 ||p.y == A.length -1;
}


// GIven rectangles find the points of interest inside the rectangle
/*

rect : { x1, y1, x2, y2}
points : {x, y}

Sort rects by p2.x R log R
Sort all points by x P log P

while ( !r empty && !P empty){ // P+R
    if (P.x in R)
        p++
    else 
        r++
}

*/

class Point{
    int x;
    int y;
}
class Rectangle{
    Point p1;
    Point p2;
}

//
List<Point> getPoints(List<Rectangle> rects, List<Point> pts){ //O(PR)
    
    Collections.sort(pts, new Comparator<Point> (){ // p log p
        int compare(Point p1, Point p2){
            return Integer.compare(p1.x, p2.x);
        }
    });
    
    Collections.sort(pts, new Comparator<Rectangle> (){
        int compare(Rectangle r1, Rectangle r2){
            return Integer.compare(r1.p2.x, r2.p2.x);
        }
    });
    
    int p=0;
    int r=0;
    List<point> result = new ArrayList<>();
    while(p < pts.size() && r< rects.size()){ // p+ r
        if (isInside(pts.get(p), rects.get(r))){
            p++;
            result.add(pts.get(p));
        }
        else
            r++;
    }
    return result;
}

boolean isINside(Rectangle rect, Point pt){
    return pt.x >= rect.pt1.x &&  pt.x >= rect.pt2.x 
        && pt.y >= rect.pt1.y &&  pt.y >= rect.pt2.y;
}

// Given array of numbers find the index of the next maximum

/*

3 6 2 0 8 4 5 7 
6 6 6 6 6 6 

n2 

Stack 


7 4 

for i= 0 n-2
  A[i] = 
  if stk.peek > i
  else pop stk
*/

int[] nextMax(int[] A){
    Stack<Integer> stk = new Stack<>();
    
    for ( int i = A.length-1 ;i>=0; i--){
        if (stk.isEmpty() || A[stk.peek()] < A[i]){
            A.push(i);
        }
    }
    // stk now contains indexes in increasing A[i]
    int [] B = new int[A.length-1];
    for (int i = 0; i < A.length-2 ; i++){
        if (i >= stk.peek()){
            stk.pop();
        }
        B[i] = stk.peek();
    }
    return B;
}
        
    
  
  
}

// Quicksort
/*

mid -< any mid element
lastbigi

while (i< A.len)
if Ai > A lbi
  swap i lbi
  

while ( Ai < A lbi)
  i++
lbi = i

*/

List<Integer> sort(List<Integer> listA){

  int[] A = listA.toArray(new int[A.length]);
  
  
}

int[] A part(int[] A, int st, int end){
  int mid = (st+end)/2;
  int lasti = st;
  int i=st;
  swap(A, mid, lasti);
  
  while(i< A.lenght-1){
      
      if (A[i]> A[lasti])
          swap(A, lasti, i);
      
      while(A[i]<A[mid] && A.length -1  > i)
          i++;
      lasti=i;

      
  }
  swap(A, mid, lasti);
  
  
  part(A, st, lasti-1);
  part(A, lasti, end);
  
}


int[] part(int[]A){
 
    int pivot = A[(A.length-1)/2];
    lastmaxi = 0;
    
    for ( int i = 0 ; i < A.length; i++){
        if (A[i]< pivot){
            swap(A, i, lastmaxi);
            lastmaxi++;
        }
    }
    //lastmaxi is now the start of larger values > = pivot
    int lastmini = A.length;
    for ( int i = A.length-1; i>=lastmaxi; i--){
        if (A[i]> pivot){
            swap(A, lastmin, i);
            lastmin--;
        }
    }
}

/*
  
  
i=0
j=A.len-1

while(i<j){
  while (i<j && i< A[mid])
    i++
  while (i<j && j> A[mid])
    j--
  
  if ( A[i] > A[j])
    swap(i,j)
  
  

*/


//Compute the intersection of two sorted arrays
/*
input is (2,3,3,5,5,6,7,7,8,12} and (5,5,6,8,8,9,10,10), your output
should be (5,6,8)
step - check if interseting
if A[0] <= b[0]
  // start serach with b[0] in A
  search (A, B)
else
    // start serach with A[0] in B
  search (B, A)

search(A, B){
result
lastA=0;
bi=0
while(B[bi] <=A[n-1]){
  ai = find(B[i], A, start=lastA) binary search
  if ai >= 0 : lastA = ai; result.add(B[i])
}
}

// binary
find(val , A, startA){
mid =

}

*/

List<Integer> findInterset(List<Integer> listA, List<Integer> listB){
    
    int[] A = listA.toArray(new int[listA.size()]);
    int[] B = listB.toArray(new int[listB.size()]);
    Set<Integer> result = new HashSet<>();
    
    int i =0 ;
    int j = 0;
    while(i< A.length && j < B.length){
        while (A[i] < B[j] && i< A.length) // move A till A> B
            i++;
        while (A[i] > B[j] && j < B.length) // move B till B>A
            j++;
        if( A[i] == B[j]){
            result.add(A[i]);
            i++;
            j++;
        }
    }
    return result;
}

List<Integer> findInterset(List<Integer> A, List<Integer> B){
    if (!areIntersetcing(A, B))
        return false;
    
    if (A.get(0) >= B.get(0))
        return find(B, A);
    else 
        return find(A, B);
    
}

List<Integer> findIn(List<Integer> A, List<Integer> B){
    int lastA = 0;
    int bi = 0;
    List<Integer> result = new ArrayList<>();
    TreeSet<Integer> setA = new TreeSet<>();
    setA.addAll(A); // n log n
    while(bi < B.size() -1 &&  B.get(bi) <= A.get(A.size() -1)){ // n
        int ai = searchOrFloor(B.get(bi), A, lastA); // log n
        if ( A.get(ai) == B.get(bi))
            result.add(B.get(bi));
        lastA = ai;
        bi++;
    }
}

int searchOrFloor(int val, List<INteger> A, int start){
    // exit 
    int st = start;
    int end = A.size() -1
    int mid = (st+end)/2;
    
    while((mid-st) > 1){
        if (val == A.get(mid))
            return mid;
        else if ( val >= A.get(end) )
            return end;
        else if ( val > A.get(mid) )
            st=mid;
        else if ( val == A.get(st) )
            return st;
        else if ( val < A.get(st) )
            return Math.max(0, st-1);
        else if ( val < A.get(mid))
            end=mid;
    }
    return st;
    
}

boolean areIntersetcing(List<Integer> A, List<Integer> B){
 
    return  !(A.get(A.length-1) < B.get(0)
         || B.get(A.length-1) < A.get(0));
}

//REMOVE DUPLICATES FROM A SORTED linked LIST

class Node{
    int value;
    Node next;
}
Node removeDupes(Node head){
 
    Node curr = head;
    while (curr.next != null){
        
        if(curr.value == curr.next.value){
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }
    return head;
    
}


//Given array of heights find the max water volume that will fit between

/* 
Array A[i] of heights
move from 0 to higher and from N-1 to lower to taller only if the next one is taller

*/

int getMaxHeight(int[] hts){
    

    int left = 0;
    int rt = hts.length - 1;
    int i = 0;
    int j = hts.lenght -1;
    
    while (j-i > 1){
        if (hts[i+1] > hts[rt]){
            rt++;
        }
        if ( j-i > 1){
            if (hts[j-1] > hts[left]){
                left --;
            }
        }
    }
    return (left -rt) * Min(hts[j], hts[i]);
    
}


//Max area under building Given array A of building heights
/*
need lowest ht in sequence 
keep track of ht as we go along
*/

int getmaxArea(int[] hts){
    
    int max=hts[0];
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);
    // keep track of the buildigs that create the max area.
    int currRt = 0;
    int currLeft = 0;
    
    // Start checking each item for height.
    for ( int i = 1; i<hts.length; i++){
        int prevLow = hts[stack.peek()];
        
        
        if (hts[i] < prevLow){
            //new item is shorter so add to stack, is limiting for height
            int newLow = hts[i];
            int newArea = (newLow - prevlow) * hts[newLow];
            if (newArea > max){
                // new range of buildings.
                max = newArea;
                currRt = i;
                currLeft = stack.peek();
            }
        }
    }
}



//partition sort - quick sort

/**
partition array around a central value - all smaller values on one side and larger values on the other side.
repeat for each sode around this central value till each part is of one l;ength.
*/

int[] sort(int[] A){
    
    int mid=sort(A,0,A.length-1);
    
    while(...){
        
    }
}

void sort(int[] A, int st, int end){
    int mid=part(A,st,end);
    //sort the 2 halves.
    sort(A,st,mid);
    sort(A,mid+1, end);
}

int part(int[] A, int st, int end){
    
    if ( st==end){
        return st;
    }
    // select a mid value index
    
    int mid = (st+end)/2;
    
    // any values on the left small than A[mid] move them to the right
    
    while (st<=end){
        while(A[st]<A[mid])
            st++;
        while(A[end]>A[mid])
            end--;
        
        if(st<end){
            swap(st,end);
            st++;
            end--;
        }
        return st;
    }
}

// You are given two sorted arrays, A and B, where A has a large enough buffer at the
// end to hold B. Write a method to merge B into A in sorted order. 

int[] sortMerge(int[] A, int[] B, int lenA){
    
    // check last elements and move higher to end of A
    // track indexes lastA, lastB, nextA
    
    int nextA = lenA-1;
    int nextB = B.length -1 ;
    int nextTgt = A.length -1;
    
    while (nextTgt > lenA -1){
        
        
        if(A[nextA]> B[nextB]){
            copy(A,nextA, A,targetA);
            nextA--;
        } else {
            copy(B,nextB, A,targetA);
            nextB--;
        }
        targetA--;
    }
    return A;
}

//Write a method to sort an array of strings so that all the anagrams are next to each other.
String[] groupAna(String[] input){

    int i= 0;
    int j= input.length -1 ;
    
    while (i<j){
        
        while(isAna(input[i])){
            i++;
        }
        while(!isAna(input[j])){
            j--;
        }
        if(i<j){
            swap(input, i , j);
        }
    }
    return input;
    
    
}

boolean isAnaGram(String S){
    return false;
}


// Given a sorted array of n integers that has been rotated an unknown
// number of times, write code to find an element in the array. You may assume that the array was
// originally sorted in increasing order

// assume distinct.

int find(int[] A, int value){
    
    int st = 0;
    int end = A.length-1;
    int mid = (st+end)/2;
    
    while (st<end){
        if(st==end){
            return A[st] == value ? st : -1 /* value not found*/;
        }
        if(A[mid] == value)
            return mid;
        
        if(A[mid+1] < A[end]){
            //right side is "smooth"
            if(A[mid+1]<= value && A[end] >= A[value]){
                //value is on right
            } else {
                //value is on left 
            }
        } else {
            //left side is smooth
            if(A[0]<= value && A[mid-1] >= A[value]){
                //value is on right
            } else {
                //value is on left 
            }
        }
    }
}


// Given an array of integers, sort the array into an alternating sequence of peaks and valleys. 

/**
set flag for i 
if ( i+1 not following flag, flip
if i==i+1 , move flag to i+1

*/

int[] paekify(int[]A){
    

    int i = 0 ;
    while (A[i]==A[i+1]){
        i++;
    }
    if (i >= A.length-1){
        return A; //special case - all equal
    }
    boolean nextHigher = A[i] > A[i+1];
    
    while (i<A.length){
        while (A[i]==A[i+1]){
            i++;
        }
        if (i >= A.length-1){
            return A; //special case - all equal to end 
        }

        i++;
        nextHigher = !nextHIgher;
        if ((nextHigher && A[i+1] < A[i])
           || (!nextHigher && A[i+1] > A[i])) {
            swap(A, i, i+1);
        } 
    }
    return A;
}
           
           
           
        
            
        
            


            

        
// o reorder its entriesso that the even entries appear first.

// iterate over array till first odd 
/**

int firstodd = -1 if none else index
int curri
if curri is even and firstodd < curri , swap

                2    6   5   8   4   2   9   9   7   3   
               
curri.     0        1    2   3   4   5   6   7   8   9    10   
firsto     0        1       3    4   5               9                
array 
*/
int[] evenfirst(int[] A){
    
    int curri=0;
    int firsto = -1;// none
    while(isEven(A[curri])){
         curri++;
    }
    // need to init firsto
    if (curri < A.length)
        firsto = curri;
    
    while(curri <A.length){
        
        if(isEven(A[curri]) && firsto >=0 && firsto< curri){
            // there is an odd number at a lower index, swap
            swap(A, curri, firsto);
            // move firsto to next odd which is curri since we justy swapped
            while(isEven(A[firsto]))
                firsto ++;
            //firsto = curri;
        }
        curri++;
//         if(curri>=A.lenght){
//             return;
//         }
    }
    
}


//t all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot, followed by elements greater than the pivot.

/**

lastp - last index >= pivot
curri -> current index
curri = lastp - jump to lastp since all lower are small
if curri < pivot, swap and lastp = curri
curri continue scanning for smaller values

pv=6
                    2    5   4   3   6   6   9   9   7   8 
  lastp                 1    2   3                                          
  curri                      2   3   4   5   6   7   8   9                                     
*/



int[] dutch(int[] A, int p){

    int lastp = 0; // last value >= pivot
    while (A[lastp] < pv)
        lastp++;
    //lastp now points to a value >=pv 
    
    int curri = lastp+1; // start with the next index.
    
    while (curri < A.length){
        if (A[curri] < pv && lastp < curri){
            //swap with 
            swap(A, curri, lastp);
            //lastp now has the snall value and curri has the new larger
            // move lastp to the next larger value which is at curri
            while(A[lastp]<pv && lastp < A.length)
                lastp++;
        }
        curri++;
    }
    // All small values are now on the left and the right has larger or equal values.
    // next scan from right and see move large values to back
    // the first non-small value is at lastp (eqaul or larger) 
    // neeed to rearange from lastp to end of A, leavbg 0 to lastp-1 untouched.
    
    int lastl=0;//large value 
    while (A[lastl] <=pv)
        lastl++;
    //lastk now points to value greater than pv
    curri = lastl;
    while (curri < A.length){
        if (A[curri] == pv && lastl < curri){
            swap(lastl, curri); // large value moved to curri and equal value moved to lastl
            lastl=curri;
        }
        curri++;
    }
        
    
    
}


//possible to advance tyo end of array

//for a given position i, check if A[i]>0, if possible to advance from i+1 to i+A[i]
// if i == A.len -1 then yes

/*

(need to reach 6)
   A         3    2    5    1    0    4    2 
   canR      3    4    7    4    4    9    8        
needI   6    0    1    2    3    4    5    6                
curri   6    0    1    2    3    4    5    6                

3  3  7  4. 4. 7. 7
3 5 10 11 11 15 17
*/

boolean canAdvance(int [] A){

    int[] canReach = new int[A.length];
    for ( int i = 0;i< A.length; i++){
        canR[i] = i + A[i];
    }
    // find first canR >= A.length-1;
    int needI=A.lrngth-1;
    int curri=A.length-1
    while (curri > 0){
        
        if (canR[curri] >= needI)
            needI = curri;
        
        curri--;
    }
    
    if (needI > 0)// not reachable
        return false;
    
    return true;
}


// DELETE DUPLICATES FROM A SORTED ARRAY
// 2  3 ,5,5,7,11,11,11,13 and pad zeroes at the end


/*
          0  1   2   3   4    5    6    7     8
          2  3   5   7   11   13   11   11   13
curri     0  1   2   3   4                         
nexti     1  2   4   5   8                                                   

1. nexti -> move to diff from A[curri]
2  if nexti > curri + 1 copy (A, nexti, curri+1) 
3 curri ++
4 if nexti >=A.length-1 curri is the last, fill ) after curri ELSE go to step 1 

*/

int[] deleteDupes(int[] A){
    
    int curri = 0;
    int nexti =0;
    while (nexti < A.length ){
        
        while(A[nexti] == A[curri] && nexti<A.length)
            nexti++;
        
        if(nexti>curri+1)
            copy(A,nexti, curri+1);
        
        curri++;
        
        if ( nexti >= A.length-1)
            break;
        
    }
    // fill 0s
    for (int i = curri + 1; i<A.lrngth; i++)
        A[i] = 0;
    
    return A;
}


//All prime numbers to n.
int[] primes(int N){
    
    Boolean[] isPrime = new Boolean[N];
    
    for (int i = 2 ; i <= sqrt(N) +1 ; i++){
        for (j=2;j<=sqrt(N)+1;j++){
            isPrime[i*j] = true;
        }
    }
    List<INteger> count = Arrays.stream(isPrime).filter(val -> val).collect(toList());
}


//get all permutatiosn

List<List<Integer>> getPerms(List<Integer> arr){
    
    if(arr.size() ==1){
        return List.of(new LinkedList<Integer>(arr));
    }
    List<List<Integer>> responsePerms = new ArrayList<>();
    List<List<Integer>> perms = getPerms(new LinkedList<Integer>(arr.subList(0, arr.size()-1)));
    int toInsert = arr.get(arr.size()-1);
    for ( LIst<INteger> aPerm : perms){
        for ( int i = 0 ; i<=aPerm.size(); i++){
            List<Integer> newPerm = new LinkedLIst<>(aPerm);
            newPerm.add(i, toInsert);// weave in at each location from 0 to n
            responsePerms.add(newPerm);
        }
    }
    return responsePerms;
}


// compute pascals triangle for N rows
/* List for row i (0 based) = length(i=1)
A[0] = Aprev[0]
A[i] = Aprev(i-1] + Aprev[i] for i=1..Aprev.lenght-2
A[A.size()-1] = Aprev[Aprev.size()-1]
*/
List<List<Integer>> getPascal(int N){
    List<List<Integer>> result = new ArrayList<Integer>(N);
    result.add(List.of(1));
    
    for (int i = 1; i< N -1;i++){
        List<Integer> Aprev = result.get(i-1);
        List<Integer> Anew = new ArrayList<>(i+1);
        Anew.add(1);
        for ( int j = 1; j< Aprev.length; j++){
            Anew.add(Aprev.get(i-1) + Aprev.get(i));
        }
        Anew.add(Aprev.get(Aprev.length-1));
        result.add(Anew);
    }
    return result;
}


// Compute the maximum water trapped by a pair of vertical lines

/*

int mins[][] -> min[i][j] = min(A[i], A[j])

for ( int i = 0..n-2)
    for (int j=i+1..n-1)
       Water = min(A[i], A[j]) * (j-i)
       
       
 2 4 3 6 9 5 11 4
 i=2 j=4 -> 
 i=
 
 
 i=0 j=n-1
 max = A(i,j)
 
if (A[i] < A[j] )
    move i++ till higher A[i]
else 
    move j-- till higher A[j]
 if (A(i,j) > max
    new max
*/

int getMaxWater(int[] A){
    int i=0;
    int j = A.lrngth -1;
    
    int max = calcArea(A, i, j);
    while (i<j){
        if(A[i] < A[j]){
        int iVal = A[i]
            while(A[i+1] < iVal && i+1 < j)
                i++;
        } else {
            int jVal = A[j]
            while(A[j-1] < jVal && i+1 < j)
                j--;
        }
        max = Math.max(max,  calcArea(A, i, j));
        
    }
    
}
            
// Compute the largest rectangle under the skyline
/*
n3
Stack 
add ony if less then peek (top of stakc)

maxA
for L=2..n
    for i=0..n-L
        j = i+L-1
        if L ==2
            min[i][j] = min(Ai, Aj)
            maxA - max(max
        else
            min[i][j] = min(min[i][j-1], Aj)
            
            
        

*/

int getmaxArea(int [] A){
    int[][] mins = new int[A.length][A.length];
    int maxArea = 0;
    
    for ( int L = 2; L<=A.length; L++){
        for (int i = 0; i<= A.length - L ; i++){
            int j = i+L-1;
            if (L==2){
                min[i][j] = Math.min(A[i], A[j]);
                maxArea = Math.max(maxArea, (j-i) * min[i][j]);
            } else {
                min[i][j] = Math.min(A[j] , min[i][j-1]); // lower of curr index and array ending at prev index
                maxArea = Math.max(maxArea, (j-i) * min[i][j]);
            }
        }
    }
    return maxArea;
}


// Improve with a stack
int getmaxArea(int [] A){
    Stack<Intgeger> stk = new Stack<>();
    
    for ( int i =0 ; i< A.length ; i++){
        if ( stk.isEmpty()){
            stk.push(i);
            continue;
        }
        
        if ( A[i] == A[stk.peek()]){
            stk.pop();
            stk.push(i); // if equal replace with current index
        }
        
        while ( !stk.isEmpty() && A[i] < A[stk.peek()]){
            int ht = A[stk.pop()];
            int wid = 
                       
                       
            
            

                
                
             
    




    
    
