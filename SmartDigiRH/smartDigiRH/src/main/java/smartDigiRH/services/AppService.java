package smartDigiRH.services;

import java.util.List;

import smartDigiRH.entities.User;


public interface AppService <T>{
	
	
	
	public void save(T obj);
	
	public void update(T obj);

	public void delete(Long id);	
	
	public T findById(Long id); 
	
	public List<T> getAll();
	
	User loadUserByUserName (String username);
	

}
