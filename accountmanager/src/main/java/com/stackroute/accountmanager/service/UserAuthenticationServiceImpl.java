package com.stackroute.accountmanager.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.repository.UserAutheticationRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */


@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    /*
	 * Autowiring should be implemented for the UserAuthenticationRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	UserAutheticationRepository userAuthenticationRepository;

    public UserAuthenticationServiceImpl(UserAutheticationRepository userAuthenticationRepository) {
		super();
		this.userAuthenticationRepository = userAuthenticationRepository;
	}



     /*
	 * This method should be used to validate a user using userId and password.
	 *  Call the corresponding method of Respository interface.
	 * 
	 */
    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {

      
    	User user = userAuthenticationRepository.findByUserIdAndUserPassword(userId, password);
    	if(user == null ) {
    		throw new UserNotFoundException("");
    	}
        return user;
    }




	/*
	 * This method should be used to save a new user.Call the corresponding method
	 * of Respository interface.
	 */

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
       
    	boolean result = false;
		User resultUser = null;
		User existingUser = new User();
		if (user != null) {
			try {
				existingUser = userAuthenticationRepository.findById(user.getUserId()).get();
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException Occured");
				existingUser = null;
			}
			if (existingUser == null) {
				resultUser = userAuthenticationRepository.save(user);
			}
			if (resultUser != null) {
				result = true;
			} else {
				throw new UserAlreadyExistsException("User Already exists");
			}
		}
		return result;
    }
}
