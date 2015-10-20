
public class SN1Gate {
	private Molecule inMol, outMol, reactant;
	private int pos;
	
	public SN1Gate(Molecule inMol){ //default reactant is water
		this.inMol = inMol;
		reactant = Molecule.WATER;
	}
	public SN1Gate(Molecule inMol, Molecule reactant){
		this.inMol = inMol;
		this.reactant = reactant;
	}
	
	public Molecule getOutMol(){
		return outMol;
	}
	
	public boolean isSN1(){
		boolean temp = false;
		for(int i = 0; i < inMol.getBondList().size(); i++){
			temp = hasReactionBond(inMol.getBondList().get(i));
		}
		
		return temp;
	}
	
	public boolean hasReactionBond(Bond inBond){
		return true;
	}
	
	
	
}
