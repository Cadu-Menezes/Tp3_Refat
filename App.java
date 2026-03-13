
// Rodar o projeto: 
// java *.java
// java App

public class App {
    public static void main(String[] args) {
        Order order = new Order("João", "joao@email.com", 0.1);
        order.addItem(new OrderItem("Notebook", 1, 3500.0));
        order.addItem(new OrderItem("Mouse", 2, 80.0));
        order.printInvoice();
        order.sendEmail();
    }
}
