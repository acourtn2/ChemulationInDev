import java.util.*;
public class Bond {
	private int bondType, edgeNum;
	private boolean exist;
	private double weight;
	private ArrayList<Atom> adjacentAtoms;
	
	public Bond(){
		bondType = -1;
		edgeNum = -1;
		exist = false;
		weight = -1;
		adjacentAtoms = null;
	}
	public Bond(int edgeNum, int bondType, boolean exist, double weight){
		this.bondType = bondType;
		this.edgeNum = edgeNum;
		this.exist = exist;
		this.weight = weight;
		adjacentAtoms = new ArrayList<Atom>(0);
	}
	
	public Bond(int edgeNum, int bondType, boolean exist, double weight, ArrayList<Atom> adjacentAtoms){
		this.bondType = bondType;
		this.edgeNum = edgeNum;
		this.exist = exist;
		this.weight = weight;
		this.adjacentAtoms = adjacentAtoms;
	}
	
	public Bond(Bond inBond){
		this.bondType = inBond.bondType;
		this.edgeNum = inBond.edgeNum;
		this.exist = inBond.exist;
		this.weight = inBond.weight;
		this.adjacentAtoms = inBond.adjacentAtoms;
	}
	
	public int getBondType(){
		return bondType;
	}
	public void setBondType(int bondType){ // 1 is single, 2 is double, 3 is triple, 4 is electron pair, 5 is lone electron, -1 is error
		this.bondType = bondType;
	}
	public int getEdgeNum (){
		return edgeNum;
	}
	public void setEdgeNum (int edgeNum){
		this.edgeNum = edgeNum;
	}
	public boolean getExist (){
		return exist;
	}
	public void setExist (boolean exist){
		this.exist = exist;
	}
	public double getWeight (){
		return weight;
	}
	public void setWeight (double weight){
		this.weight = weight;
	}
	public ArrayList<Atom>  getAdjacentAtoms(){
		return adjacentAtoms;
	}
	public void addAdjacentAtoms(Atom inAtom){
		adjacentAtoms.add(inAtom);
	}
	public void setAdjacentAtoms (ArrayList<Atom> adjacentAtoms){
		this.adjacentAtoms = adjacentAtoms;
	}
	public String toString(){
		String temp = ("edgeNum: " + edgeNum + " bondType: " + bondType + " exist: " + exist + " weight: " + weight);
		if(adjacentAtoms == null){
			return temp;
		}
		for(Atom a: adjacentAtoms){
			temp +=  " " + a.getVertexNum() + "\n";
		}
		return temp;
	}
}
