public class Ticket {
    private int id;
    private String destination;
    private double price;
    private int available;

    public Ticket(int id, String destination, double price, int available) {
        this.id = id;
        this.destination = destination;
        this.price = price;
        this.available = available;
    }

    
    public int getId() { 
        return id; 
    }

    public String getDestination() {
        return destination; 
    }

    public double getPrice() { 
        return price; 
    }

    public int getAvailable() { 
        return available; 
    }
}
