package com.wave.worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.worker.entities.Worker;
import com.wave.worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(Worker.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll() ;
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		//TO DO
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = workerRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
