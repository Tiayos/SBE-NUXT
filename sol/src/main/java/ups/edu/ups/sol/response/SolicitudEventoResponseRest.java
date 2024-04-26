package ups.edu.ups.sol.response;

public class SolicitudEventoResponseRest extends ResponseRestMetadata {

    private SolicitudEventoResponse solicitudEventoResponse = new SolicitudEventoResponse();

    public SolicitudEventoResponse getSolicitudEventoResponse() {
        return solicitudEventoResponse;
    }

    public void setSolicitudEventoResponse(SolicitudEventoResponse solicitudEventoResponse) {
        this.solicitudEventoResponse = solicitudEventoResponse;
    }

}
