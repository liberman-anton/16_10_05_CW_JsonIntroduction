import java.util.Arrays;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
//@JsonSubTypes({
//		   @JsonSubTypes.Type(value = Y.class, name = "SLON")
//          //,@JsonSubTypes.Type(value = Cat.class, name = "Cat")
//})
public class X {
	private int xi;
	private float xarf[];
	private String xs;
	public float[] getXarf() {
		return xarf;
	}
	public String getXs() {
		return xs;
	}
	public int getXi() {
		return xi;
	}
	public X(int xi, float[] xarf, String xs) {
		super();
		this.xi = xi;
		this.xarf = xarf;
		this.xs = xs;
	}
	public X(){}
	@Override
	public String toString() {
		return "X [xi=" + xi + ", xarf=" + Arrays.toString(xarf) + ", xs=" + xs + "]";
	}
	
}
