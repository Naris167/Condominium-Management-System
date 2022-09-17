package Week_4;

class TicketBookingByAgent implements TravelBooking {
    TravelBooking t;
    public TicketBookingByAgent(TravelBooking t) {
        this.t = t;
    }
    // Delegation --- Here ticket booking responsibility
    // is delegated to other class using polymorphism
    @Override
    public void bookTicket() {
        t.bookTicket();
    }
}
