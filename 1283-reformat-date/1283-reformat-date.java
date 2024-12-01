class Solution {
    public String reformatDate(String date) {
        HashMap<String,String>months = new HashMap<>();
        months.put("Jan","01");
        months.put("Feb","02");
        months.put("Mar","03");
        months.put("Apr","04");
        months.put("May","05");
        months.put("Jun","06");
        months.put("Jul","07");
        months.put("Aug","08");
        months.put("Sep","09");
        months.put("Oct","10");
        months.put("Nov","11");
        months.put("Dec","12");
        String[] str = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(str[2]);
        sb.append("-");
        sb.append(months.get(str[1]));
        sb.append("-");
        int num=0;
        for(char ch:str[0].toCharArray()){
            if(!Character.isDigit(ch)){
                break;
            }
            num = num*10 + ch-'0';
        }
        if(num < 10){
            sb.append("0");
        }
        sb.append(String.valueOf(num));
        return sb.toString();
    }
}