import java.util.*;
public class Tester {
	public static void main(String[] args){ // use JSON!
		MoleculeIUPACtoGraph graphOne = new MoleculeIUPACtoGraph();
		Molecule test = graphOne.convertToMolecule();
	
		test.fixBondsOfAtom();
		WriteMolecule cOut = new WriteMolecule(graphOne.getMasterString(), test.getAtomList(), test.getBondList());
		//WriteToJSON cOut = new WriteToJSON(graphOne.getMasterString(), test.getAtomList(), test.getBondList());
		cOut.writing();
		cOut.endWriter();
		
	}
}
