
// Rodar o projeto: 
// java *.java
// java App

public class App {
    public static void main(String[] args) {
        Order order = new Order("Cadu", "carlos.alencar@al.infnet.edu.br", 0.1);
        order.addItem(new OrderItem("Memoria RAM 32BG DDR5", 1, 3500.0));
        order.addItem(new OrderItem("Placa de Video RTX 5070 Ti", 2, 8000.0));
        order.printInvoice();
        order.sendEmail();
    }
}
