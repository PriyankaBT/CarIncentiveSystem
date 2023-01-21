package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.entity.CarAdmin;

@Service
public interface CarAdminService {

	public CarAdmin carAdminLogin(String userName, String password);

	public List<CarAdmin> getAllCarAdmin();

	public CarAdmin saveCarAdmin(CarAdmin c);

}
