package population;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Methods {

	// Member variables (can be used everywhere in the object)
	private ArrayList<String> arr;
	StrUtils utils = new StrUtils();
	FileUtils fUtils = new FileUtils();
	ArrayList<WorldBankEntry> entryArr = new ArrayList<>();
	DispalyCountriesFrm cFrm;

	// No-argument constructor
	public Methods() {
		arr = fUtils.readFile("./worldBank.txt");

		// parse the number from the string using ";" as marker
		for (int idx = 1; idx < arr.size(); idx++) {
			WorldBankEntry entry = utils.parseWorldBankEntry(arr.get(idx));
			if (entry != null) {
				entryArr.add(entry);
			}
		}
		cFrm = new DispalyCountriesFrm(entryArr);
		//printArrayList(entryArr);
		//Charts chart = new Charts(entryArr);
	}
	
	private void printArrayList(ArrayList<WorldBankEntry> entryArr) {
		for (WorldBankEntry entry : entryArr) {
			System.out.println(entry.toString());
		}
	}

	//public void analyzeOurData() {
		//arr = fUtils.readFile("./population1.txt");

		// parse the number from the string using ";" as marker
		//for (int idx = 0; idx < arr.size(); idx++) {
		//	int population = utils.parseNumber(arr.get(idx));
		//	String country = utils.parseCountry(arr.get(idx));
		//	countryPop.put(country, population);
		//}
		//Charts charts = new Charts(countryPop);
	//}

	/**
	 * @param args
	 */
	// use of String[] args array
	public static void main(String[] args) {
		System.out.println("Hi");
		if (args.length > 0) {
			System.out.println("The first argument is " + args[0]);
		} else {
			System.out.println("You can add arguments");

		}
		// instantiate this class
		new Methods();

	}
}
