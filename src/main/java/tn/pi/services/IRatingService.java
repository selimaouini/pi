package tn.pi.services;


import tn.pi.entities.Rating;

public interface IRatingService {
	public String addRatingPub(int idUser,int idPromotion,Rating rat);
	public String updateRatingPub(Rating ratPub);
	public float getAvgRat();
	public float getValueRatingByPublicationAndUser(int idPromotion,int idUser);


}