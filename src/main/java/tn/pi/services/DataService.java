package tn.pi.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.repositories.ICommandRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@Service

public class DataService {
@Autowired 
ICommandRepository cr ;

  public Map<Integer, Double> getLineChartData() {
      Map<Integer, Double> map = new LinkedHashMap<>();
    
      map.put(1, 5.20);
      map.put(2, 19.63);
      map.put(3, 59.01);
      map.put(4, 450.76);
      map.put(5, 120.4);
      map.put(6, 8.3);
     return map;
  }
}