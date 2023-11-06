package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Empleado;
import com.example.demo.dao.IEmpleadoDAO;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	//Listar todos
		public List<Empleado> listarClientes(){
			return iEmpleadoDAO.findAll();
		};
		
		//Listar por id
		public Empleado empleadoXID(Integer id) {
			return iEmpleadoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Empleado guardarEmpleado(Empleado cliente) {
			return iEmpleadoDAO.save(cliente);
		};
		
		//Actualizar
		public Empleado actualizarEmpleado(Empleado cliente) {
			return iEmpleadoDAO.save(cliente);
		};
		
		//Eliminar
		public void eliminarEmpleado(Integer id) {
			iEmpleadoDAO.deleteById(id);
		};
		
		// Listar empleados por trabajo
		public List<Empleado> listarEmpleadosPorTrabajo(String trabajo) {
		    return iEmpleadoDAO.findBytrabajo(trabajo);
		}
}