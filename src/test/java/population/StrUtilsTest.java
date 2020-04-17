package population;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StrUtilsTest {
	String str = "\"Aruba\",\"ABW\",\"Population, total\",\"SP.POP.TOTL\",\"54211\",\"55438\",\"56225\",\"56695\",\"57032\",\"57360\",\"57715\",\"58055\",\"58386\",\"58726\",\"59063\",\"59440\",\"59840\",\"60243\",\"60528\",\"60657\",\"60586\",\"60366\",\"60103\",\"59980\",\"60096\",\"60567\",\"61345\",\"62201\",\"62836\",\"63026\",\"62644\",\"61833\",\"61079\",\"61032\",\"62149\",\"64622\",\"68235\",\"72504\",\"76700\",\"80324\",\"83200\",\"85451\",\"87277\",\"89005\",\"90853\",\"92898\",\"94992\",\"97017\",\"98737\",\"100031\",\"100834\",\"101222\",\"101358\",\"101455\",\"101669\",\"102046\",\"102560\",\"103159\",\"103774\",\"104341\",\"104872\",\"105366\",\"105845\",\"\",";	
	String missYearStr = "\"Aruba\",\"ABW\",\"Population, total\",\"SP.POP.TOTL\",\"\",\"55438\",\"56225\",\"56695\",\"57032\",\"57360\",\"57715\",\"58055\",\"58386\",\"58726\",\"59063\",\"59440\",\"59840\",\"60243\",\"60528\",\"60657\",\"60586\",\"60366\",\"60103\",\"59980\",\"60096\",\"60567\",\"61345\",\"62201\",\"62836\",\"63026\",\"62644\",\"61833\",\"61079\",\"61032\",\"62149\",\"64622\",\"68235\",\"72504\",\"76700\",\"80324\",\"83200\",\"85451\",\"87277\",\"89005\",\"90853\",\"92898\",\"94992\",\"97017\",\"98737\",\"100031\",\"100834\",\"101222\",\"101358\",\"101455\",\"101669\",\"102046\",\"102560\",\"103159\",\"103774\",\"104341\",\"104872\",\"105366\",\"105845\",\"\",";	 
	String badYearStr = "\"Aruba\",\"ABW\",\"Population, total\",\"SP.POP.TOTL\",\"54211r\",\"55438\",\"56225\",\"56695\",\"57032\",\"57360\",\"57715\",\"58055\",\"58386\",\"58726\",\"59063\",\"59440\",\"59840\",\"60243\",\"60528\",\"60657\",\"60586\",\"60366\",\"60103\",\"59980\",\"60096\",\"60567\",\"61345\",\"62201\",\"62836\",\"63026\",\"62644\",\"61833\",\"61079\",\"61032\",\"62149\",\"64622\",\"68235\",\"72504\",\"76700\",\"80324\",\"83200\",\"85451\",\"87277\",\"89005\",\"90853\",\"92898\",\"94992\",\"97017\",\"98737\",\"100031\",\"100834\",\"101222\",\"101358\",\"101455\",\"101669\",\"102046\",\"102560\",\"103159\",\"103774\",\"104341\",\"104872\",\"105366\",\"105845\",\"\",";	

			
	StrUtils sUtils = new StrUtils();
	
	@Test
	public void testParseWorldBankEntry_notNull() {
		WorldBankEntry entry = sUtils.parseWorldBankEntry(str);
		System.out.println(entry);
		assertNotNull(entry);
		
	}
	@Test
	public void testParseWorldBankEntry_values() {
		WorldBankEntry entry = sUtils.parseWorldBankEntry(str);
		assertEquals(entry.getCountry(), "Aruba");
		assertEquals(entry.getCode(), "ABW");
		assertEquals(entry.getIndicator(), "Population, total");
		assertEquals(entry.getToPopulation(), 105845L);
	}
	@Test
	public void testParseWorldBankEntry_yearArray() {
		WorldBankEntry entry = sUtils.parseWorldBankEntry(str);
		ArrayList<Long> popArr = entry.getPopulation();
		int numOfValues = popArr.size();
		assertEquals(numOfValues, 59);
	}
	
	@Test
	public void testParseWorldBankEntry_missingyearArray() {
		WorldBankEntry entry = sUtils.parseWorldBankEntry(missYearStr);
		ArrayList<Long> popArr = entry.getPopulation();
		int numOfValues = popArr.size();
		assertEquals(numOfValues, 59);
		assertEquals((long)popArr.get(0), -1L);
	}
	
	@Test
	public void testParseWorldBankEntry_badyearArray() {
		WorldBankEntry entry = sUtils.parseWorldBankEntry(badYearStr);
		ArrayList<Long> popArr = entry.getPopulation();
		int numOfValues = popArr.size();
		assertEquals(numOfValues, 59);
		assertEquals((long)popArr.get(0), -1L);
	}
}