package vn.com.namcat_qlvanban.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_qlvanban.entities.LoaiVanBan;
import vn.com.namcat_qlvanban.entities.VanBan;

public interface LoaiVBRepository extends JpaRepository<LoaiVanBan, String> {
}
