package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService{

	@Autowired
	CarreraRepository carreraRepository;
	
	@Override
	public void guardarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		//carrera.setEstado(true);
		carreraRepository.save(carrera);
	}

	@Override
	public List<Carrera> mostrarCarreras() {
		// TODO Auto-generated method stub
		//return carreraRepository.findAll();
		return carreraRepository.findCarreraByEstado(true);
	}

	@Override
	public void borrarCarrera(String codigo) {
		System.out.println("este es el codigo: "+codigo);
		// TODO Auto-generated method stub
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (int i = 0; i < todasLasCarreras.size(); i++) {
		      Carrera carrera = todasLasCarreras.get(i);
		      if (carrera.getCodigo().equals(codigo)) {
		        carrera.setEstado(false);
		        carreraRepository.save(carrera);
		        break;
		      }
		    }
	}

	@Override
	public void modificarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrera buscarCarrera(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
