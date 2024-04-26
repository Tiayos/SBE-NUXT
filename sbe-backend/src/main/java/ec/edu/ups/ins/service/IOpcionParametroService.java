package ec.edu.ups.ins.service;

import ec.edu.ups.ins.entity.dto.SbeOpcionParametroFichaDTO;

import java.util.List;

public interface IOpcionParametroService {

     List<SbeOpcionParametroFichaDTO> getOpcionesParametroByCodigo(Long codigo);


}
