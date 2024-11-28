package vn.com.stanford.workingrestfulapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.stanford.workingrestfulapi.entities.ChuDe;

public interface ChuDeRepository extends JpaRepository<ChuDe, String> {
}
