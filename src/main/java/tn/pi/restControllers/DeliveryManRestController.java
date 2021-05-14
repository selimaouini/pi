package tn.pi.restControllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;
import tn.pi.services.deliveryManServices;


@RestController
public class DeliveryManRestController {

	@Autowired
	deliveryManServices deliveryManServices;
	@Autowired
	private ServletContext context;
	
	
			@PostMapping("/addDeliveryMan")
			@ResponseBody
			public DeliveryMan addDeliveryMan(@RequestBody DeliveryMan dm) {
				return deliveryManServices.addDeliveryMan(dm);
			}
		

	
		@GetMapping("/retrieveAllMen")
		@ResponseBody
		public List<DeliveryMan> getUsers() {
		List<DeliveryMan> list = deliveryManServices.retrieveAlleDliveryMen();
		return list; 
		}
		
		@GetMapping("/getdeliveryManOfMonth")
		@ResponseBody
		public Map<String, Integer> getdeliveryManOfMonth() {
	    Map<String, Integer> ff = deliveryManServices.getdeliveryManOfMonth();
		return ff;
		}
		
		/*
				@GetMapping("/getdeliveryManOfMonth")
				@ResponseBody
				public Map<String, Integer> barGraph() {
				List<DeliveryMan> deliverymen = deliveryManServices.retrieveAlleDliveryMen();
				Map<String, Integer> surveyMap = new LinkedHashMap<>();
				
				for (DeliveryMan deliveryMan: deliverymen){
				surveyMap.put(deliveryMan.getUser().getFirstName(), deliveryMan.getNbDelivery());
				}
				return surveyMap;
				}
		

			*/	
		@DeleteMapping("/deleteDeliveryMan/{id}")
		@ResponseBody
		public void deleteDeliveryMan(@PathVariable("id") int id) {
		deliveryManServices.deleteDeliveryMan(id);
		}
		
		
		@PutMapping("/updateDeliveryMan")
		@ResponseBody
		public DeliveryMan updateDeliveryMan(@RequestBody DeliveryMan dm) {
		return deliveryManServices.updateDeliveryMan(dm);
		}
		
		
		@GetMapping("/createExcel")
		public void createExcel(HttpServletRequest request, HttpServletResponse response){
			List <DeliveryMan> DeliveryMen = deliveryManServices.retrieveAlleDliveryMen();
			boolean isFlag = deliveryManServices.createExcel(DeliveryMen, context, request, response);
			if(isFlag){
	        	String fullPath= request.getServletContext().getRealPath("/resources/reports/"+"agencies"+".xls");
	        	filedownload(fullPath, response,"agencies.xls");
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
		
		
		@PostMapping("/updateAvailibilityToTrue/{id}/")
		@ResponseBody
		public DeliveryMan updateAvailibilityToTrue(@PathVariable("id") int id){
			return deliveryManServices.updateAvailibilityToTrue( id);
			
		}
		
		
		@PutMapping("/updateAvailibilityToFalse/{id}/")
		@ResponseBody
		public DeliveryMan updateAvailibilityToFalse(@PathVariable("id") int id){
			return deliveryManServices.updateAvailibilityToFalse( id);
			
		}
}
