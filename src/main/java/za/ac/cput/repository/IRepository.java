package za.ac.cput.repository;
/*
 * IRepository.java repository interface
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */
public interface IRepository <T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
