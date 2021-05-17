package tn.pi.repositories;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Product;
import tn.pi.entities.Promotion;
@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer>, JpaRepository<Promotion, Integer> {


}
