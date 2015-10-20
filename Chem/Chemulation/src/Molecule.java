import java.util.*;
public class Molecule {
	private ArrayList<Atom> atomList;
	private ArrayList<Bond> bondList;
	
	public static Molecule WATER = new Molecule();
	
	public Molecule(){
		atomList = new ArrayList<Atom>(5);
		bondList = new ArrayList<Bond>(5);
	}
	public Molecule(ArrayList<Atom> atomList, ArrayList<Bond> bondList){
		this.atomList = atomList;
		this.bondList = bondList;
	}
	
	public void addAtom(Atom a){
		atomList.add(a);
	}
	public void removeAtom(Atom a){
		atomList.remove(a);
	}
	public void addBond(Bond b) {
		bondList.add(b);
	}
	public void removeBond(Bond b){
		bondList.remove(b);
	}
	
	
	
	public ArrayList<Atom> getAtomList(){
		return atomList;
	}
	public void setAtomList(ArrayList<Atom> atomList){
		this.atomList = atomList;
	}
	public ArrayList<Bond> getBondList(){
		return bondList;
	}
	public void setbondList(ArrayList<Bond> bondList){
		this.bondList = bondList;
	}
	public void fixBondsOfAtom(){ // do fix bonds of Atom first
		//System.out.println("bugpoint1");
		ArrayList<Bond> temp = new ArrayList<Bond>(atomList.size());
		ArrayList<Atom> temp2 = new ArrayList<Atom>(bondList.size());
		//System.out.println("bugpoint 3, temp.size" + temp.size());
		for(int i = 0; i < atomList.size(); i++){ // iterates atomList
		
			for(int j = 0; j < bondList.size(); j++){//iterates bondList
				temp2 = bondList.get(j).getAdjacentAtoms();
				for(int k = 0; k < bondList.size(); k++){ //iterates atoms on BondList
				
					if(temp2.get(k).getVertexNum() == atomList.get(k).getVertexNum()){
					//	System.out.println("bugpoint2");
					//	atomList.get(i).addAdjacentBonds(bondList.get(j));
					}
				}
				
			}
		}
	}
/*	public void fixAtomsOfBond(){ // do fix bonds of Atom first
		ArrayList<Atom> temp = new ArrayList<Atom>(atomList.size());
		ArrayList<Bond> temp2 = new ArrayList<Bond>(bondList.size());
		for(int i = 0; i < temp2.size(); i++){ // iterates bondList
			for(int j = 0; j < atomList.size(); j++){//iterates atomlist
				temp2 = atomList.get(j).getAdjacentBonds();
				for(int k = 0; k < temp2.size(); k++){ //iterates bonds on atomList
					if(temp2.get(k).getEdgeNum() == bondList.get(k).getEdgeNum()){
						temp.set(k, bondList.get(j));
					}
				}
				bondList.get(i).setAdjacentAtoms(temp);
			}
		}
	} */
	public String toString(){
		String temp = " ";
		if(atomList == null){
			return "Null found for atomList";
		}
		for(Atom a :atomList){
			temp = temp.concat(a.toString()) + "\n";
		}
		if(bondList == null){
			return "Null found for bondList";
		}
		if(bondList.isEmpty()){
			temp += " bondList is empty"; 
			//return "bondList is empty";
		}
		for(Bond b : bondList){
			temp = temp.concat(b.toString()) + "\n";
		}
		return temp;
	}
	
}

