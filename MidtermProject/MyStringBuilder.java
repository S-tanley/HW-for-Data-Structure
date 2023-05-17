package MidtermProject;

// CS 0445 Spring 2023
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a circular, doubly linked list of nodes.  See more comments below on the
// specific requirements for the class.

// You should use this class as the starting point for your implementation. 
// Note that all of the methods are listed -- you need to fill in the method
// bodies.  Note that you may want to add one or more private methods to help
// with your implementation -- that is fine.

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder
{
	// These are the only two instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
	// Note: This method is implemented for you.  See code below.  Also read
	// the comments.  The code here may be helpful for some of your other
	// methods.
	public MyStringBuilder(String s)
	{
		if (s == null || s.length() == 0)  // special case for empty String
		{
			firstC = null;
			length = 0;
		}
		else
		{
			firstC = new CNode(s.charAt(0));  // create first node
			length = 1;
			CNode currNode = firstC;
			// Iterate through remainder of the String, creating a new
			// node at the end of the list for each character.  Note
			// how the nodes are being linked and the current reference
			// being moved down the list.
			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));  // create Node
				currNode.next = newNode;  	// link new node after current
				newNode.prev = currNode;	// line current before new node
				currNode = newNode;			// move down the list
				length++;
			}
			// After all nodes are created, connect end back to front to make
			// list circular
			currNode.next = firstC;
			firstC.prev = currNode;
		}
	}

	// Return the entire contents of the current MyStringBuilder as a String
	// For this method you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	// Note: This method is implemented for you.  See code below.
	public String toString()
	{
		char [] c = new char[length];
		int i = 0;
		CNode currNode = firstC;
		
		// Since list is circular, we cannot look for null in our loop.
		// Instead we count within our while loop to access each node.
		// Note that in this code we don't even access the prev references
		// since we are simply moving from front to back in the list.
		while (i < length)
		{
			c[i] = currNode.data;
			i++;
			currNode = currNode.next;
		}
		return new String(c);
	}

	// Create a new MyStringBuilder initialized with the chars in array s. 
	// You may NOT create a String from the parameter and call the first
	// constructor above.  Rather, you must build your MyStringBuilder by
	// accessing the characters in the char array directly.  However, you
	// can approach this in a way similar to the other constructor.
	public MyStringBuilder(char [] s)
	{
		if (s == null || s.length == 0)  // special case for empty String
		{
			firstC = null;
			length = 0;
		}
		else
		{
			firstC = new CNode(s[0]);  // create first node
			length = 1;
			CNode currNode = firstC;
			for (int i = 1; i < s.length; i++)
			{
				CNode newNode = new CNode(s[i]);  // create Node
				currNode.next = newNode;  	// link new node after current
				newNode.prev = currNode;	// line current before new node
				currNode = newNode;			// move down the list
				length++;
			}
			currNode.next = firstC;
			firstC.prev = currNode;
		}
	}
	
	// Copy constructor -- make a new MyStringBuilder from an old one.  Be sure
	// that you make new nodes for the copy (traversing the nodes in the original
	// MyStringBuilder as you do)
	public MyStringBuilder(MyStringBuilder old)
	{
		if (old == null || old.length() == 0) {
			firstC = null;
			length = 0;
		} else {
			firstC = new CNode(old.charAt(0));
			length++;
			CNode tem = firstC;
			for (int i = 1; i < old.length(); i++) {
				tem.next = new CNode(old.charAt(i));
				tem.next.prev = tem;
				tem = tem.next;
				length++;
			}
			tem.next = firstC;
			firstC.prev =tem;
		}
	}
	
	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		firstC = null;
		length = 0;
	}
	
	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!  Note
	// that you cannot simply link the two MyStringBuilders together -- that is
	// very simple but it will intermingle the two objects, which you do not want.
	// Thus, you should copy the data in argument b to the end of the current
	// MyStringBuilder.
	public MyStringBuilder append(MyStringBuilder b)
	{
		if (b == null || b.length() == 0) {
			
		} else {
			for (int i = 0; i < b.length(); i++) {
				append(b.charAt(i));
			}
		}
		return this;
	}

	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		if (s == null || s.length() == 0) {
			
		} else {
			for (int i = 0; i < s.length(); i++) {
				append(s.charAt(i));
			}
		}
		return this;
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		if (c == null || c.length == 0) {
			
		} else {
			for (char d : c) {
				append(d);
			}
		}
		return this;
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		if (length == 0) {
			firstC = new CNode(c);
			firstC.next = firstC;
			firstC.prev = firstC;
			length++;
		}else{
			CNode newnode = new CNode(c);
			firstC.prev.next = newnode;
			newnode.prev = firstC.prev;
			firstC.prev = newnode;
			newnode.next = firstC;
			length++;
		}
		return this;
	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		if (index < 0 || index >= this.length()) {
			throw new IndexOutOfBoundsException("Illegal position given to add operation."); 
		} else {
			CNode tem = firstC;
			for (int i = 1; i <= index; i++) {
				tem = tem.next;
			}
			return tem.data;
		}
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
		if (start >= length || start < 0 || end <= start) {
			
		} else {
			CNode tem1 = firstC;
			CNode tem2 = firstC;
			for (int i = 1; i < start; i++) {
				tem1 = tem1.next;
			}
			for (int i = 1; i <= (end>length?length:end); i++) {
				tem2 = tem2.next;
			}
			tem1.next = tem2;
			tem2.prev = tem1;
			if (end >= length) {
				length = start;
			} else {
				if (start == 0) {
					firstC = tem2;
					tem1.prev.next = firstC;
				}
				length -= end - start; 
			}
		}
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).  If "index"
	// is the last character in the MyStringBuilder, go backward in the list in
	// order to make this operation faster (since the last character is simply
	// the previous of the first character)
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		if (index >= this.length() || index < 0) {
			
		} else {
			if (this.length == 0) {
				firstC = null;
			}else if (index == this.length()-1) {
				firstC.prev = firstC.prev.prev;
				firstC.prev.next = firstC;
			} else {
				CNode tem = firstC;
				for (int i = 1; i <= index; i++) {
					tem = tem.next;
				} 
				if (index == 0) {
					firstC = firstC.next;
				}
				tem.next.prev = tem.prev;
				tem.prev.next = tem.next;
			}
			length--;
		}
		return this;
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		if (str == null || str.length() == 0) {
			return -1;
		}
		CNode tem = firstC;
		for (int i = 0; i < length-str.length()+1; i++) {
			if (match(tem, str)) {
				return i;
			}
			tem = tem.next;
		}
		return -1;
	}

	private boolean match(CNode start, String str) {
		CNode tem = start;
		for (int i = 0; i < str.length(); i++) {
			if (tem.data != str.charAt(i)) {
				return false;
			}
			tem = tem.next;
		}
		return true;
	}
	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
		if (offset == length) {
			append(str);
		} else if (offset < 0 || offset > length){
			
		} else {
			CNode tfirst = new CNode(str.charAt(0));
			CNode tem = tfirst;
			for (int i = 1; i < str.length(); i++) {
				CNode newnode = new CNode(str.charAt(i));
				tem.next = newnode;
				newnode.prev = tem;
				tem = tem.next;
			}
			if (offset == 0) {
				tem.next = firstC;
				firstC.prev.next = tfirst;
				tfirst.prev = firstC.prev;
				firstC.prev = tem;
				firstC = tfirst;
			} else {
				CNode cp = firstC;
				for (int index = 1; index < offset; index++) {
					cp = cp.next;
				}
				cp.next.prev = tem;
				tem.next = cp.next;
				tfirst.prev = cp;
				cp.next = tfirst;
			}
			length += str.length();
		}
		return this;
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		if (offset == length) {
			append(c);
		} else if (offset < 0 || offset > length) {

		} else {
			CNode tem = firstC;
			for (int i = 1; i <= offset; i++) {
				tem = tem.next;	
			}
			CNode newnode = new CNode(c);
			tem.prev.next = newnode;
			newnode.prev = tem.prev;
			tem.prev = newnode;
			newnode.next = tem;
			length++;
		}
		return this;
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return this.length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder replace(int start, int end, String str)
	{
		CNode snode;
		CNode enode;
		if (start < 0 || start >= length || end <= start) {
			return this;
		} else {
			CNode tem = firstC;
			for (int i = 1; i <= start; i++) {
				tem = tem.next;
			}
			snode = tem;
			if (end >= length) {
				enode = firstC.prev;
			} else {
				for (int i = start; i < end; i++) {
					tem = tem.next;
				}
				enode = tem;
			}
			if (end >= length) {
				length = start;
			} else {
				length -= end - start; 
			}
		}
		snode = snode.prev;
		CNode flag = snode;
		for (int i = 0; i < str.length(); i++) {
			snode.next = new CNode(str.charAt(i));
			snode.next.prev = snode;
			snode = snode.next;
			length++;
		}
		snode.next = enode;
		enode.prev = snode;
		if (start == 0) {
			firstC = flag.next;
		}
		return this;
	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder.  For this method
	// you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	public String substring(int start, int end)
	{
		if (start >= end || start < 0 || start >= length || end <= 0 || end > length) {
			return null;
		} else {
			char resultArray[] = new char[end - start];
			CNode tem = firstC;
			for (int i = 1; i <= start; i++) {
				tem = tem.next;
			}
			for (int i = 0; i < end-start; i++) {
				resultArray[i] = tem.data;
				tem = tem.next;	
			}
			return new String(resultArray);	
		}
	}

	// Return as a String the reverse of the contents of the MyStringBuilder.  Note
	// that this does NOT change the MyStringBuilder in any way.  See substring()
	// above for the basic approach.
	public String revString()
	{
		if (length == 0) {
			return null;
		} else {
			CNode tem = firstC;
			char [] resultArray = new char[length];
			for (int i = 0; i < length; i++) {
				tem = tem.prev;
				resultArray[i] = tem.data;
			}
			return new String(resultArray);
		}
	}
	
	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data, next and prev fields directly.
	private class CNode
	{
		private char data;
		private CNode next, prev;

		public CNode(char c)
		{
			data = c;
			next = null;
			prev = null;
		}

		public CNode(char c, CNode n, CNode p)
		{
			data = c;
			next = n;
			prev = p;
		}
	}
}

