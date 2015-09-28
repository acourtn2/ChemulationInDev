import java.util.*;
public class Tester {
	public static void main(String[] args){
		Molecule test = new Molecule();
		Atom testAtom = new Atom(1,1,1.008, 0, "Hydrogen");
		Atom testAtom3 = new Atom(3,3,3.008, 2, "NotHydrogen");
		Atom testAtom2 = new Atom();
		Bond bondOne = new Bond(1,1, true, 1.05);
		Bond bondTwo = new Bond();
		
		test.addAtom(testAtom);
		test.addAtom(testAtom3);
		test.addBond(bondOne);
		test.addBond(bondTwo);
		System.out.print(test);
	}
}
