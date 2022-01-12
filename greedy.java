// activity selection greedy
/*
class activity {int st; int end;}

List activity A
Set result 
activity.sort by a.end

result.add(A[0])
last = 0;
i=0
while (i < A.length){
    while(i+1 < A.length && A[i+1].start < A[last].end)
        i++;
    if (i==A.lenght -1 ){
    // no more
    result

*/

class ACitivity{
    int start;
    int end;
}

List<Activity> select(List<Activity> acts){

    Collections.sort(acts, new Comparator<Acivity>(){
        int compare(Activity a1, Acitivy a2){
            return Integer.compare(a1.end, a2.end);
        }
    });
    List<Activity> selected = new LinkedList<>();
    
    int last = 0;
    int i = 0;
    selected.add(acts.get(0));
    while (i< acts.length() ){
        while (i + 1< acts.length() 
               && acts.get(i+1).start < acts.get(last).end)
            i++;
        
        if ( i >= A.length -1)
            // nothing remaining
            break;
        selected.add(A.get(i+1));
        i++;
    }
    return selected;
    
    
}



// activity selection DP
/*
class activity {int st; int end;}

selected [i,j] = selected set from i to j inclusive

= selected[i,k-1] + select k + selected[k+1,j]

store by start time and end time
sort by end time 
sort by start time

int for every integer from s0 to An-1.start
int for every integer from s0 to An-1.start
*/

//0-1 knapsack problem
/* solve with DP

max wt W
for each weight w 1..W
  i can be added or not qadded
  if ( w[i, w] <= w )
    max[i, w] =0
    for j=1..i-1
        if cumw[j,w - w[i]] + w[i] < w
            if ( v[i] + max[j,w - w[i]] > max[i,w])
                cumw[i,w] = w[i] + cumw[j,w - w[i]]
                max[i,w] =  v[i] + max[j,w]
            
*/

class Item{
    int wt;
    int value;
}
int maxWeight(int W, List<Item> items){

    Collections.sort(items, 
                     new Comparator<Item>(){
                         int compare(Item i1, Item i2){
                             return Integer.compare(i1.value, i2.value);
                         }});
    
    
    int[] val = items.stream().map(it -> it.getValue()).collect(Colections.toList())
                    .toArray(new int[items.length]);
    
    int[] wts = items.stream().map(it -> it.getWts()).collect(Colections.toList())
                    .toArray(new int[items.length]);
    
    // maxval[i][w] = max val for the first i items with allowed wt w
    int maxval[][] = new int[v.length][v.length];
    // cumwt[i][w] = wt used for the first i items when limit was w
    int cumwt[][] = new int[v.length][v.length];
    for ( int w = 1; w<=W; w++){
        for (int i = 0; i< val.length;i++){
        
            if (wts[i] > w)
                continue;
            if (i==0){
                maxval[i][w] = val[i];
                cumwt[i][w] = wts[i];
                continue;
            }
            for (int j = 0;j<i-1;j++){
                if ( cumwt[j][w-wts[i]] + wts[i] <= w){// can be added
                    int val = val[i]+ vals[j][w-wts[i]];
                    int cumwt = wt[i] + cumwt[j][w-wts[i]];
                    if ( maxval[i][w] < val){
                        maxval[i][w] = val;
                        cumwt[i][w] = cumwt;
                    }
                }
            }
        }
    }
    return maxval[items.size()-1][W];
}

/*
correct 
maxval[[i][w]= max val using first i items with limit w

 = include i in [i,w] or just use [i-1, w]
   compare to maxval[i-1, w-wt[i]] + val[i]
   
   if i too heay -> wt[i] > w use maxval[i-1][w] ; i.e. exclue item i
    
 
 
 

*/
    
    
    
    
    
