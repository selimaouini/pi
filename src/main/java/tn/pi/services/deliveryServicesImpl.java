package tn.pi.services;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.protocol.Message;
import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
import tn.pi.entities.Command;

import java.util.Arrays;
import java.util.Date;

import tn.pi.entities.Claim;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryCity;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;
import tn.pi.entities.RoleType;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.deliveryManRepository;
import tn.pi.repositories.deliveryRepository;


@Service
public class deliveryServicesImpl implements deliveryServices {
	
	@Autowired
	deliveryManRepository deliveryManRepository;
	@Autowired
	ICommandRepository commandRepository;
	@Autowired
	deliveryRepository deliveryRepository;
	@Value("+216 26 215 397")
	private String from;

	@Override
	public List<Delivery> retrieveAlldeliveries() {
		deliveryRepository.findAll();
		return (List<Delivery>)deliveryRepository.findAll();
	}
	@Override
	public Delivery addDelivery(Delivery d) {
		d.setDate_delivery(new Date());
		deliveryRepository.save(d);
		return d;
	}
	@Override
	public void deleteDelivery(int id_delivery) {
		deliveryRepository.deleteById(id_delivery);
		
	}
	@Override
	public Delivery updateDelivery(Delivery d) {
		deliveryRepository.save(d);
		return d;
	}
	@Override
	public Delivery retrieveDelivery(int id_delivery) {
		deliveryRepository.findById(id_delivery);
		return deliveryRepository.findById(id_delivery).orElse(null);	}

	@Override
	public void affecterDeliveryManADelivery(int devMan_Id, int delivery_Id) {
		DeliveryMan dm =deliveryManRepository.findById( devMan_Id).orElse(null);
		Delivery d = deliveryRepository.findById(delivery_Id).orElse(null);
		//dm.setDelivery(d);
		//deliveryManRepository.save(d);
		
	}
	
	@Override
	public void AjouterAffecterCalculerDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		
		
		
	}
	@Override
	public void updateState(int id, DeliveryState etat) {
      deliveryRepository.updateState(id, etat);
		
	}
	
	
	
	
	@Override
	public boolean createPdf(List<Delivery> deliveries, ServletContext context,
    HttpServletRequest request, HttpServletResponse response) {
		Document document=new Document(PageSize.A4, 15, 15, 45, 30);
		try{
			
	    String filPath= context.getRealPath("/resources/reports");
	    File file =new File(filPath);
	    boolean exists= new File(filPath).exists();
	    if(!exists){
	    	new File(filPath).mkdirs();
	    }
	    
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"deliveries"+".pdf"));
	    document.open();
	    
       Font mainFont = FontFactory.getFont("Arial",10, BaseColor.BLACK);
	    
	    Paragraph paragraph= new Paragraph("All deliveries", mainFont);
	    paragraph.setAlignment(Element.ALIGN_CENTER);
	    paragraph.setIndentationLeft(50);
	    paragraph.setIndentationRight(50);
	    paragraph.setSpacingAfter(10);
	    document.add(paragraph);
	    
	    
	    PdfPTable table = new PdfPTable(4);
	    table.setWidthPercentage(100);
	    table.setSpacingBefore(10f);
	    table.setSpacingAfter(10);
	    
	    Font tableHeader = FontFactory.getFont("Arial",10, BaseColor.BLACK);
	    Font tableBody = FontFactory.getFont("Arial",9, BaseColor.BLACK);
	    
	    float[] columnWidths = {2f, 2f, 2f, 2f};
	    table.setWidths(columnWidths);
	    
	    PdfPCell description =new PdfPCell(new Paragraph("description", tableHeader));
	    description.setBorderColor(BaseColor.BLACK);
	    description.setPaddingLeft(10);
	    description.setHorizontalAlignment(Element.ALIGN_CENTER);
	    description.setVerticalAlignment(Element.ALIGN_CENTER);
	    description.setBackgroundColor(BaseColor.GRAY);
	    description.setExtraParagraphSpace(5);
	    table.addCell(description);
	    
	    PdfPCell Shippingcost =new PdfPCell(new Paragraph("Shippingcost", tableHeader));
	    Shippingcost.setBorderColor(BaseColor.BLACK);
	    Shippingcost.setPaddingLeft(10);
	    Shippingcost.setHorizontalAlignment(Element.ALIGN_CENTER);
	    Shippingcost.setVerticalAlignment(Element.ALIGN_CENTER);
	    Shippingcost.setBackgroundColor(BaseColor.GRAY);
	    Shippingcost.setExtraParagraphSpace(5);
	    table.addCell(Shippingcost);
	    
	    PdfPCell address =new PdfPCell(new Paragraph("address", tableHeader));
	    address.setBorderColor(BaseColor.BLACK);
	    address.setPaddingLeft(10);
	    address.setHorizontalAlignment(Element.ALIGN_CENTER);
	    address.setVerticalAlignment(Element.ALIGN_CENTER);
	    address.setBackgroundColor(BaseColor.GRAY);
	    address.setExtraParagraphSpace(5);
	    table.addCell(address);
	    
	    PdfPCell city =new PdfPCell(new Paragraph("city", tableHeader));
	    city.setBorderColor(BaseColor.BLACK);
	    city.setPaddingLeft(10);
	    city.setHorizontalAlignment(Element.ALIGN_CENTER);
	    city.setVerticalAlignment(Element.ALIGN_CENTER);
	    city.setBackgroundColor(BaseColor.GRAY);
	    city.setExtraParagraphSpace(5);
	    table.addCell(city);
	    
	    
	    
	     for (Delivery delivery: deliveries){
	    	
	    
	 	    
	 	   PdfPCell ShippingcostValue =new PdfPCell(new Paragraph(delivery.getShippingcost()+"", tableBody));
	 	  ShippingcostValue.setBorderColor(BaseColor.BLACK);
	 	  ShippingcostValue.setPaddingLeft(10);
	 	  ShippingcostValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	  ShippingcostValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	  ShippingcostValue.setBackgroundColor(BaseColor.WHITE);
	 	  ShippingcostValue.setExtraParagraphSpace(5);
	 	   table.addCell(ShippingcostValue);
	 	    
	 	   PdfPCell addressValue =new PdfPCell(new Paragraph(delivery.getAddress(), tableBody));
	 	 addressValue.setBorderColor(BaseColor.BLACK);
	 	 addressValue.setPaddingLeft(10);
	 	 addressValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	 addressValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	 addressValue.setBackgroundColor(BaseColor.WHITE);
	 	 addressValue.setExtraParagraphSpace(5);
	 	  table.addCell(addressValue);
	 	   
	 	 PdfPCell cityValue =new PdfPCell(new Paragraph(delivery.getCity(), tableBody));
	 	 cityValue.setBorderColor(BaseColor.BLACK);
	 	 cityValue.setPaddingLeft(10);
	 	 cityValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	 cityValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	 cityValue.setBackgroundColor(BaseColor.WHITE);
	 	 cityValue.setExtraParagraphSpace(5);
	 	  table.addCell(cityValue);
	 	   
	 	  
	    	 
	     }
	     
	     document.add(table);
	     document.close();
	     writer.close();
	     return true;
	
		}catch (Exception e) {
			return false;
		}
	    
	}
	@Override
	public void sendSms(String to, String from, String body) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String upateStateDeliveryToDelivered(int id_delivery) {
		Delivery c=deliveryRepository.findById(id_delivery).get();
		DeliveryMan ddd=c.getDeliveryMan();
		if(c.getState()!=DeliveryState.AFFECTED){
			return("votre livraison n'est pas encore affectée");}
			else{
				c.setState(DeliveryState.DELIVERED);
			    ddd.setAvailability(true);
				deliveryRepository.save(c);
				deliveryManRepository.save(ddd);
				
		return("Vous avez confirmez votre livraison.. MERCI");
			}
		
	}
	@Override
	public void updateStateDeliveryToAffected(int id_delivery) {
		Delivery c=deliveryRepository.findById(id_delivery).get();
		c.setState(DeliveryState.AFFECTED);
		c.setDate_affectation(new Date());
		deliveryRepository.save(c);
		
		
	}
	@Override
	public String cancelDelivery(int id_delivery) {
		Delivery c=deliveryRepository.findById(id_delivery).get();
		Date dd = c.getDate_affectation();
		
		LocalDateTime dateaffect = dd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime tomorrow = dateaffect.plusDays(1);
		LocalDateTime auj=new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		if(c.getState()== DeliveryState.AFFECTED && auj.compareTo(tomorrow)<0 || c.getState()== DeliveryState.IN_PROGRESS )
		{
			c.setState(DeliveryState.CANCELED );
			deliveryRepository.save(c);
			return ("votre livraison est annulée");
		
	}
		
		else {
			return("Vous ne pouvez pas annuler votre livraison , elle est déja affecté plus que 12h");
		}
		
		
	}
	@Override
	public Delivery addNewDelivery(Delivery delivery, DeliveryCity city, DeliveryState state, DeliveryMan dd) {
		
		switch (delivery.getCity()) {
		
		case "bizerte":
		delivery.setShippingcost(8000);
			break;
		case "tunis":
			delivery.setShippingcost(7000);
			break;
		case "sousse":
			delivery.setShippingcost(9000);
			break;
		case "gabes":
			delivery.setShippingcost(10000);
			break;
			}
			
			DeliveryMan d= deliveryManRepository.getdeliverymanbyworkzone(delivery.getCity());
			
			
			if(d.isAvailability()==false){
				delivery.setState(DeliveryState.IN_PROGRESS);
				
				}
				else{
					delivery.setState(DeliveryState.AFFECTED);
					delivery.setDate_affectation(new Date());
					
				}
			
			delivery.setDate_delivery(new Date());
			d.setNbDelivery(d.getNbDelivery()+1);
			delivery.setDeliveryMan(deliveryManRepository.getdeliverymanbyworkzone(delivery.getCity()));
           
			
		if (d.getNbDelivery()>=10){
			
		d.setPremium((d.getNbDelivery()-10)*3000);
		
		
			
				
		/*		
		String g = delivery.getDeliveryMan().getUser().getTel();
		String s= "+216" + String.valueOf(g);
		deliveryServices.sendSms(s, "+16786079317" , "Vous avez une livraison à l'adresse : (adresse:"+delivery.getAddress()+")");
			}
		*/	
			deliveryRepository.save(delivery);
			
		    
		
  }
		return delivery;
		
	
	
	
	
	
	/*
	@Value("AC8917fe1abcdfd4d222f587709579d1f7")
	private String ACCOUNT_SID;
	@Value("d3c60be3b347947e1dada56764cf4030")
	private String AUTH_TOKEN;
	
	
	public void sendSms(String to,String from,String body) {
		
		try {
		 Twilio.init("AC8917fe1abcdfd4d222f587709579d1f7", "d3c60be3b347947e1dada56764cf4030");
	        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
	            .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
	            .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
	            .create();


		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
	*/

	}
	@Override
	public Delivery addNewDeliveryByCommmad(Delivery delivery, int idCommand) {
switch (delivery.getCity()) {
		

		case "bizerte":
		delivery.setShippingcost(8000);
			break;
		case "tunis":
			delivery.setShippingcost(7000);
			break;
		case "sousse":
			delivery.setShippingcost(9000);
			break;
		case "gabes":
			delivery.setShippingcost(10000);
			break;
			}
			
			DeliveryMan d= deliveryManRepository.getdeliverymanbyworkzone(delivery.getCity());
			
			
			if(d.isAvailability()==false){
				delivery.setState(DeliveryState.IN_PROGRESS);
				
				}
				else{
					delivery.setState(DeliveryState.AFFECTED);
					delivery.setDate_affectation(new Date());
					
				}
			Command dm =commandRepository.findById(idCommand).get();
			delivery.setDate_delivery(new Date());
			d.setNbDelivery(d.getNbDelivery()+1);
			delivery.setDeliveryMan(deliveryManRepository.getdeliverymanbyworkzone(delivery.getCity()));
            delivery.setCommande(dm);
			
		if (d.getNbDelivery()>=10){
			
		d.setPremium((d.getNbDelivery()-10)*3000);
		/*		
		String g = delivery.getDeliveryMan().getUser().getTel();
		String s= "+216" + String.valueOf(g);
		deliveryServices.sendSms(s, "+16786079317" , "Vous avez une livraison à l'adresse : (adresse:"+delivery.getAddress()+")");
			}
		*/	
			deliveryRepository.save(delivery);
			
		    
		
  }
		return delivery;
		
	
	
	}
	}
	
	

