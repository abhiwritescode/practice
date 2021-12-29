

// Constrauct BST from a a givebn array

class Node{
  Node left;
  Node rt;
  Node parent;
  int value;
  Node(Node parent, int value){
    this.parent = parent;
    this.value = value;
  }
  Node addLeft(int value){
    this.left = new Node(this, value);
  
  }
  Node addRight(int value){
      this.right = new Node(this, value);
  }
}

// Logic : first number will be root and subsequent ones added as children, no recursion
// results in n log n

Node getTree(int[] N){

  Node root = new NOde(N[0]);
  for (int i = 1; i< N.length; i++){
    add(root, N[i]);
  }
}

Node add(Node parent, int val){
  
  if(val > parent.value){
    if(parent.right == null ){
      return parent.addRight(val);
    } else {
      return add(parent.right, val);
    }
  } else {
     if(parent.left == null ){
      return parent.addLeft(val);
    } else {
      return add(parent.left, val);
    }
  }
}

// given twi nums find the distance.

// find common parent - thi si sthe node whose valu is between the 2 value
// from parent traverse 

int dist(int val1, int val2){
  Node root = getTree(N);
  Node common = findCommonParent( root,  val1,  val2);
  int dist1 = dist(common, val1);
  
  int dist2 = dist(common, val2);
  return dist1 < 0 || dist2 < 0 ? -1 : dist1 + dist2
  
}

int dist(Node common, int val){
  
  Node node = common;
  counter = 0;
  
  while(node.value != val1 && node != null ){
    counter ++;
    if (val1 < node.value){
      node = node.left;
    } else {
      node = node.right;
    }
  }
  return node != null ? counter ; -1;
    
}

Node findCommonParent(Node root, int val1, int val2){

  // Do a BFS till common parent is found
  Queue<Node> queue = new Queue<>();
  queue.offer(root);
  int low = min(val1,val2);
  int hi =  max(val1,val2);
  
  while (!queue.iEmpty()){
   
    Node next = queue.poll();
    if (next.value == val1 || next.value == val2){
      return next;
    } else if ( next.value > low && next.value < hi){
      return next;
    }
    // continue the search
    if (next.left != null ){
      queue.offer(next.left);
    }
    if (next.right != null ){
      queue.offer(next.right);
    }
    
  }
  return null;
  
}


// check mathicn brackets

/** put diff bracket ytpes on a stack.
when a closing bracket comes in , it shd match an openning on on the top of the stack
*/


boolean matches(String S){
  
 
  Stack<Character> stk = new Stack<>();
  for(Chracter c: S.charSet()){
    
    if(isOpening(c)){
      stk.push();
    }
    if(!isBracket(c)){
      continue;
    }
    if(isClosing(stk.peek(), c)){
      stk.pop();
    } else {
      return 0;
    }
  }
  return stk.isEmpty() ? 1 : 0;
}

boolean isOpening(Character opening){
}

boolean isClosing(Character opening, Character closing){
  
  
  
  
  
}


// substrig of size K with only one repeating character
// take eacvh substring and scan - O(Nk)

List<String> substrs(String S, int K){
  Set<String> output = new HashSet<>();
  for ( int i=0; i<S.length-K; i++){

    String subs = S.substring(i,K);
    if( qualifies(subs)){
      output.add(subs);
    }
  }
}

boolean qualifies (String sub){
  Map<Character, Integer> map = new HashMap<>();
  boolean dupeFound = false;
  for (Character c: sub){
    Integer count = map.get(c);
    if (count == null){
      count = 0;
    }
    count+=1;
    if ( count >1){
      if (dupeFound )
        return false;
      else 
        dupeFound = true;
    }
    map.put(c, count++);

  }  
}
