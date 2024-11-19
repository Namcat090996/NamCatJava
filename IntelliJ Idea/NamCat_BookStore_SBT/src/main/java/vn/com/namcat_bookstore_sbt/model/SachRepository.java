package vn.com.namcat_bookstore_sbt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_bookstore_sbt.entities.Sach;

public interface SachRepository extends JpaRepository<Sach, String> {
}
