package com.coin.manager.repository;

import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.entity.ExternalWriterKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExternalWriterRepository extends JpaRepository<ExternalWriter, Long> {

    boolean existsById(ExternalWriterKey id);
    @Query(value = "SELECT * FROM external_writer WHERE member_email = :memberEmail", nativeQuery = true)
    List<ExternalWriter> findByMemberEmail(String memberEmail);
    @Query(value = "SELECT * FROM external_writer " +
                    "WHERE member_email = :memberEmail AND external_site_code = :externalSiteCode", nativeQuery = true)
    List<ExternalWriter> findByMemberMemberEmailAndExternalSiteCode(String memberEmail, String externalSiteCode);
}
