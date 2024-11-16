package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;

public interface SachRepository extends JpaRepository<Sach, String> {

    //Declare extension function if needed
}
