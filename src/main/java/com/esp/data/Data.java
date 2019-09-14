package com.esp.data;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "data")
public class Data  implements Serializable{
	
private static final long serialVersionUID = 1L;

@Id
@Column(name = "DataID")
@GeneratedValue(generator="system-uuid")
@GenericGenerator(name="system-uuid", strategy = "uuid")

private String  id;
private String number;
private String caller;
private String category;
private String subCategory;
private String businessService;
private String configurationItem;
private String contactType;
private String state;
private String impact;
private String urgency;
private String priority;
private String assignmentGroup;
private String assignedTo;
private String shortDescription;
private String closeCode;
private String closeNotes;


public Data() {
	super();
}



public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}



public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getCaller() {
	return caller;
}

public void setCaller(String caller) {
	this.caller = caller;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getSubCategory() {
	return subCategory;
}

public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}

public String getBusinessService() {
	return businessService;
}

public void setBusinessService(String businessService) {
	this.businessService = businessService;
}

public String getConfigurationItem() {
	return configurationItem;
}

public void setConfigurationItem(String configurationItem) {
	this.configurationItem = configurationItem;
}

public String getContactType() {
	return contactType;
}

public void setContactType(String contactType) {
	this.contactType = contactType;
}

public String getState() {	
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getImpact() {
	return impact;
}

public void setImpact(String impact) {
	this.impact = impact;
}

public String getUrgency() {
	return urgency;
}

public void setUrgency(String urgency) {
	this.urgency = urgency;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getAssignmentGroup() {
	return assignmentGroup;
}

public void setAssignmentGroup(String assignmentGroup) {
	this.assignmentGroup = assignmentGroup;
}

public String getAssignedTo() {
	return assignedTo;
}

public void setAssignedTo(String assignedTo) {
	this.assignedTo = assignedTo;
}

public String getShortDescription() {
	return shortDescription;
}

public void setShortDescription(String shortDescription) {
	this.shortDescription = shortDescription;
}

public String getCloseCode() {
	return closeCode;
}

public void setCloseCode(String closeCode) {
	this.closeCode = closeCode;
}


public String getCloseNotes() {
	return closeNotes;
}


public void setCloseNotes(String closeNotes) {
	this.closeNotes = closeNotes;
}


@Override
public String toString() {
	return "Data [id=" + id + ", number=" + number + ", caller=" + caller + ", category=" + category + ", subCategory="
			+ subCategory + ", businessService=" + businessService + ", configurationItem=" + configurationItem
			+ ", contactType=" + contactType + ", state=" + state + ", impact=" + impact + ", urgency=" + urgency
			+ ", priority=" + priority + ", assignmentGroup=" + assignmentGroup + ", assignedTo=" + assignedTo
			+ ", shortDescription=" + shortDescription + ", closeCode=" + closeCode + ", closeNotes=" + closeNotes
			+ "]";
}

}
