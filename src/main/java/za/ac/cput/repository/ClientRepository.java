package za.ac.cput.repository;

import za.ac.cput.entity.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements IClientRepository {
    private static ClientRepository repository = null;
    private Set <Client> clientDB = null;

    private ClientRepository(){
        clientDB = new HashSet<Client>();
    }
    public static ClientRepository getRepository(){
        if( repository == null){
            repository = new ClientRepository();
        }
        return repository;
    }
    public Client create (Client client){
        boolean success = clientDB.add(client);
        if(!success)
            return null;
        return client;
    }
    public Client read(String clientNum){
        for (Client c : clientDB){
            if (c.getClientNum().equals(clientNum))
                return c;
        }
        return null;
    }
    public Client update (Client client){
        Client oldclient = read (client.getClientNum());
        if(oldclient != null){
            clientDB.remove(oldclient);
            clientDB.add(client);
            return client;
        }
        return null;
    }
    public boolean delete (String clientNum){
        Client clientToDelete = read (clientNum);
        if(clientNum == null)
            return false;
        clientDB.remove(clientToDelete);
        return true;
    }
    public Set<Client> getAll(){
        return clientDB;
    }
}

