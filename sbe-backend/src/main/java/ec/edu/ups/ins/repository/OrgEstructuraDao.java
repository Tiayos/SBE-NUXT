package ec.edu.ups.ins.repository;

import ec.edu.ups.ins.entity.model.org.Estructura;
import ec.edu.ups.ins.projections.DatosDomicilioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrgEstructuraDao extends JpaRepository<Estructura, Long> {

    @Query(nativeQuery = true, value = "select arg_codigo as codigoPaises, arg_nombre as paises\n" +
            "from ORG.org_area_geografica arg\n" +
            "where arg.arg_codigo_padre is null\n" +
            "      and arg.tag_codigo=1 order by arg.arg_nombre")
    List<DatosDomicilioProjection> getPaises();

    @Query(nativeQuery = true, value="select argc.arg_codigo as codigoCiudad, argc.arg_nombre as ciudad\n" +
            "from ORG.org_area_geografica arg,     \n" +
            "     ORG.org_area_geografica argr,     \n" +
            "     ORG.org_area_geografica argp,     \n" +
            "     ORG.org_area_geografica argc\n" +
            "where arg.arg_codigo=argr.arg_codigo_padre\n" +
            "and argr.arg_codigo=argp.arg_codigo_padre\n" +
            "and argp.arg_codigo=argc.arg_codigo_padre\n" +
            "and arg.arg_codigo=?1 order by argp.arg_nombre")
    List<DatosDomicilioProjection> getCiudades(Long codigoPais);

    @Query(nativeQuery = true, value = "select argpr.arg_codigo as codigoParroquia, argpr.arg_nombre as parroquias\n" +
            "from ORG.org_area_geografica arg,     \n" +
            "     ORG.org_area_geografica argr,     \n" +
            "     ORG.org_area_geografica argp,     \n" +
            "     ORG.org_area_geografica argc,\n" +
            "     ORG.org_area_geografica argpr\n" +
            "where arg.arg_codigo=argr.arg_codigo_padre\n" +
            "and argr.arg_codigo=argp.arg_codigo_padre\n" +
            "and argp.arg_codigo=argc.arg_codigo_padre\n" +
            "and argc.arg_codigo=argpr.arg_codigo_padre\n" +
            "and argc.arg_codigo=?1 order by argpr.arg_nombre\n")
    List<DatosDomicilioProjection> getParroquias(Long codigoCiudad);
}
