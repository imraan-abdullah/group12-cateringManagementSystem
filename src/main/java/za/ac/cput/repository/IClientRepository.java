package za.ac.cput.repository;

import za.ac.cput.entity.Client;

import java.util.Set;

public interface IClientRepository extends IRepository <Client , String> {
    public Set<Client> getAll();
}
