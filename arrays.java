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
                       
                       
            
            

                
                
             
    




    
    
