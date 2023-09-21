import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
	   // return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
        return Math.abs(totalDays(date1)-totalDays(date2));
        
    }
    public int totalDays(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int days = Integer.parseInt(date.substring(8,10));
        int[] monthsDays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<month-1;i++){
            days+= (monthsDays[i]);
        }
        //If we are in 2011 year and second month we need to count 365 days till 2010 only
        days+= ((year-1)*365);
        // from 1971 every four years we get leap year so number of leap year equals = number of one extra day day of feb  
        days+=  (year-1)/4;
        if(year%4 ==0 && month >2 && year!=2100) days++;
        return days;
    }
}