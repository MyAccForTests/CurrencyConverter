package Requesters;

import java.util.Calendar;

/**
 * Created by Ilua on 13.12.2016.
 */
public abstract class AbstractRequester implements CurrencyRequester{
    private Calendar fromDate;
    private Calendar toDate;

    public AbstractRequester() {
        this.fromDate = Calendar.getInstance();
        this.toDate = Calendar.getInstance();
    }

    public AbstractRequester(Calendar fromDate) {
        this.fromDate = fromDate;
        this.toDate = Calendar.getInstance();
    }

    protected AbstractRequester(Calendar fromDate, Calendar toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Calendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public Calendar getToDate() {
        return toDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }
}
