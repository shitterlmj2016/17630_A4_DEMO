// The purpose of this class is to illustrate how to create linked object.
// There are to source files required:
//
// 1. NodeMain which is a kind of test harness for...
// 2. This one, Node which is the node object.
//
// To compile these files, at the command line type: javac *.java
// To execute the program, at the commend line type: java NodeMain

public class Node
{
	Node Next = null;		// Next node in the list
	String Data = null;		// Node data

	//Constructor = note that next is already null

	public Node(String UserData)
	{
		Data = UserData;
	}

	// Appends a node using recursion. First we call Append until Next equals null.
	// Once next equals null, we create a new node and set it equal to next.

	public void Append( String UserData )
	{
		if ( Next == null ) // Base case
		{
			Next = new Node(UserData);

		} else {

			Next.Append( UserData );
		}

	    return;

   	} // Append

	// Delete a node uses iteration. First we check to see if the node to delete is
	// the first node. If not we search the list until we find the node with the
	// data to delete.

	Node Delete( Node aList, String UserData )
	{
		Boolean done = false;
		Node temp = null;
		Node prev = null;

		// Check to see if we delete the first node
		if(UserData.compareToIgnoreCase(Data) == 0)
		{
			aList = Next;

		} else {

			// Here we check to make sure there is more than one node in the list

			if (aList.Next == null)
			{
				done = true;
			} else {
				prev = aList;		// trailing node already checked
				temp = aList.Next;	// current node to inspect
			}

			// Here is the main search loop
			while(!done)
			{
				if (UserData.compareToIgnoreCase(temp.Data) == 0)
				{
					prev.Next = temp.Next;
					done = true;
				} else {
					// check to see if we are at the end of the list
					// but didn't find anything
					if (temp.Next == null )
					{
						done = true;
					} else {
						prev = temp;
						temp = temp.Next;
					}
				}
			}
		}

		return aList;

   	} // Delete

   	// Prints the list using recursion. First we print Data. If Next is not equal
   	// null then we call Next.Print(). In Next equals null we are done.

   	public void Print()
	{
		System.out.println( Data );

		if ( Next == null ) // Base case
		{
			return;

		} else {

			Next.Print();
		}

	} // Print

} // Node