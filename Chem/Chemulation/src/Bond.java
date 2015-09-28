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
	public Bond(int bondType, int edgeNum, boolean exist, double weight){
		this.bondType = bondType;
		this.edgeNum = edgeNum;
		this.exist = exist;
		this.weight = weight;
		adjacentAtoms = null;
	}
	
	public Bond(int bondType, int edgeNum, boolean exist, double weight, ArrayList<Atom> adjacentAtoms){
		this.bondType = bondType;
		this.edgeNum = edgeNum;
		this.exist = exist;
		this.weight = weight;
		this.adjacentAtoms = adjacentAtoms;
	}
	
	public int getBondType(){
		return bondType;
	}
	public void setBondType(int bondType){
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
	public void setAdjacentAtoms (ArrayList<Atom> adjacentAtoms){
		this.adjacentAtoms = adjacentAtoms;
	}
	public String toString(){
		String temp = ("bondType: " + bondType + " edgeNum: " + edgeNum + " exist: " + exist + " weight: " + weight);
		if(adjacentAtoms == null){
			return temp;
		}
		for(Atom a: adjacentAtoms){
			temp.concat(a.toString());
		}
		return temp;
	}
}