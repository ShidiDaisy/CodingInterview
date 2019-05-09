package Graph;

public class EdgeWithWeight {
	int src;
	int dest;
	int weight;
	
	public EdgeWithWeight(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "(" + src + ", " + dest + ", " + weight + ")";
	}
}
