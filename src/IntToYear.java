

public class IntToYear {
    public static void main(String[] args) {
        int year = 2000;
        int dayNum = 327;
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"yan", "feb", "mar", "apr", "may", "yun", "yul", "aug", "sep", "okt", "nov", "dec"};
        int monthNum = 0;
        boolean isLeapYear = false;

        if ((year%4==0) && (year%100!=0 || year%400==0)) {
            isLeapYear = true;
            System.out.println("It is leap year! " + isLeapYear);
        };

        for(int days : daysInMonths) {
          if(isLeapYear && monthNum == 1) {
              days = 29;
          }

          if (dayNum <= days) {
              break;
          } else {
              dayNum = dayNum - days;
              monthNum++;
          }
        }

        System.out.println("Month " + months[monthNum] + ", day " + dayNum);
    }
}