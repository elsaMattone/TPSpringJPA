package monprojet.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    
    @Query(value = "SELECT SUM(population)" 
            + "FROM City" 
            + "INNER JOIN Country ON City.country = Country.name"
            + "WHERE Country.id = :idDePays", 
            nativeQuery = true)
    public int pop(int idDePays);    
    
    @Query(value = "SELECT name, pop(id)"
            + "FROM Country"
            + "WHERE id.getName()==name",
            nativeQuery = true)
    public List<Country> paysEtPopulations();
}
