package com.springBoot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.javafx.beans.IDProperty;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Table(name="JPA_ADDRESSES")
@Entity
public class Addresses {

    @Id
	private Integer id;
	private String address;

	public Addresses() {
	}

	public Addresses(Integer id, String address) {
		this.id = id;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}