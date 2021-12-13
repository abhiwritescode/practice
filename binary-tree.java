// BFS - just use queues

class Node {Node left; Node right; Object value}

doBfs(Node n){
    Queue<Node> q= new Queue<>();
    q.add(n);
    
    while(!q.empty()){
        
        Node n= q.get();
        if ( n == null){
             continue;
        }
        visit(n);
        q.offer(n.left);
        q.offer(n.right);
    }
}

// DFS In order
//Recirsive
doDfs(Node n){
    if (n != null){
        doDfs(n.left);
        visit(n);
        doDfs(n.right);
    }
}
push(Node n){
    if ( n!=null)[{
        stk.push(n);
    }
}
// Using stack
doDfsInOrder(Node node){
    Stack<Node> stk = new Stack<>();
    stk.push(node);
    while (!stk.empty()){
        Node curr = stk.pop();
        push(curr.right); 
        if(curr.left == null){
            visit(curr);
        } else {
            push(curr); 
            push(curr.left); 
        }
    }
}
        
       
// Dfs Preorder Using stack
doDfsPreOrder(Node n){
    Stack<Node> stk = new Stack<>();
    stk.push(n);
    while (!stk.empty()){
        Node curr = stk.pop();
        visit(curr);
        push(curr.right); 
        push(nurr.left); 
}
       
// Dfs Postorder Using stack
doDfsPostOrder(Node n){
    Stack<Node> stk = new Stack<>();
    stk.push(n);
    NOde lastVisited ;
    while (!stk.empty()){
        Node curr = stk.pop();
        if ( allChildVisited(lastVisited, curr)){
              lastVisited = visit(curr);
        }else  if (curr.left != null || curr.right != null){
            stk.push(curr);
            stk.push(curr.left);
            stk.push(curr.right);
        }
    }
}
    
bool allChildVisited (Node lastVisited, Node curr){    
    if ( curr.left == null && curr.right == null ){
        return true;
    }else if(curr.right !=null){
        if (lastVisited == cur.right){
            return true;
        }
    } else if ( curr.left != null ){
        if (lastVisited == cur.left){
            return true;
        }
    }  
    return false;
}
    
            
//Design an algorithm to count the number of paths that sum to a given value. 

class Node { Node left; Node right; int value;}
class SumsAndCount{ List<Integer> sums ; int matchingCount;}   
    
int pathsToSum(NOde n, int K){
    
    return allSums(n, K).matchingCount;
    
}
    
SumsAndCount allSums(Node n, int K){
    
    if (n== null) 
         return new ArrayList<Integer>();

    SumsAndCount sumsLeft = allSums(n.left);
    SumsAndCount sumsRight = allSums(n.right);
    
    List<Integer> combinedFromLeft = sumsLeft.sums.stream().map(val -> val + n.value).collect(toList());// N log N
    List<Integer> combinedFromRt = sumsRight.sums.stream().map(val -> val + n.value).collect(toList());
    
    List<Integer> combinedLists = ImmuatbleList.builder()
        .addAll(combinedFromLeft)
        .addAll(combinedFromRt)
        .addAll(sumsLeft.sums)
        .addAll(sumsRight.sums)
        .add(curr.value)
        .build();
    int newMatchingCount = combinedLists.stream().filter(val -> val == K).collect(toList()).size();
    
    return new SumsAndCount(combinedLists, newMatchingCount + sumsLeft.matchingCount + sumsRight.matchingCount); 
}
            
            
        
        
        
