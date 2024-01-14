package lab11.entities;

import java.util.*;
import lab11.exceptions.ExistsException;

public class Bank {
    private final Set<Business> clients = new HashSet<>();

    public void addClient(final Business client) throws ExistsException {
    	if (clients.contains(client)) {
    		throw new ExistsException("Client already exists into the bank");
    	} 
    		
    	clients.add(client);
    }
    
    public Set<Business> getClients() {
		return Collections.unmodifiableSet(clients);
	}
}
