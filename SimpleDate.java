package ferry;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public static SimpleDate parseDMY(String sDate) {
        String parts[] = sDate.split("-");
        if (parts.length < 3)
            return null;
        try {
            return new SimpleDate(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
        }
        catch (Exception ex)
        { return null; }
    }
    
    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String format() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public String toString() {
        return "Date{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }
}
