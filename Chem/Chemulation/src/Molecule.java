import java.util.*;
public class Molecule {
	private ArrayList<Atom> atomList;
	private ArrayList<Bond> bondList;
	
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
	public String toString(){
		String temp = " ";
		if(atomList == null){
			return "Null found for atomList";
		}
		for(Atom a :atomList){
			temp = temp.concat(a.toString());
		}
		if(bondList == null){
			return "Null found for bondList";
		}
		for(Bond b : bondList){
			temp = temp.concat(b.toString());
		}
		return temp;
	}
	
}

