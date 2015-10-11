import java.util.*;
public class Tester {
	public static void main(String[] args){
		//MoleculeIUPACtoGraph test = new MoleculeIUPACtoGraph();
		Molecule test = new MoleculeIUPACtoGraph().convertToMolecule();
		System.out.println(test);
		WriteMolecule cOut = new WriteMolecule("2-butene", test.getAtomList(), test.getBondList());
		cOut.writing();
		cOut.endWriter();
	}
}
