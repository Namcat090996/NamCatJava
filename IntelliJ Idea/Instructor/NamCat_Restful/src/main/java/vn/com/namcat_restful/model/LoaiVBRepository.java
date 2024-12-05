package vn.com.namcat_restful.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_restful.entities.LoaiVanBan;

public interface LoaiVBRepository extends JpaRepository<LoaiVanBan, String> {
}
