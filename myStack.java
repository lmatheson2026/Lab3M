import java.util.LinkedList;

public class myStack implements IStack{
	private LinkedList <Character> X;

//adds an element to the stack
	public void push(Character c) {
		X.add(c);
	}

	//pops the top value of the stack, removes the element
	public Character pop() {
		if(X.isEmpty()) {
			return null;
		}

		return X.removeFirst();

	}
//returns the top element of the stack
	public Character peek() {
		if(isEmpty()) {
			return null;
		}
		return X.getFirst();
	}

	//checks to see if the stack is empty
	public boolean isEmpty() {
		if(X.isEmpty()) {
			return true;
		}else {
			return false; 
		}
	}

}
