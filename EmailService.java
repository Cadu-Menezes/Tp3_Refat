public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }

    public void sendOrderConfirmation(String to) {
        sendEmail(to, "Pedido recebido! Obrigado pela compra.");
    }
}
