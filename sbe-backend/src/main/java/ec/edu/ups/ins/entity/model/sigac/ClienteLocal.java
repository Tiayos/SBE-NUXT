package ec.edu.ups.ins.entity.model.sigac;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE_LOCAL", schema = "SIGAC")
public class ClienteLocal {

    @Id
    @Column(name = "CLLC_CDG")
    private Long cllcCdg;

    @Column(name = "CLLC_NMB")
    private String  cllcNmb;

    @Column(name = "CLLC_RUT")
    private String cllcRut;

    @Column(name = "CLLC_RUT_DV")
    private String cllcRutDv;

    @Column(name = "CLLC_CALLE")
    private String cllcCalle;

    @Column(name = "CLLC_NMR")
    private String cllcNmr;

    @Column(name = "CMNS_CDG")
    private String cmnsCdg;

    @Column(name = "CDDS_CDG")
    private String cddsCdg;

    @Column(name = "CLLC_RUC")
    private String cllcRuc;

    public ClienteLocal() {
    }

    public ClienteLocal(Long cllcCdg) {
        this.cllcCdg = cllcCdg;
    }

    public ClienteLocal(Long cllcCdg, String cllcNmb, String cllcRut,
                        String cllcRutDv, String cllcCalle, String cllcNmr,
                        String cmnsCdg, String cddsCdg, String cllcRuc) {
        this.cllcCdg = cllcCdg;
        this.cllcNmb = cllcNmb;
        this.cllcRut = cllcRut;
        this.cllcRutDv = cllcRutDv;
        this.cllcCalle = cllcCalle;
        this.cllcNmr = cllcNmr;
        this.cmnsCdg = cmnsCdg;
        this.cddsCdg = cddsCdg;
        this.cllcRuc = cllcRuc;
    }

    public String getCllcRuc() {
        return cllcRuc;
    }

    public void setCllcRuc(String cllcRuc) {
        this.cllcRuc = cllcRuc;
    }

    public Long getCllcCdg() {
        return cllcCdg;
    }

    public void setCllcCdg(Long cllcCdg) {
        this.cllcCdg = cllcCdg;
    }

    public String getCllcNmb() {
        return cllcNmb;
    }

    public void setCllcNmb(String cllcNmb) {
        this.cllcNmb = cllcNmb;
    }

    public String getCllcRut() {
        return cllcRut;
    }

    public void setCllcRut(String cllcRut) {
        this.cllcRut = cllcRut;
    }

    public String getCllcRutDv() {
        return cllcRutDv;
    }

    public void setCllcRutDv(String cllcRutDv) {
        this.cllcRutDv = cllcRutDv;
    }

    public String getCllcCalle() {
        return cllcCalle;
    }

    public void setCllcCalle(String cllcCalle) {
        this.cllcCalle = cllcCalle;
    }

    public String getCllcNmr() {
        return cllcNmr;
    }

    public void setCllcNmr(String cllcNmr) {
        this.cllcNmr = cllcNmr;
    }

    public String getCmnsCdg() {
        return cmnsCdg;
    }

    public void setCmnsCdg(String cmnsCdg) {
        this.cmnsCdg = cmnsCdg;
    }

    public String getCddsCdg() {
        return cddsCdg;
    }

    public void setCddsCdg(String cddsCdg) {
        this.cddsCdg = cddsCdg;
    }
}
