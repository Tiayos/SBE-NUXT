package ec.edu.ups.ins.projections;

import java.util.Date;

public interface IValoresCampoProjection {

    Long getCodigoValorCampoFicha();

    Long getCodigoCampoFicha();

    String getDescripcionCampoFicha();

    String getValorCampoTexto();

    Integer getValorCampoEntero();

    Double getValorCampoDecimal();

    Date getValorCampoFecha();
}
