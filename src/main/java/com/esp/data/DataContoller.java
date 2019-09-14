package com.esp.data;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esp.service.UserService;


@RestController
public class DataContoller {

@Autowired	
private DataRepository dataRepository;

@Autowired
private UserService userService; 

@GetMapping("/data")
public List<Data> getAllDatas() {
	return dataRepository.findAll();
}

@GetMapping("/data/{id}")
Data getDataById(@PathVariable String id) {
return dataRepository.findById(id).get();
}

//@PostMapping("/data/{userId}")
//public Data createData(
		//@PathVariable(value= "userId") String userId,
		//@Valid @RequestBody Data data) {
	
	//return userService.findById(userId).map(user -> {
		//data.setUser(user);
		//return dataRepository.save(data);
	//}).orElseThrow(() -> new ResourceNotFoundException("userId" + userId + "not found"));
//}



@PostMapping("/data")
Data createOrSaveData(@RequestBody Data newData) {
	return dataRepository.save(newData);
}


@PutMapping("/data/{id}")
Data updateData(@RequestBody Data newData, @PathVariable String id) {
	
	return dataRepository.findById(id).map(data -> {
		data.setNumber(newData.getNumber());
		data.setCaller(newData.getCaller());
		data.setCategory(newData.getCategory());
		data.setSubCategory(newData.getSubCategory());
		data.setBusinessService(newData.getBusinessService());
		data.setConfigurationItem(newData.getConfigurationItem());
		data.setContactType(newData.getContactType());
		data.setState(newData.getState());
		data.setImpact(newData.getImpact());
		data.setUrgency(newData.getUrgency());
		data.setPriority(newData.getPriority());
		data.setAssignmentGroup(newData.getAssignmentGroup());
		data.setAssignedTo(newData.getAssignedTo());
		data.setCloseCode(newData.getCloseCode());
		data.setCloseNotes(newData.getCloseNotes());
		return dataRepository.save(data);
	}).orElseGet(() -> {
		newData.setId(id);
		return dataRepository.save(newData);
	});
}
@DeleteMapping("data/{id}")
	void deleteData(@PathVariable String id) {
	dataRepository.deleteById(id);
}
}
