package za.ac.cput.repository;

import za.ac.cput.entity.WaitingStaff;
import java.util.Set;

/*
 * IWaitingStaffRepository.java repository interface for WaitingStaff
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */
public interface IWaitingStaffRepository extends IRepository <WaitingStaff, String>
{
    public Set<WaitingStaff> getAll();
}
