package tn.pi.restControllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryCity;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;
import tn.pi.entities.PdfGenaratorUtil;
import tn.pi.entities.RoleType;
import tn.pi.entities.User;
import tn.pi.repositories.UserRepository;
import tn.pi.repositories.deliveryManRepository;
import tn.pi.repositories.deliveryRepository;
import tn.pi.services.deliveryServices;




@RestController
@CrossOrigin("*")
public class DeliveryRestController {

	@Autowired 
	public deliveryServices deliveryServices;
	@Autowired 
	public deliveryRepository deliveryRepository;
	@Autowired 
	public deliveryManRepository deliveryManRepository;
	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private PdfGenaratorUtil util;
	@RequestMapping("/generatePDF")
	public String getPDFView(Model model) throws Exception {
		util.createPdf("greeting", null);
		model.addAttribute("message", "PDF Downloaded successfully..");
		return "test";
	}
	
	
	@Value("+216 26 215 397")
	private String from;

	
	
				@PostMapping("/addDelivery")
				@ResponseBody
				public Delivery addDelivery(@RequestBody Delivery d) {
					return deliveryServices.addDelivery(d);
					
					
				}


		
			@GetMapping("/retrieveAlldeliveries")
			@ResponseBody
			public List<Delivery> getDeliveries() {
			List<Delivery> list = deliveryServices.retrieveAlldeliveries();
			return list; 
			}
			
			
			

	
			
			@DeleteMapping("/deleteDelivery/{id_delivery}")
			@ResponseBody
			public void deleteDeliveryMan(@PathVariable("id_delivery") int id) {
			deliveryServices.deleteDelivery(id);
			}
			
			
		
			
			@PutMapping("/upateStateDeliveryToDelivered/{id_delivery}")
			@ResponseBody
			public String upateStateDeliveryToDelivered(@PathVariable("id_delivery") int id) {
			return deliveryServices.upateStateDeliveryToDelivered(id);
			}

			@PutMapping("/updateDelivery")
			@ResponseBody
			public Delivery updateDelivery(@RequestBody Delivery d) {
			return deliveryServices.updateDelivery(d);
			}
			
			/*
			@PutMapping("/updateStateDeliveryToAffected/{id_delivery}")
			@ResponseBody
			public void updateStateDeliveryToAffected(@PathVariable("id_delivery") int id) {
			return deliveryServices.updateStateDeliveryToAffected(id);
			}
			*/

			@PutMapping("/cancelDelivery/{id_delivery}")
			@ResponseBody
			public String cancelDelivery(@PathVariable("id_delivery") int id) {
			return deliveryServices.cancelDelivery(id);
			}


		
			
			
			
			@PostMapping(value = "addNewDelivery")
			@ResponseBody
			public Delivery addNewDelivery(@RequestBody Delivery delivery ,  DeliveryCity city, DeliveryState state,DeliveryMan dd) {
				return deliveryServices.addNewDelivery(delivery,city,state,dd); 
				
			
      }
			@PostMapping(value = "addNewDeliveryByCommand/{id_command}")
			@ResponseBody
			public Delivery addNewDeliveryByCommand(@RequestBody Delivery delivery ,@PathVariable("id_command") int idCommand) {
				return deliveryServices.addNewDeliveryByCommmad(delivery,idCommand); 
				
			
			}
			
			 
			
			/*
			@PutMapping(value = "updateEtat/{id}")
			
			public String updateState(@PathVariable int id ,  @RequestBody DeliveryState etat ) {
				
				Delivery delivery = deliveryRepository.findById((long) id).get();
				if(delivery.getState()==etat)
				{
					return"Etat is already :"+etat;
				}
				
				deliveryServices.updateState(id, etat);
				
			
				System.out.println("etat was changed");
				return"etat was changed to : "+etat;
				//return delivery;

			}
			*/
			
			
			
			 @GetMapping(value ="/createPdf")
			 
				public void createPdf (HttpServletRequest request, HttpServletResponse response){
					List <Delivery> deliviries = deliveryServices.retrieveAlldeliveries();
					boolean isFlag = deliveryServices.createPdf(deliviries, context, request, response);
					 if(isFlag){
				        	String fullPath= request.getServletContext().getRealPath("/resources/reports/"+"deliviries"+".pdf");
				        	filedownload(fullPath, response,"deliviries.pdf");
				        }
				}


			
			 
			
            private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
				
				File file = new File(fullPath);
				final int BUFFER_SIZE =4096;
				
				if(file.exists()){
					try{
						FileInputStream inputStream =new FileInputStream(file);
						String mimeType =context.getMimeType(fullPath);
						response.setContentType(mimeType);
						response.setHeader("content-disposition", "attachement; fileName="+ fileName);
						OutputStream outputStream = response.getOutputStream();
						byte[] buffer = new byte[BUFFER_SIZE];
						int bytesRead = -1;
						while((bytesRead = inputStream.read(buffer))!= -1){
							outputStream.write(buffer, 0, bytesRead);
						}
						inputStream.close();
						outputStream.close();
						file.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				
			}

		}
            
            
           
			
            
}
