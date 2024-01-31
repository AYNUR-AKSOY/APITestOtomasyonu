package Pojos;

public class PojoHerokuappResponseBody {

    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public PojoHerokuappResponseBody() {
    }

    public PojoHerokuappResponseBody(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "PojoHerokuappResponse{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
