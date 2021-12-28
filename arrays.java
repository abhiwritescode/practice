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
           
           
           
        
            
        
            


            

        

