//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
/*
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

i 
left = 2i+1
rgt = 2i+2


*/
List<INteger> getRightSide(List<Integer> tree){
    int i = 0;
    print(A[i]);
    while (2*i+1< tree.length ||  2*i+2 < tree.length){
        i = A[2*i+2] == null ?  A[2*i+1] : A[2*i+2];
        if (A[i] != null)
            print(A[i]);
        else
            break;
    }
        
}


// IN order DFS
void dfs(Node root){

    Stack <Node> stk = new Stack<>();
    Node n = root;
    
    while(!stk.empty || n != null){
    
        if ( n != null ){
            if ( n.left != null ){
                stk.push(n);
                n = n.left;
            } else {
                visit(n);
                if (n.rt != null )
                    stk.push(n.rt);
            }
        } else {
            n= stk.pop();
            visit(n);
            n = n.rt;
        }
                
    }
}

// Create a heap from array
/*

for i = 0..n/2
i=0
Queue<NOde> que = new Queue<>();
Node root = new Node(A[i], i)
que.offer(root);

while( !que.isEmpoty() ){
    Node n = q.get();
    int lefti = n.index * 2 + 1;
    int rgti = n.index * 2 + 2;
    

    
*/
class Node {int val;
            int index;
            Node left;
            Node rgt;
           }
Node heapify(int[] A){
    Queue<NOde> que = new Queue<>();
    Node root = new Node(A[i], i)
    que.offer(root);
    
    while( !que.isEmpoty() ){
        Node n = q.get();
        int lefti = n.index * 2 + 1;
        int rgti = n.index * 2 + 2;
        if (lefti < A.length){
            Node left = new Node(A[lefti], lefti);
            n.left = left;
            que.add(left);
            
        }
        if (rgti < A.length){
            Node rgt = new Node(A[rgti], lefti)
            n.rgt = rgt;
            que.add(rgt);
        }
    }

    
}
        
        
//  Insert into a Binary Search Tree
//You are given the root node of a binary search tree (BST) and a value to insert into the tree. 
// Return the root node of the BST after the insertion. 
// It is guaranteed that the new value does not exist in the original BST.

/*
simplest - always go for leaf O(log n)

while()
    if val > n.val
        if ( n.rt != null)
            n= n.rt
        else 
            n.rt = new NOde(val)
     else
        n=n.left
*/
public TreeNode insertIntoBST(TreeNode root, int val) {
    
    Node n = root;
    
    while (n != null){
        if (val > n.value){
            if (n.right != null)
                n= n.right;
            else {
                n.right = new Node(val);
                break;
            }
        } else {
             if (n.left != null)
                n= n.right;
            else {
                n.right = new Node(val);
                break;
            }
       }
    }
    return root;
        
}

// next lower, given node and link to parent

/*
need method findrightmost(Niode n)
if not left subtree go up to a prent which is the right child and call findrightmost(prent.left
*/

class Node{
    Node parent;
    Node left;
    Node right;
}

Node findPrevHighest(Node n){

    Node requestedNOde = n;
    if (n.left !=null){
        return findrightmode(n.left);
    }
    
    //keep traversing up till a right child or root
    while (n.parent != null && n.parent.left == n){ // n is not the right child
        n=n.parent;
    }
    
    // now n is the right child or n is the root
    if (n.parent == null){ //n is root
                    return requestedNode;

    }
    if ( n.parent.left != null ){
        return findrightmode(n.left);
    }
    else {
        return n.parent;
    }
    
}

//utility
Node findrightmode(Node n){
    
    while(n.right !=null){
        n=n.right;
    }
    return n;
}



// TEST IF A BINARY TREE IS HEIGHT-BALANCED
/*
ietratively check if the chil nodes are heoght bal;ance
if no child, return height as 1 and bal

*/
class Status{
    boolean balanced;
    int ht;
}

boolean isBalanced(Node root){
    Node n = root;
}

Status getStats(Node n){
 
    if ( n == null)
        return new Status(true,0);
    
    Status leftStats = getStats(n.left);
    Status rtStats = getStats(n.right);
    boolean balanced = abs(leftStats.ht - rtStats.ht) > 1;
    int ht = max(leftStats.ht , rtStats.ht);
    return new Status(balanced, ht);
}

//TEST IF A BINARY TREE IS SYMMETRIC

/*
leftQ - > init with left node


rtQ -> init with rt node

while (!leftQ.isEmpty())
leftN = leftQ.poll();
rtN = rtQ.poll();
leftN == rtQ

*/
    
boolean isSymm(Node root){
    Queue<Node> lQ = new Queue<>();
    Queue<Node> rtQ = new Queue<>();
    
    lQ.offer(root.left);
    rtQ.offer(root.right);

    while (!lQ.isEmpty()){
        Node lfN = lQ.poll();    
        Node rtN = rtQ.poll();    
        if ((lfN != null && !lfN.equals(rtN)) 
            ||  (rtN != null && !rtN.equals(lfN)) ){
            return false;
        }

        
        if (lfN != null){
            lQ.offer(lfN.left);
            lQ.offer(lfN.right);
        }
        if (rtN != null){
            rtQ.offer(rtN.right);
            rtQ.offer(rtN.left);
        }
    }        
        
    }
    
    
}

// COMPUTE THE LOWEST COMMON ANCESTOR IN A BINARY TREE
// no parent reference

/*

Do DFS till one node is hit. Store all nodes along the way
keep a map of level to node in htat level that was last visitied
*/

class NodeLevel{
    Node node;
    int level;
}

Node getCommon(Node n1, Node n2, Node root){

    Map<Integer, NodeLevel> target1Map = nodeByLevel(node1, root);
    if (target1Map == null)
        return null;
    Map<Integer, NodeLevel> target2Map = nodeByLevel(node2, root);
    if (target2Map == null)
        return null;

    Set<NodeLevel> node1Levels = new HashSet<>(target1Map.values());
    return Sets.intersect(new HashSet<>(target1Map.values()), new HashSet<>(target2Map.values()));
//     return target2Map.values().stream()
//         .filter(lvl -> node1Levels.contains(lvl))
//         .first();
    
    
}

Map<Integer, NodeLevel> nodeByLevel(Node target, Node root){
    
    Stack<node> stack = new Stack<>();
    stack.push(new NodeLevel(root,1));
    Map<Integer, Node> map = new LinkedHashMap<>();
    
    while (!stack.isEmpty()){
        NodeLevel lvl = stack.pop();
        map.put(lvl.level, lvl);
        
        if (lvl.node.equals(target))
            return map;
        
        if (lvl.node.left != null){
            stack.push(new NodeLevel(lvl.level + 1, lvl.node.left));
        }
        if (lvl.node.right != null){
            stack.push(new NodeLevel(lvl.level + 1, lvl.node.right));
        }
    }
    return null;// Target node not ofund
        
    
    
}



//SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE
/**
Do a pre order DFS (left node first) using stack.
add value of parent  and save with node
*/
class Node{
    Node left,right;
    int value;
}
class CumNode{
    Node node;
    int cumValue;
    void setParent(Node parent){
        this.value += parent.value * 2 ;
    }
    CumNode(Node n){
        this.n = n;
        this.cumValue = n.value;
    }
    CumNode(Node n, CumNode parent){
        this.n = n;
        this.cumValue = n.value + parent.cumValue;
    }
}

int getSum(Node root){

    Stack<CumNode> st = new Stack<>();
    st.push(new CumNode(root));
    int resultSum = 0;
    
    while(!st.isEmpty()){
        CumNode n = st.pop();
        if(n.node.left == null && n.node.right == null ){
            resultSum += n.cumValue;
            continue;
        }
        if (n.node.left != null){
            CumNode left = new CumNode(n.node.left, n);
        }
        if (n.node.right != null){
            CumNode right = new CumNode(n.node.right, n);
        }
    }
    return resultSum;
}

//COMPUTE THE km NODE IN AN INORDER TRAVERSAL


/*

implemtn find (NOde root, int K) -> node with K in its tree on left 
if left.size <k - find (right, K-left.size)
*/

//utility
Node find(Node root, int K){
    
    if (root.size == K)
        return root;
    Node left = root.left;
    if (left.size >= K){
        return find(left, K);
    } else {
        return find(root.right, K - left.size);
    }
}


//0 COMPUTE THE SUCCESSOR

/**
if node has right child, get min of right subtree
else keep going up till node is a left child, 
    get the parent, if parent has a right chil, get min of that sub tree else parent

*/
class Node{
    Node left,right,parent;
}

Node getSucc(Node n){
 
    if (n.right !=null)
        return getMin(n.right);
    
    while (n.parent != null && n != n.parent.left)
        n=n.parent;
    
    if (n.parent == null)
            return null; // Root node, so no successor
    // n is now the left child
    if (n.parent.right !=null)
        return getMin(n.parent.right);
    else
        reteurn n.parent;
}

//utility
Node getMin(Node n){
    
    while (n.left != null)
        n=n.left;
    return n;
}
    

//IMPLEMENT AN INORDER TRAVERSAL WITH 0(1) SPACE. nodes have parent fields.


/*
Go tleaf and print
if leaf , print
if last printed has right child, keep going to its left
if last printed is left child, 
     print parent

if leaf is left child, 
  print
  go to node = parent
  
if node has left child && last printed != left chils
  go to left child
else 
  print
  
if last printed has right child
  go to node = right child

if leaf and right child
  print
  keep going up till not right child, setting parent to print
  
  has left
  no left or left visited
  
  
*/

class Node{
    Node left, right, parent;
}


//RECONSTRUCT A BINARY TREE FROM A PREORDER TRAVERSAL WITH MARKERS
/*
(H,B,F, null,null, E,A,null,null,null,C, null,D, null,G,/,null,null,null)

len arr = N
get tree ((value, len) 

*/
class Node{
    int value;
    Node left;
    Node right;
}

Node getTree(int[] A){
    return getTree(A,0, A.length - 1);
    
    
    
}

Node getTree(int[] A, int start, int end){
    
    if (A[start] == null){
        return null;
    }
    if (start == end ){
        return new Node(A[start]);
    }
    // root at A[start]
    // left tree from start+1 to (start+end)/2
    // rt tree from (start
    int len = (end-start)/2; //3
    int leftstart = start+1; //1
    int leftend = leftstart + len -1 ;//1+3-1 = 3
    int rtstart = leftend +1;//4
    int rtend = rtsrat +len -1;
    
    Node left = getTree(int[]A, leftstart, leftend);
    Node right = getTree(int[]A, rightstart, rightend);
    return new Node(A[start], left, right);
}

// can convert to oterrative
class NodeDef{
    int start,end;
}

Node getTree(int[] A){
 
    Stack<NodeDef> stk = new Stack<>();
    Stack<NodeDef> processingStk = new Stack<>();
    
    
    stk.push(new NodeDef(0,A.length-1));
    while(!stk.isEmpty()){
    
        Nodedef nd = stk.pop();
        int len = (end-start)/2; //3
        int leftstart = start+1; //1
        int leftend = leftstart + len -1 ;//1+3-1 = 3
        int rtstart = leftend +1;//4
        int rtend = rtstart +len -1;
        
        stk.push(new NodeDef(rtstart, rtend));
        stk.push(new NodeDef(leftstart, leftend));
        processingStk.push(nd);
        
    }
}

Node process(Stack<NodeDef> stk, int[] A){

    Map<Integer, Node> indexToNode = new HashMap<>();

    while(!stk.isEmpty()){
        Nodedef nd = stk.pop();
        int start = nd.start;
        int end = nd.end;
        if (A[nd.start] == null){
            indexToNode.put(start, null);
            continue;
        } else if (nd.start == nd.end ){
            indexToNode.put(start, new Node(A[nd.start]));
            continue;
        }
        int len = (end-start)/2; //3
        int leftstart = start+1; //1
        int leftend = leftstart + len -1 ;//1+3-1 = 3
        int rtstart = leftend +1;//4
        int rtend = rtstart +len -1;
        Node left = indexToNode.get(leftstart);
        Node right = indexToNode.get(rtstart);
        if (left == null || right == null)
            throw new IllegalStateException("Incorrect input array.");
        
        indexToNode.put(start, new Node(A[nd.start], left, right));
    }
    return indexToNode.get(0);
}

//FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE
/**

do in order DFS - left leave gets add to list forst

*/
List<Integer> leaves = new LinkedList<>();

List<Node> getListLeaves(Node root){
    
    Stack<Node> stk = new Stack<>();
    
    Node n = root
    
    
    while(!stk.isEmpty() || n != null){
        if (n!=null){
            //put on stack and go left
            stk.push(n);
            n=n.left;
        } else {
            // take from stak, visit and go right.
            n=stk.pop();
            visit(n);
            n = n.right;
        }
    }
}

void visit(Node n){
    if (n.left ==  null && n.right == null)
        leaves.add(n.value);
}
    
// COMPUTE THE EXTERIOR OF A BINARY TREE
/*
keep going left till a leaf and then keep going right till a leaf.
*/
List<Node> outside = new ArrayList<>();

List<Node> exterior(Node root){

    Node start = firstBifurc(root);
    if (start == null)
        return outside;
    
    // start has both children
    Node n = start.left;
    // dpo the left wall
    while (!isLeaf(n)){
        outside.add(n);
        if (n.left != null)
            n = n.left;
        else
            n = n.right;
    }
    outside.add(n);

    Node n = start.right;
    // do the right wall
    while (!isLeaf(n)){
        outside.add(n);
        if (n.right != null)
            n = n.right;
        else
            n = n.left;
    }
    outside.add(n);

}

Node firstBifurc(Node root){

    Node n = root;
    while(n.left == null || n.right == null){
        outside.add(n);
        if (n.left == null && n.right == null)
            // hit leaf without any bifirc, no tree at all
            return null;
        if (n.left != null)
            n=n.left;
        else
            n=n.right;
    }
    
}

//####################################################################################################
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

    
    
                  

    
        
        
