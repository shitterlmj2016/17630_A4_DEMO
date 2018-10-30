// The purpose of this class is to illustrate how to create linked object.
// There are two source files required:
//
// 1. This one, NodeMain which is a kind of test harness for...
// 2. Node which is the node object.
//
// To compile these files, at the command line type: javac *.java
// To execute the program, at the commend line type: java NodeMain

public class NodeMain
{
   public static void main( String argv[] )
   {
    	Termio UserInput = new Termio();	// Termio IO Object
		boolean Done = false;				// Main loop flag
		String Option = null;				// Menu choice from user
		String UserData = null;				// Data to store in the list
		Node MyList = null;					// The list of nodes

		while (!Done)
		{
			// Here we present the main menu

			System.out.println( "\n\n\n\n" );
			System.out.println( "Node Tester Console: \n" );
			System.out.println( "1: Append" );
			System.out.println( "2: Print" );
			System.out.println( "3: Delete" );
			System.out.println( "X: Exit\n" );
			System.out.print( "\n>>>> " );

			Option = UserInput.KeyboardReadString();

			//////////// option 1 ////////////

			if ( Option.equals( "1" ) )
			{
				// Get some data from the user and add node to list

				System.out.print( "\n\nEnter a string: " );
				UserData = UserInput.KeyboardReadString();
				System.out.print( "\n===============\n" );

				// If the list is emtpy, we create a node
				// otherwise we append.

				if ( MyList == null )
				{
					MyList = new Node( UserData );

				} else {

					MyList.Append( UserData );
				}

			} // if

			//////////// option 2 ////////////

			// Just print the list

			if ( Option.equals( "2" ) )
			{
				System.out.print( "\n\nCurrent List...\n\n" );

				if ( MyList != null)
				{
					MyList.Print();

				} else {

					System.out.println( "List is empty..." );

				}

			} // if

			//////////// option 3 ////////////

			// Delete a node from the list by name

			if ( Option.equals( "3" ) )
			{
				// Get some data from the user

				System.out.print( "\n\nEnter name to delete: " );
				UserData = UserInput.KeyboardReadString();

				if ( MyList != null )
				{

					MyList = MyList.Delete( MyList, UserData );

				} else {

					System.out.println( "List is empty..." );

				}

			} // if

			//////////// option X ////////////

			// Exit

			if ( Option.equalsIgnoreCase( "X" ) )
			{
				Done = true;

			} // if

		} // while

  	} // main

} // NodeMain