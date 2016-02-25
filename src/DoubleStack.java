import java.util.LinkedList;
import java.util.List;


public class DoubleStack {

	private List<Double> data;
	

	public static void main(String[] argum) {
		// TODO!!! Your tests here!
		DoubleStack ds = new DoubleStack();
		ds.interpret("2 3. \t  * - s");
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
		if (s.equals("-")) {
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 - d2);
		} else if (s.equals("+")) {

			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 + d2);
		} else if (s.equals("*")) {
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 * d2);
		} else if (s.equals("/")) {
			d2 = this.pop();
			d1 = this.pop();
			this.push(d1 / d2);
		} else {

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
		DoubleStack ds = new DoubleStack();
		String[] ol = pol.split("\\s");
		//System.out.println("\""+pol+"\"");
		double d ;
		for (int i = 0; i < ol.length; i++) {
			//System.out.printf("\"%s\"\n", ol[i]);
			if (ol[i].equals("")) {				
				
			} else if (
				ol[i].equals("-") || 
				ol[i].equals("+") ||
				ol[i].equals("*") ||
				ol[i].equals("/") 
					) {
				ds.op(ol[i]);
				
			} else {
				try {
					d = Double.parseDouble(ol[i]);
					ds.push(d);
				} catch (NumberFormatException e ) {
					throw e;
				}
			
			}
				
			
		}
		d = ds.pop(); 
		if (!ds.stEmpty()) {
			throw new RuntimeException("Too few operands!");
		}
		return d; // TODO!!! Your code here!
	}

}
