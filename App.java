
// Rodar o projeto: 
// javac *.java
// java App

public class App {
    public static void main(String[] args) {
        Client client = new Client("Cadu", "carlos.alencar@al.infnet.edu.br");
        Order order = new Order(client, 0.1);
        order.addItem(new OrderItem("Memoria RAM 32BG DDR5", 1, 3500.0));
        order.addItem(new OrderItem("Placa de Video RTX 5070 Ti", 2, 8000.0));
        order.printInvoice();
        order.sendEmail();
    }
}
