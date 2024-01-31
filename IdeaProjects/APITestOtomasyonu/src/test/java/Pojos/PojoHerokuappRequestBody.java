package Pojos;

public class PojoHerokuappRequestBody {

   private String firstname;
   private String lastname;
   private int totalprice;
   private boolean depositpaid;
   private String additionalneeds;
   private PojoHerokuappBookingDates bookingdates;

    public PojoHerokuappRequestBody() {
    }

    public PojoHerokuappRequestBody(String firstname, String lastname, int totalprice,
    boolean depositpaid, String additionalneeds, PojoHerokuappBookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public PojoHerokuappBookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerokuappBookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
