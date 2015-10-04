import java.util.*;
public class Tester {
	public static void main(String[] args){
		//MoleculeIUPACtoGraph test = new MoleculeIUPACtoGraph();
		Molecule test = new MoleculeIUPACtoGraph().convertToMolecule();
		System.out.println(test);
	}
}
