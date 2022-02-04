package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 27/12/2021, Monday, 10:52
 */
public class FindMonths {
	private static Integer getMonthsforOpportunityTerms(String termPeriod) {
		Integer month = 12;
		if(termPeriod.contains("month")){
			String strMonth =  termPeriod.split(" ")[0];
			if(strMonth != null && !strMonth.equals("")){
				month = Integer.parseInt(strMonth);
			}
		}else{
			String reg[] = termPeriod.split("\\s+");
			if (reg.length > 0) {
				month = Integer.valueOf(reg[0]);
				month=month*12;
			}
		}
		return month;
	}

	public static void main(String[] args) {
		System.out.println(getMonthsforOpportunityTerms("36 months"));
	}
}
