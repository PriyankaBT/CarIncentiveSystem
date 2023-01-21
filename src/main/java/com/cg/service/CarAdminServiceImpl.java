package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.CarAdmin;
import com.cg.exception.AuthenticationFailureException;
import com.cg.repository.CarAdminRepo;

@Service
public class CarAdminServiceImpl implements CarAdminService {
	@Autowired
	private CarAdminRepo carAdminRepo;

	@Override
	public CarAdmin carAdminLogin(String userName, String password) {

		CarAdmin carAdmin = carAdminRepo.doCarAdminLogin(userName, password);

		if (carAdmin == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		return carAdmin;
	}

	@Override
	public List<CarAdmin> getAllCarAdmin() {
		List<CarAdmin> carAdmin = carAdminRepo.findAll();
		return carAdmin;

	}

	@Override
	public CarAdmin saveCarAdmin(CarAdmin c) {
		CarAdmin savedCarAdmin = carAdminRepo.save(c);
		return savedCarAdmin;
	}

}
