import java.util.LinkedList;
import java.util.List;

public class DoubleStack {

	private List<Double> data;
	

	public static void main(String[] argum) {
		// TODO!!! Your tests here!
	}

	DoubleStack() {
		// TODO!!! Your constructor here!
		this.data = new LinkedList<Double>();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		DoubleStack c = new DoubleStack();
		c.data.addAll(this.data);
		
		return c; // TODO!!! Your code here!
	}

	public boolean stEmpty() {
		if (data.size() == 0) return true;
		return false; // TODO!!! Your code here!
	}

	public void push(double a) {
		// TODO!!! Your code here!
		data.add(data.size(), a);
	}

	public double pop() {
		if (data.size() <= 0) {
			throw new IndexOutOfBoundsException("No data entered!");
		}
		if (data.size() > 0) {			
			return data.remove(data.size()-1);
		} 
		return 0.; // TODO!!! Your code here!
	} // pop

	public void op(String s) {
		double d1, d2;
		switch (s) {
		case "-":
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 - d2);
			
			break;
		case "+":
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 + d2);
					
			break;
			
		case "*":
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 * d2);
						
			break;			
		case "/":
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 / d2);
			
			break;
		default:
			throw new IllegalArgumentException(String.format("Unknown operand %s", s));
			
		}
		// TODO!!!
	}

	public double tos() {
		if (data.size() <= 0) {
			throw new IndexOutOfBoundsException("No data entered!");
		}
		if (data.size() > 0) {			
			return data.get(data.size()-1);
		} 
		return 0.; // TODO!!! Your code here!
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;
		
		DoubleStack oo = (DoubleStack)o;
		return this.data.equals(oo.data);
				
		// return true; // TODO!!! Your code here!
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Double double1 : data) {
			sb.append(Double.toString(double1)).append(" ");
		}

		return sb.toString(); // TODO!!! Your code here!
	}

	public static double interpret(String pol) {
		return 0.; // TODO!!! Your code here!
	}

}
