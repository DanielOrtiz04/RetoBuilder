public class Main {
    public static void main(String[] args) {
        Email email = new Email.EmailBuilder()
                .agregarDestinatario("dortizc13@miumg.edu.gt")
                .agregarDestinatario("dortizc13@miumg.edu.gt")
                .asunto("Prueba de Email Builder")
                .cuerpo("Este es un correo de prueba utilizando el patrón Builder.")
                .agregarAdjunto("documento1.pdf")
                .agregarAdjunto("imagen1.jpg")
                .build();

        System.out.println("Destinatarios: " + email.getDestinatarios());
        System.out.println("Asunto: " + email.getAsunto());
        System.out.println("Cuerpo: " + email.getCuerpo());
        System.out.println("Adjuntos: " + email.getAdjuntos());
    }
}