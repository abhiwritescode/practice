
// input string find subset

List<Integer> subsets(String b, String s){

   Set<Character> smallStrSet = getCharSet(s);
   int smallLen = s.length();
   
   // Use linked list
   LinkedList<Character> foundChars = new LinkedList<>();
   int indexB =0;
	 List<Integer> retVal = new LinkedList<>();
	 
   for (Character ch : b.getChars()){
   		if ( smallStrSet.contains(ch)){
      		foundChars.add(ch);
					if (foundChars.size() == smallLen){
							retVal.add(indexB);
							foundChars.remove(0);
					}
			} else {
					foundChars.clear();
			}
   		indexB++;
   }
}
