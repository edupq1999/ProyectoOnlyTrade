package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlytrade.model.Roles;
import com.onlytrade.repository.RolesRepository;
import com.onlytrade.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{
		private RolesRepository rolesRepository;
	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

	
}
