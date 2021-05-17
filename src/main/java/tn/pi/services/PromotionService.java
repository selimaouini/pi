package tn.pi.services;
import java.util.List;
import tn.pi.entities.Promotion;
import tn.pi.entities.Rating;

public interface PromotionService {
	public int addPromos(Promotion p);
	public void updatePromos(Promotion p, int idProduct);
	public int deletePromos(int idPromotion);
	public Promotion getPromosById(int idPromotion);
	public List<Promotion> getAllPromos();
	public List<Promotion > getPromosByDate();
	public void affecterProductPromotion(int idproduct,int idpromotion);
	public void proposePromos(Promotion p) ;
	public String discountProductPromotion(int id);
	String addPromos(Promotion p, int prodId);
	Rating addEv(Rating e, Integer id);
}
