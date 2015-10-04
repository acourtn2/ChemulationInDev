import java.util.*;
public class Atom {
	private int atomicNum, vertexNum;
	private double atomicWeight, electroNeg;
	private String atomName;
	private ArrayList<Bond> adjacentBonds;
	
	public Atom(){
		atomicNum = -1;
		vertexNum = -1;
		atomicWeight = -1;
		electroNeg = -1;
		atomName = "Undefined Atom";
		adjacentBonds = null;
	}
	public Atom(int vertexNum, int atomicNum, double atomicWeight, double electroNeg, String atomName){
		this.atomicNum = atomicNum;
		this.vertexNum = vertexNum;
		this.atomicWeight = atomicWeight;
		this.electroNeg = electroNeg;
		this.atomName = atomName;
		adjacentBonds = null;
	}
	public Atom(int vertexNum, int atomicNum, double atomicWeight, double electroNeg, String atomName,ArrayList<Bond> adjacentBonds){
		this.atomicNum = atomicNum;
		this.vertexNum = vertexNum;
		this.atomicWeight = atomicWeight;
		this.electroNeg = electroNeg;
		this.atomName = atomName;
		this.adjacentBonds = adjacentBonds;
	}
	
	public int getAtomicNum(){
		return atomicNum;
	}
	public void setAtomicNum (int atomicNum) {
		this.atomicNum = atomicNum;
	}
	public int getVertexNum(){
		return vertexNum;
	}
	public void setVertexNum(int vertexNum) {
		this.vertexNum = vertexNum;
	}
	public double getAtomicWeight(){
		return atomicWeight;
	}
	public void setAtomicWeight(double atomicWeight) {
		this.atomicWeight = atomicWeight;
	}
	public double getElectroNeg(){
		return electroNeg;
	}
	public void setElectroNeg (double electroNeg) {
		this.electroNeg = electroNeg;
	}
	public String getAtomName(){
		return atomName;
	}
	public void setAtomName(String atomName) {
		this.atomName = atomName;
	}
	public ArrayList<Bond> getAdjacentBonds(){
		return adjacentBonds;
	}
	public void setAdjacentBonds(ArrayList<Bond> adjacentBonds) {
		this.adjacentBonds = adjacentBonds;
	}
	public String toString(){
		String temp = ("vertexNum: "  + vertexNum + " atomicNum: " + atomicNum + " atomicWeight: " + atomicWeight + " electroNeg: " + electroNeg + " atomName: " + atomName + " adjacentBonds ");
		if(adjacentBonds == null){
			return temp;
		}
		for(Bond b: adjacentBonds){
			temp.concat(b.toString());
		}
		return temp;
	}
}
