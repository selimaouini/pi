package tn.pi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}