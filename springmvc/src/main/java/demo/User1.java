package demo;

import java.util.Collection;
import java.util.HashSet;

public class User1 {

	public static void main(String[] args) {
		HashSet<String> checkdata = new HashSet<String>();
		checkdata.add("第一個");
		checkdata.add("第二個");

		for (String iString : checkdata) {
			System.out.println(iString);

		}

		HashSet<String> orgindata = new HashSet<String>();
		orgindata.add("qwerqwreqr");
		orgindata.add("1234gfewgr");
		orgindata.add("eeerterw");
		orgindata.addAll(checkdata);

		for (String oString : orgindata) {
			System.out.println(oString);
		}

	}

//	public static void testSet() {
//		HashSet<String> orgindata = new HashSet<String>();
//		orgindata.add("qwerqwreqr");
//		orgindata.add("1234gfewgr");
//		orgindata.add("eeerterw");
//
//	}

}
