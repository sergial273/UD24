package com.example.demo.services;
import java.util.List;
import com.example.demo.dto.Empleado;

public interface IEmpleadoService {
	
	//Listar todos
	public List<Empleado> listarClientes();
	
	//Listar por id
	public Empleado empleadoXID(Integer id); 
	
	//Guardar
	public Empleado guardarEmpleado(Empleado cliente);
	
	//Actualizar
	public Empleado actualizarEmpleado(Empleado cliente);
	
	//Eliminar
	public void eliminarEmpleado(Integer id);
	
	//listar empleados por trabajo
	public List<Empleado> listarEmpleadosPorTrabajo(String trabajo);
}
