package ec.edu.ups.ins.repository;
import ec.edu.ups.ins.entity.model.sbe.SbeInstruccionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SbeInstruccionDao extends JpaRepository<SbeInstruccionModel, Long> {
}
