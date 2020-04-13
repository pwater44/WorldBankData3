package population;

import java.util.ArrayList;

public class StrUtils {
	public WorldBankEntry parseWorldBankEntry(String str) {
		WorldBankEntry entry = null;
		int loc = str.lastIndexOf("\","); // looking for last ",
		if (loc > 1) {
			str = str.substring(1, loc);
			String[] arr = str.split("\",\""); // ","
			String country = arr[0];
			String code = arr[1];
			String indicator = arr[2];
			//System.out.println("arr size = " + arr.length);
			// the 62 value is for 2018
			ArrayList<Long> popArr = parseDataByYear(arr);
			try {
				long population = Long.parseLong(arr[arr.length - 1]);
				entry = new WorldBankEntry(country, code, indicator, population, popArr);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return entry;
	}

	private ArrayList<Long> parseDataByYear(String[] arr) {
		ArrayList<Long> arrList = new ArrayList<Long>();
		for (int i=4; i<arr.length; i++) {
			try {
				long val = Long.parseLong(arr[i]);
				arrList.add(val);
			} catch (NumberFormatException e) {
				arrList.add(-1L);
			//	System.out.println("Country: " + arr[0]);
			//	System.out.println("parseDataByYear: on value = " + i);
			}
		}	
		return arrList;
		
	}

	/**
	 * parseNumber - assume string has : marker and number follows with no other
	 * text
	 * 
	 * @param string - of the form text: number (with nothing following)
	 * @return number
	 */
	StrUtils utils;

	public int parseNumber(String string) {
		// find ":" in the string and get the index
		int loc = string.indexOf(':');
		if (loc >= 0) {
			String tmp = string.substring(loc + 1).trim().replaceAll(",", "");
			int pop = Integer.parseInt(tmp);

			return pop;
		} else {
			System.out.println("Did not find : marker");
			return -1;
		}
	}

	/**
	 * parseCountry - assume string has : marker and country is word before :
	 * 
	 * @param string
	 * @return country
	 */
	public String parseCountry(String string) {
		// parse the country out of the string
		int loc = string.indexOf(':');
		string = string.substring(0, loc);
		loc = string.lastIndexOf(' ');
		string = string.substring(loc);
		string = string.trim();
		return string;
		// "This is the population for the Japan: 126,000,000"
	}
}
