package za.ac.cput.repository;

import za.ac.cput.entity.Inventory;
import za.ac.cput.repository.IInventoryRepository;

/*
 * Inventory.java
 * Repository
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 04 April 2022.
 */

import java.util.HashSet;
import java.util.Set;

public class InventoryRepository implements IInventoryRepository {
    private static InventoryRepository inventoryRepo = null;
    private Set <Inventory> inventoryDB;

    //constructor
    private InventoryRepository(){
        inventoryDB = new HashSet <Inventory>();
    }

    //testing repository if exists or not
    public static InventoryRepository getInventoryRepo(){
        if(inventoryRepo == null){
            inventoryRepo = new InventoryRepository();
        }
        return inventoryRepo;
    }

    //CRUD
    @Override
    public Inventory create(Inventory inventory) {
        boolean success = inventoryDB.add(inventory);
        if(!success) {
            return null;
        }
        return inventory;
    }

    @Override
    public Inventory read(String itemID) {
        for (Inventory readInventory : inventoryDB){
            if (readInventory.getItemID().equals(itemID)){
                return readInventory;
            }
        }
        return null;
    }

    @Override
    public Inventory update(Inventory inventory) {
        Inventory oldInventory = read(inventory.getItemID());
        if(oldInventory != null){
            inventoryDB.remove(oldInventory);
            inventoryDB.add(inventory);
            return inventory;
        }
        return null;
    }

    @Override
    public boolean delete(String itemID) {
        Inventory deleteInventory = read(itemID);
        if(deleteInventory == null){
            return false;
        }
        //deleting
        inventoryDB.remove(deleteInventory);
        return true;
    }

    @Override
    public Set<Inventory> getAll() {
        return inventoryDB;
    }
}
