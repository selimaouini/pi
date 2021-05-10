package tn.pi.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.Claim;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;
import tn.pi.entities.User;
import tn.pi.repositories.deliveryManRepository;

@Service 
public class deliveryManServicesImpl implements deliveryManServices {
	
	@Autowired
	deliveryManRepository deliveryManRepository;
	
	
	/*
	@Override
	public List<DeliveryMan> getdeliveryManOfMonth() {
		deliveryManRepository.getdeliveryManOfMonth();
		return (List<DeliveryMan>)deliveryManRepository.getdeliveryManOfMonth();
	}
	*/
	@Override
	public DeliveryMan addDeliveryMan(DeliveryMan u) {
		deliveryManRepository.save(u);
		return u;
	}
	
	@Override
	public void deleteDeliveryMan(int id) {
		deliveryManRepository.deleteById(id);
		
	}
	
	@Override
	public DeliveryMan updateDeliveryMan(DeliveryMan dm) {
		deliveryManRepository.save(dm);
		return dm;
	}
	@Override
	public DeliveryMan retrieveDeliveryMan(int id) {
		deliveryManRepository.findById(id);
		return deliveryManRepository.findById(id).orElse(null);
	}

/*

	@Override
	public boolean createExcel(List<DeliveryMan> DeliveryMen, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		
		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();
		if(!exists){
			new File(filePath).mkdir();
			
		}
		
		try{
			
			FileOutputStream outputStream = new FileOutputStream(file +"/"+"DeliveryMen"+".xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet workSheet = workbook.createSheet("DeliveryMen");
			workSheet.setDefaultColumnWidth(30);
			HSSFCellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			HSSFRow headerRow = workSheet.createRow(0);
			
			HSSFCell id_deliveryMan = headerRow.createCell(0);
			id_deliveryMan.setCellValue("id_deliveryMan");
			id_deliveryMan.setCellStyle(headerCellStyle);
			
			HSSFCell name = headerRow.createCell(1);
			name.setCellValue("name");
			name.setCellStyle(headerCellStyle);
			
			HSSFCell workZone = headerRow.createCell(2);
			workZone.setCellValue("workZone");
			workZone.setCellStyle(headerCellStyle);
			
			HSSFCell premium = headerRow.createCell(3);
			premium.setCellValue("premium");
			premium.setCellStyle(headerCellStyle);
			
			HSSFCell Tel = headerRow.createCell(4);
			Tel.setCellValue("Tel");
			Tel.setCellStyle(headerCellStyle);
			
			HSSFCell nbDelivery = headerRow.createCell(5);
			nbDelivery.setCellValue("nbDelivery");
			nbDelivery.setCellStyle(headerCellStyle);
			
			int i=1;
			for(DeliveryMan deliveryman : DeliveryMen){
				
				HSSFRow bodyRow =workSheet.createRow(i);
				HSSFCellStyle bodyCelleStyle = workbook.createCellStyle();
				bodyCelleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
				
				HSSFCell Id_deliveryManValue = bodyRow.createCell(0);
				Id_deliveryManValue.setCellValue(deliveryman.getId_deliveryMan());
				Id_deliveryManValue.setCellStyle(bodyCelleStyle);
				
				HSSFCell NameValue = bodyRow.createCell(1);
				NameValue.setCellValue(deliveryman.getUser().getFirstName());
				NameValue.setCellStyle(bodyCelleStyle);
				
				HSSFCell workZoneValue = bodyRow.createCell(2);
				workZoneValue.setCellValue(deliveryman.getUser().getWorkZone());
				workZoneValue.setCellStyle(bodyCelleStyle);
				
				HSSFCell premiumValue = bodyRow.createCell(3);
				premiumValue.setCellValue(deliveryman.getPremium());
				premiumValue.setCellStyle(bodyCelleStyle);
				
				HSSFCell TelValue = bodyRow.createCell(4);
				TelValue.setCellValue(deliveryman.getUser().getTel());
				TelValue.setCellStyle(bodyCelleStyle);
				
				HSSFCell nbDeliveryValue = bodyRow.createCell(5);
				nbDeliveryValue.setCellValue(deliveryman.getNbDelivery());
				nbDeliveryValue.setCellStyle(bodyCelleStyle);
				
				i++;
				 
			}
			
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			return true;
			
		}catch (Exception e) {
			return false;
		}
	
	}

	*/

	@Override
	public DeliveryMan updateAvailibilityToTrue( int id) {
		DeliveryMan c = deliveryManRepository.findById(id).get();
		c.setAvailability(true);
		return deliveryManRepository.save(c);
		
	}
		
	

	@Override
	public DeliveryMan updateAvailibilityToFalse( int id) {
		DeliveryMan c = deliveryManRepository.findById( id).get();
		c.setAvailability(false);
		return deliveryManRepository.save(c);
		
	}

	@Override
	public boolean createExcel(List<DeliveryMan> DeliveryMen, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Map<String, Integer> getdeliveryManOfMonth() {
		
		deliveryManRepository.findAll();
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		DeliveryMan deliverymen= new DeliveryMan();
		
		surveyMap.put(deliverymen.getFirstName(), deliverymen.getNbDelivery());
		
		return surveyMap;
		}

	@Override
	public List<DeliveryMan> retrieveAlleDliveryMen() {
		deliveryManRepository.findAll();
		return (List<DeliveryMan>)deliveryManRepository.findAll();
		
	}

	@Override
	public DeliveryMan getById(int id) {
		return deliveryManRepository.findById(id).get();
		
	}
	}


	
	
	

	

	



	
	
