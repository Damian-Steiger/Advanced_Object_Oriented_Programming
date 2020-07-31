
/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class Expression {
	
	/**
	 * Value of evaluation result.
	 * Dynamically, value may be an Integer or a Boolean.
	 */
	Object value; 
	int left;
	int right;
	
	/**
	 * Initialize an expression.
	 * @param left left integer value
	 * @param right right integer value
	 */
	Expression(int left, int right) { 
		this.left = left;
		this.right = right;
	}
	
	/**
	 * After evaluation, obtain the evaluation result.
	 * @return evaluation result of this expression
	 */
	Object getValue() {
		/* Your Task */
		return this.value;
	}
	
	void evaluate() {
		/* Your Task */ 
		// Hint: Leave this empty and override it in all subclasses such as Addition, GreaterThan.
	}
}

class Addition extends Expression{
	public Addition(int left, int right) {
		super(left, right);
	}
	
	void evaluate(){
		this.value = this.left + this.right;
	}
}

class Subtraction extends Expression{
	Subtraction(int left, int right) {
		super(left, right);
	}
	
	void evaluate(){
		this.value = this.left - this.right;
	}
}

class Multiplication extends Expression{
	Multiplication(int left, int right) {
		super(left, right);
	}
	
	void evaluate(){
		this.value = this.left * this.right;
	}
}

class GreaterThan extends Expression{
	GreaterThan(int left, int right) {
		super(left, right);
	}
	
	void evaluate(){
		this.value = (this.left > this.right);
	}
}

class LessThan extends Expression{
	LessThan(int left, int right) {
		super(left, right);
	}	
	
	void evaluate(){
		this.value = (this.left < this.right);
	}
}

class Equal extends Expression{
	Equal(int left, int right) {
		super(left, right);
	}	
	
	void evaluate(){
		this.value = (this.left == this.right);
	}
}
