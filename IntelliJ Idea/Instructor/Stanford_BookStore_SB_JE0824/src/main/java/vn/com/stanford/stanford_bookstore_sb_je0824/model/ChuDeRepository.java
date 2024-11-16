package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;

public interface ChuDeRepository extends JpaRepository<ChuDe, String> {

    //Declare extension function if needed
}
