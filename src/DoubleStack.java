import java.util.LinkedList;
import java.util.List;


public class DoubleStack {

	private List<Double> data;
	

	public static void main(String[] argum) {
		
		double d;
		if (argum.length > 0) {
			if (argum[0].equals("-i")) {
				System.out.println("Interactive mode. Enter empty string to quit");
				String input = TextIO.getlnString();
				while(!input.equals("")) {
					
					System.out.printf("Interpreting '%s' = ", input);
					try {
						d = DoubleStack.interpret(input);
						System.out.println(d);
					} catch (RuntimeException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Interactive mode. Enter empty string to quit");
					input = TextIO.getlnString();
					
				}
				return;
			} else if (argum[0].equals("-s")) {
				// TODO!!! Your tests here!
				
				for (int i = 1; i < argum.length; i++) {
					System.out.printf("Interpreting '%s' = ", argum[i]);
					try {
						d = DoubleStack.interpret(argum[i]);
						System.out.println(d);
					} catch (RuntimeException e) {
						System.out.println(e.getMessage());
					}			
				}
				return;
			} 	
		} else {
			System.out.println("use -i for interactive mode");
			System.out.println("use -s to interpret arguments");
		}
		
				
		
		//System.out.println("Interactive / command line parser disabled for Moodle unit testing");
		
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
		} else {
					
			return data.remove(data.size()-1);
		} 
		
	} // pop

	public void op(String s) {
		double d1, d2;
		if (this.data.size() < 2) {
			throw new IllegalArgumentException(String.format("At least two numbers needed for operand %s, %d provided", s, this.data.size()));
		}
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
			throw new IndexOutOfBoundsException("Cannot retrieve top from empty stack!");
		} else {			
			return data.get(data.size()-1);
		} 
		
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
		double d;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < ol.length; i++) {
			//System.out.printf("\"%s\"\n", ol[i]);
			if (ol[i].equals("")) {				
				
			} else if (				
				ol[i].equals("-") || 
				ol[i].equals("+") ||
				ol[i].equals("*") ||
				ol[i].equals("/") 
					) {
				sb.append(ol[i]).append(" ");
				try {
					ds.op(ol[i]);
				} catch (RuntimeException e) {
					
					throw new RuntimeException(String.format("Error occured:\n%s^ %s\n" , sb.toString(), e.getMessage()));
				}
				
			} else {
				sb.append(ol[i]).append(" ");
				try {
					d = Double.parseDouble(ol[i]);
					ds.push(d);
				} catch (NumberFormatException e ) {
					throw new RuntimeException(String.format("Error occured:\n%s^ Cannot transform '%s' to double.\n" , sb.toString(), ol[i]));

				}
			
			}
				
			
		}
		d = ds.pop(); 
		if (!ds.stEmpty()) {
			throw new RuntimeException("Too few operands to calculate result!");
		}
		return d; // TODO!!! Your code here!
	}

}
