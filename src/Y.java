
public class Y extends X {
	
	@Override
	public String toString() {
		return "Y [" + super.toString() + ", " + "ys=" + ys + ", yi=" + yi + "]";
	}
	String ys;
	int yi;
	public Y(){}
	public String getYs() {
		return ys;
	}
	public int getYi() {
		return yi;
	}
	public Y(int xi, float[] xarf, String xs, String ys, int yi) {
		super(xi, xarf, xs);
		this.ys = ys;
		this.yi = yi;
	}
	
}
