package tn.pi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Claim;

@Repository
public interface claimRepository extends JpaRepository<Claim,Integer> {
	
	
	public List<Claim> findByStateFalse();
	
	@Query("SELECT c FROM Claim c where id_user=:id")
    public List<Claim> getClaimsByUser(@Param("id") int id);
   

	@Modifying
    @Query("UPDATE Claim c SET c.description=:description1 where c.id_claim=:claimId")
    public void updateDescriptionClaimJPQL(@Param("description1")String description, @Param("claimId")int id);
	
	//public List<Decision> findByDecision_stateFalse();
		@Query("select count(c) from Claim c where c.state=false")
		public int countt();
}