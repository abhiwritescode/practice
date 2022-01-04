//https://leetcode.com/problems/zigzag-conversion/


/**

L: stirng length
grpsize = k + (int)(k/2)
full grp count = int(L /grpsize)
last grp = rem(L, grpsize)
pad size = pad grpsize - lastgrp 
char[] S = char[L+pad size]
midpoint = int((grpsize+1)/2);

Array.copy(S.toCharArray(), S);
for (int ch = L ; ch > L+padsize; ch++)
   S[ch] = ' ';
   
total_grps = int(L /grpsize) + 1;

for (row = 1..k)
  for ( int grp = 1..totalgrps)
    indextoprint = print S(k-1 + grp_size*(grp-1));// main chat
    if (k row odd )
      print indextoprint + midpoint
      


*/

String convertZigZag(String S, int k){
 
    int grpsize = k + (int)(k/2);
    int midpoint = int((grpSize+1)/2);
    int grpCount = int(s.Length / grpSize);
    if (Math.rem(S.length(), grpSize) > 0)
        grpCount++;
    
    StringBuilder output = new StringBuilder();
    for ( int row = 1, row <=k ; row ++){
            for (int grp = 1; grp <=grpCount ; grp++){
                
                int indexToPrint = k-1 + grpSize * (grp-1);
                if ( indexToPrint < S.length())
                    output.add(S.charAt(indexToPrint));
                if ( isEven(row) &&  indexToPrint + midpoint < S.length())
                    output.add(S.charAt(indexToPrint + midpoint));
                
                
            }
    }
}


//Median of Two Sorted Arrays

// Longest array eith distinct
/**

Map<Character, List<Integer>> charToIndexes = 

for (s= 0; s< A.len; s++) //for each starting index
  max len = cti.get(s); 
  getNextEntry = //entry greater than s
  maxlen[s] = getNextEntry - s - 1;
  lastEntry =  getNextEntry
  for ( i=s+1; i<nextEntry;i++){
    entry = getNextEntry(A[i], i); // MAXVAL is none
    lastEntry = min(entry,  lastEntry)
  }
  maxlen[s] = lastEntry



long[i] = min(long[i-1] , prev(i));

stindex[i] = max(stindex[i-1], prev(i) + 1)
*/
private Map<Character, List<Integer>> charToIndex = new HashMap<>();

String longest(String strS){
    
    char[] S = strS.toCharArray();
    populateCharToINdex(S);

    // strating index for longest subarray startin
    int [] stindex = new int[S.length];
    stindex[0] = 0;
    int maxlen = 1;
    int maxindex = 0;
    
    for ( int i = 1; i < S.length; i++){
        stindex[i] = max(stindex[i-1], getPrevIndexForChar(i) + 1);
        int newlen =  i - stindex[i] + 1;
        if ( newlen > maxlen ){
            maxlen = newlen;
            maxindex = i;
        }
            
    }
    
    return strS.substrin(stindex[maxindex], maxindex + 1);
}

int getPrevIndexForChar(int ch){
 
    List<Integer> indexes = charToIndex.get(S[ch]);
    int lastIndex - Integer.MIN;
    for ( Integer index : indexes){
        if (index >= ch)
            return lastIndex;
        else
            lastIndex = index;
    }
    return lastIndex;
}

void populateCharToINdex(char[] S){
        for ( int c = 0; c< S.length ; c++){
        List<Integer> indexes = charToIndex.getOrDefault(S[c], new LinkedList<>());
        indexes.add(c);
        c.put(c, indexes);
    }
}



// 4sum

/**

Hasmap - index to value from value to index
findsum(int[] A, int start, int T, int num)
DP - 4 sum with i = 3 sum of findsum(A, i+1, T-A[i], 3)
forces consecutieve indices

nums = [1,0,-1,0,-2,2], target = 0

Take a running sum ?
sums = [1 1 0 0 -2 0]

hashmap - sum of 1 stadalone
create hasmap with 2 sums o(n2)
iterate over the hasmap and look up k-V
*/

List<List<Integer>> get4sums(List<Integer> A, int target){
   //Map<Integer, INteger> oneSums= getOneSum(A);
   Map<Integer, List<Integer>> twoSums = getTwoSum(A); //O(n2)
   
   // iterate over each two Sum
   
   return twoSums.entrySet().stream()
      .map(entry -> {
         int twosum = entry.getKey();
         List<Integer> twoINdexes = entry.getValue();
         List<Integer> twoOthers = twoSums.get(atregt - twosum);
         if (twoOthers == null ){
            return ImmutableList.of();
         } else {
            return ImmutableList.newBuilder()
               .addAll (twoINdexes)
               .addAll(twoOthers));
         }
      })
      .filter(list -> !list.isEmpty())
      .collect(toImmutableList());
}

Map<Integer, INteger> getOneSum(List<Integer> A){

   Map<Integer, INteger> aMap = new HashMap<>();
   for ( inti = 0; i < A.size() ; i++){
      aMap.put(A.get(i), i);
   }
   return aMap;
}
Map<Integer, List<Integer>> getTwoSum(List<Integer> A){

   Map<Integer, List<Integer>> aMap = new HashMap<>();
   for ( inti = 0; i < A.size() ; i++){
      for ( int j = 0; j < A.size() ; j++){
      aMap.put(A.get(i) + A.get(j), ImmutableList.of(i,j));
   }
   return aMap;
}
}


//Merge k Sorted Lists


/*
Keep a minheap of k element, top of each list
when size is K, 
   remove one
   replace from same list where the removed element was from

*/

class Element{
   int value;
   int listI;
}

List<Integer> merge(List<LinkedList<Integer>> lists){
 

   PriorityQueue<Element> heap = getHeap(lists);
   LinkedList<Integer> result = new LinkedList<>();
   
   while (!heap.isEmpty()){
      Element top = heap.poll();
      result.offer(top.getValue());
      
      LinkedList<Integer> list = lists.get(top.getlistI())
      if (!list.isEmpty()){ 
         //replace from same list if available
         int nextValue = list.poll();
         heap.offer(new Element(nextValue, top.getlistI()));
      }
   }
   return result;
}

PriorityQueue<Element> getHeap(List<LinkedList<Integer>> lists){
   int lCnt = lists.size();
   PriorityQueue<Element> heap = new PriorityQueue<>(new Comparator<Element>(){
      int compare(Element e1, Element e2){
         return Integer.compare(e1.value, e2.value);
      }
   });
   
   for ( int i = 0 ; i< lists.size(); i++){
      heap.offer(new Element(list.poll(), i));
   }
   return heap;
}

   
   
   





