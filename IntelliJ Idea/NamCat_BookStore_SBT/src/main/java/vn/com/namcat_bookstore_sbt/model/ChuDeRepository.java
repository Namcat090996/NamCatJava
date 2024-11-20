package vn.com.namcat_bookstore_sbt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;

public interface ChuDeRepository extends JpaRepository<ChuDe, String> {

    //Declare extension function if needed
}
