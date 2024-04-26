package ups.edu.ups.sol.projection;

import lombok.extern.java.Log;

import java.time.LocalDate;

public interface FichaAmpliadaProjection {

    Long getFisCodigo();

    Long getPelCodigo();

    String getPelDescripcion();

    String getNivelBeca();

    Long getPuntosFicha();

}
