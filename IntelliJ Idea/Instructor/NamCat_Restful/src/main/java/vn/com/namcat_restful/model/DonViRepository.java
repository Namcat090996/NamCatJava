package vn.com.namcat_restful.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_restful.entities.DonVi;

public interface DonViRepository extends JpaRepository<DonVi, String> {
}
