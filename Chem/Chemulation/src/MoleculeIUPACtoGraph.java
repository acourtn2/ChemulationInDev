import java.util.*;
public class MoleculeIUPACtoGraph{
	private String masterString;
	private Scanner cin;
	private int numArgs = 7;
	private ArrayList<ArrayList<String>> sections = new ArrayList<ArrayList<String>>();
	private ArrayList<Boolean> ifSections = new ArrayList<Boolean>();
	private ArrayList<Atom> aList = new ArrayList<Atom>();
	private ArrayList<Bond> bList = new ArrayList<Bond>();
		/**
		 * {
		 * 	0: isAlkane
		 * 	1: isAlkene
		 * 	2: isAlkyne
		 * 	3: isHalide
		 * 	4: isAlcohol
		 *  5: isCyclic
		 *  6: hasBranch
		 * 
		 */
	public MoleculeIUPACtoGraph(){
		cin = new Scanner(System.in);
		System.out.println("Type a molecule name(IUPAC)");
		masterString = cin.nextLine().toLowerCase();
		cin.close();
		setIfSections();
		setSections();
	}
	public MoleculeIUPACtoGraph(String inStr){
		masterString = inStr.toLowerCase();
		setIfSections();
		setSections();
	}
	public void setSections(){
		for(int i = 0; i < numArgs; i++){
			sections.add(new ArrayList<String>(0));
		}
	}
	public void setIfSections(){
		for(int i = 0; i < numArgs; i++){
			ifSections.add(false);
		}
	}
	public Molecule convertToMolecule(){
		
		sectionCreater();
		sectionWorker();
	
		return (new Molecule(aList, bList));
	}
	
	
	public void sectionCreater(){ //divvies up the inString into parts the are works on individually
		testIfSections();
		String toWorkString = masterString;
		String base = toWorkString;
		while(base.contains("cyclo") || (!(base.contains("ane") || base.contains("ene") || base.contains("yne")))){
			if(base.contains("cyclo")){ // removes cyclo
				String temp = base;
				int beforeCyc = base.indexOf("cyclo");
				int afterCyc = beforeCyc + 5;
				if(beforeCyc == 0){
					temp = temp.substring(afterCyc);
				} else {
					temp = temp.substring(0,beforeCyc) + temp.substring(afterCyc);
				}
				base = temp;
				sections.set(5, (new ArrayList<>(Arrays.asList("cyclo"))));
			}
			if(base.contains("bromo") || base.contains("chloro") || base.contains("floro")){
				String temp = base;
				int beforeHal = 0;
				int afterHal = 0;
				int locOfHal = 0;
				int previousSpace = 0;
				
				afterHal = base.indexOf("bromo") + 5;
				if(base.contains("-")){
					for(int k = 0; k < base.length(); k++){
						if(base.charAt(k) == '-'){
							beforeHal = k;
						}
					
					}
				}
				for(int k = beforeHal; k > 0; k--){
					if(base.charAt(k) == ' '){
						previousSpace = k;
						break;
					}
				}
				locOfHal = Integer.parseInt(base.substring(previousSpace, beforeHal));
				int powerOH = 0;
				for(int k = locOfHal; k >= 10; k/= 10){
					powerOH ++;
				}
			
			
			}
			
			
			if(base.contains("ol")){
				String temp = base;
				int beforeOH = 0;
				int afterOH = 0;
				int locOfOH = 0;
				int previousSpace = 0;

				afterOH = base.indexOf("ol") + 2;
				if(base.contains("-")){
					for(int k = 0; k < base.length(); k++){
						if(base.charAt(k) == '-'){
							beforeOH = k;
						}
					}
					for(int k = beforeOH; k > 0; k--){
						if(base.charAt(k) == ' '){
							previousSpace = k;
							break;
						}
					}
					locOfOH = Integer.parseInt(base.substring(previousSpace, beforeOH));
					int powerOH = 0;
					for(int k = locOfOH; k >= 10; k/= 10){
						powerOH ++;
					}
					base = (temp.substring(0,beforeOH - previousSpace - (powerOH) - 1) + (getPrefix(getPrefixNum(base))) + "ane" + base.substring(afterOH));
				} else {
					beforeOH = 0;
					locOfOH = 0;
					base = (temp.substring(0,beforeOH) + (getPrefix(getPrefixNum(base))) + "ane" + base.substring(afterOH));
				}
			//	base = (temp.substring(0,) + (getPrefix(getPrefixNum(base))) + "ane" + base.substring(afterOH));
				sections.set(4, (new ArrayList<>(Arrays.asList(Integer.toString(locOfOH)))));
			}
		}
		sections.set(0, (new ArrayList<>(Arrays.asList(base ))));
	}
	public void testIfSections(){
		String toWorkString = masterString;
		if(toWorkString.contains("ane")){
			ifSections.set(0,true);
		} else if(toWorkString.contains("ene")){
			ifSections.set(1,true);
		} else if(toWorkString.contains("yne")){
			ifSections.set(2,true);
		}
		if(toWorkString.contains("ol")){
			ifSections.set(0, true);
			ifSections.set(4, true);
			ifSections.set(6, true);
		}
		if(toWorkString.contains("bromo") || toWorkString.contains("cholo") || toWorkString.contains("fluro")){
			ifSections.set(3, true);
			ifSections.set(6, true);
		}
		if(toWorkString.contains("cyclo")){
			ifSections.set(5, true);
		}
		if(toWorkString.contains("-")){
			ifSections.set(6, true);
		}
	}
	
	
	public void sectionWorker(){
		for(int i = 0; i < sections.size(); i++){
			
			ArrayList<String> working = sections.get(i);
			if(i == 0){ //base section, or the origin "molecule"
				String base = working.get(i);

				if(ifSections.get(0)){
					int numAtoms = getPrefixNum(base.substring(0, (base.indexOf("ane"))));
					for(int j = 0; j < numAtoms; j++){
						if(aList == null)
						{
							aList.add(new Atom(1, 6, 12.011, 2.0, "Carbon"));
						} else {
						aList.add(new Atom(aList.size(), 6, 12.011, 2.0, "Carbon"));
						}
					}
					for(int j = 1; j < numAtoms; j++){
						if(j == 1){
							Bond tempBond = new Bond( bList.size(),1, true, 1);
							tempBond.addAdjacentAtoms(aList.get(0));
							tempBond.addAdjacentAtoms(aList.get(1));
							bList.add(tempBond);
						} else if( j == (numAtoms -1)){
							Bond tempBond = new Bond(bList.size(), 1,true, 1);
							tempBond.addAdjacentAtoms(aList.get(numAtoms-2));
							tempBond.addAdjacentAtoms(aList.get(numAtoms-1));
							bList.add(tempBond);
						} else {
							Bond tempBond = new Bond(bList.size(), 1,true,1);
							tempBond.addAdjacentAtoms(aList.get(j-1));
							tempBond.addAdjacentAtoms(aList.get(j));
							bList.add(tempBond);
						}
					}
				} else if(ifSections.get(1)){ // if base as a double bond or "ene"
					int numAtoms;
					int dBondPos;
					if(!(base.indexOf("-") == -1)){
						dBondPos = Integer.parseInt(base.substring(0, base.indexOf("-")))-1;
						numAtoms = getPrefixNum(base.substring(base.indexOf("-")+1, (base.indexOf("ene"))));
					} else { // handles simple molecules of ethene and propene
						dBondPos = 0;
						numAtoms = getPrefixNum(base.substring(0, (base.indexOf("ene"))));
					}
					
					System.out.println(dBondPos);
					for(int j = 0; j < numAtoms; j++){
						if(aList == null)
						{
							aList.add(new Atom(1, 6, 12.011, 2.0, "Carbon"));
						} else {
						aList.add(new Atom(aList.size(), 6, 12.011, 2.0, "Carbon"));
						}
					}
					for(int j = 1; j < numAtoms; j++){
						if(j == 1){
							Bond tempBond = new Bond( bList.size(),1, true, 1);
							tempBond.addAdjacentAtoms(aList.get(0));
							tempBond.addAdjacentAtoms(aList.get(1));
							bList.add(tempBond);
						} else if( j == (numAtoms -1)){
							Bond tempBond = new Bond(bList.size(), 1,true, 1);
							tempBond.addAdjacentAtoms(aList.get(numAtoms-2));
							tempBond.addAdjacentAtoms(aList.get(numAtoms-1));
							bList.add(tempBond);
						} else {
							Bond tempBond = new Bond(bList.size(), 1,true,1);
							tempBond.addAdjacentAtoms(aList.get(j-1));
							tempBond.addAdjacentAtoms(aList.get(j));
							bList.add(tempBond);
						}
					}
					bList.get(dBondPos).setBondType(2);
					
				} else if(ifSections.get(2)){ // checks if there is an alkyne
					int numAtoms;
					int tBondPos;
					if(!(base.indexOf("-") == -1)){
						tBondPos = Integer.parseInt(base.substring(0, base.indexOf("-")))-1;
						numAtoms = getPrefixNum(base.substring(base.indexOf("-")+1, (base.indexOf("yne"))));
					} else { // handles simple molecules of ethyne and propyne
						tBondPos = 0;
						numAtoms = getPrefixNum(base.substring(0, (base.indexOf("yne"))));
					}
					
					for(int j = 0; j < numAtoms; j++){
						if(aList == null)
						{
							aList.add(new Atom(1, 6, 12.011, 2.0, "Carbon"));
						} else {
						aList.add(new Atom(aList.size(), 6, 12.011, 2.0, "Carbon"));
						}
					}
					for(int j = 1; j < numAtoms; j++){
						if(j == 1){
							Bond tempBond = new Bond( bList.size(),1, true, 1);
							tempBond.addAdjacentAtoms(aList.get(0));
							tempBond.addAdjacentAtoms(aList.get(1));
							bList.add(tempBond);
						} else if( j == (numAtoms -1)){
							Bond tempBond = new Bond(bList.size(), 1,true, 1);
							tempBond.addAdjacentAtoms(aList.get(numAtoms-2));
							tempBond.addAdjacentAtoms(aList.get(numAtoms-1));
							bList.add(tempBond);
						} else {
							Bond tempBond = new Bond(bList.size(), 1,true,1);
							tempBond.addAdjacentAtoms(aList.get(j-1));
							tempBond.addAdjacentAtoms(aList.get(j));
							bList.add(tempBond);
						}
					}
					bList.get(tBondPos).setBondType(3);
				}
			
			}
			if(i == 3){ //build the halides
				
				
			}
			if(i == 4){ // this deals with small  of alcohol
				for(int j = 0; j < working.size(); j++){
				//	System.out.println(working.get(j));
				//	System.out.println("dBond on atom : " + Integer.parseInt(working.get(j)));
					aList.add(new Atom(aList.size(), 8, 15.99, 2.0, "Oxygen"));
					aList.add(new Atom(aList.size(), 1, 1.0079, 2.0, "Hydrogen"));
					Bond oxyHydBond = new Bond(bList.size(), 1, true, 1);
					Bond oxyCarBond = new Bond(bList.size()+1, 1, true, 1);
					oxyHydBond.addAdjacentAtoms(aList.get(aList.size() -2));
					oxyHydBond.addAdjacentAtoms(aList.get(aList.size() -1));
					oxyCarBond.addAdjacentAtoms(aList.get(aList.size() -2));
					int tempInt = Integer.parseInt(working.get(j))-1;
					if(tempInt < 0){
						tempInt = 0;
					}
					oxyCarBond.addAdjacentAtoms(aList.get(tempInt));
					bList.add(oxyHydBond);
					bList.add(oxyCarBond);
					
				}
			}
			if(i == 5){
				for(int j = 0; j < working.size(); j++){
				Bond endOfCycle = new Bond(bList.size(),1, true, 1);
				endOfCycle.addAdjacentAtoms(aList.get(0));
				int numAtoms = getPrefixNum(masterString.substring(0, (masterString.indexOf("ane"))));
				endOfCycle.addAdjacentAtoms(aList.get(numAtoms-1));
				bList.add(endOfCycle);
				}
			}
		}
	}
	
	
	public String getMasterString(){
		return masterString;
	}
	
	
	
	public int getPrefixNum(String prefix){
		if(prefix.contains("meth")){
			return 1;
		} else if(prefix.contains("eth")){
			return 2;
		} else if(prefix.contains("prop")){
			return 3;
		} else if(prefix.contains("but")){
			return 4;
		} else if(prefix.contains("pent")){
			return 5;
		} else if(prefix.contains("hex")){
			return 6;
		} else if(prefix.contains("hept")){
			return 7;
		} else if(prefix.contains("oct")){
			return 8;
		} else if(prefix.contains("non")){
			return 9;
		} else if(prefix.contains("dec")){
			return 10;
		} else { 
			return -1;
		}
	}
	public String getPrefix(int input) {
		if(input == 1){
			return "meth";
		} else if(input == 2){
			return "eth";
		} else if(input == 3){
			return "prop";
		} else if(input == 4){
			return "but";
		} else if(input == 5){
			return "pent";
		} else if(input == 6){
			return "hex";
		} else if(input == 7){
			return "hept";
		} else if(input == 8){
			return "oct";
		} else if(input == 9){
			return "non";
		} else if(input == 10){
			return "dec";
		} else {
			return "";
		}
	}
}
