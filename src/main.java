
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static Rect intersection(Rect R0, Rect R1){
		int xlow,xhigh,ylow,yhigh;
		if(R1.x0>R0.x0) xlow=R1.x0;
		else xlow=R0.x0;
		if(R1.x1>R0.x1) xhigh=R0.x1;
		else xhigh=R1.x1;
		if(R1.y0>R0.y0) ylow=R1.y0;
		else ylow=R0.y0;
		if(R1.y1>R0.y1) yhigh=R0.y1;
		else yhigh=R1.y1;
		
		//TODO: did this check intersection?? we covered all cases and made
		// a new rectangle....check w team.
	}

}
