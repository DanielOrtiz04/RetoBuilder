import java.util.ArrayList;
import java.util.List;

public class Email {
    private final List<String> destinatarios;
    private final String asunto;
    private final String cuerpo;
    private final List<String> adjuntos;

    private Email(EmailBuilder builder) {
        this.destinatarios = builder.destinatarios;
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
        this.adjuntos = builder.adjuntos;
    }

    public List<String> getDestinatarios() {
        return new ArrayList<>(destinatarios);
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public List<String> getAdjuntos() {
        return new ArrayList<>(adjuntos);
    }

    public static class EmailBuilder {
        private final List<String> destinatarios;
        private String asunto;
        private String cuerpo;
        private final List<String> adjuntos;

        public EmailBuilder() {
            this.destinatarios = new ArrayList<>();
            this.adjuntos = new ArrayList<>();
        }

        public EmailBuilder agregarDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        public EmailBuilder asunto(String asunto) {
            this.asunto = asunto;
            return this;
        }

        public EmailBuilder cuerpo(String cuerpo) {
            this.cuerpo = cuerpo;
            return this;
        }

        public EmailBuilder agregarAdjunto(String adjunto) {
            this.adjuntos.add(adjunto);
            return this;
        }

        public Email build() {
            if (destinatarios.isEmpty()) {
                throw new IllegalStateException("El email debe tener al menos un destinatario.");
            }
            if (asunto == null || asunto.isEmpty()) {
                throw new IllegalStateException("El email debe tener un asunto.");
            }
            if (cuerpo == null || cuerpo.isEmpty()) {
                throw new IllegalStateException("El email debe tener un cuerpo.");
            }
            return new Email(this);
        }
    }
}



