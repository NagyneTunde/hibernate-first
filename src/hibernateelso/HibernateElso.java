/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateelso;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.City;
import pojos.Country;

/**
 *
 * @author nagyg
 */
public class HibernateElso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        String orszagNev = "Hungary";
        //List<City> varosok = session.createQuery("FROM City WHERE country.code=:orszagKodPar").list();//case sensitive, az osztály neve kell h legyen
//        Query q = session.createQuery("FROM City WHERE country.code=:orszagKod");
//        q.setString("orszagKod", "HUN");
//        List<City> varosok = q.list();

        Country magyaro = (Country) session.createQuery("FROM Country WHERE name=:orszagNev")
                .setString("orszagNev", orszagNev).uniqueResult();
        session.close();
        
        for (City city : magyaro.getCities()) {
            System.out.println(city);//csináltunk neki egy toStringet a City.java-ba
        }
        
        
        
        //új város létrehozása
//       City ujVaros = new City(magyaro,"Baja","Bács-Kiskun",10000);
//        
//        session.beginTransaction();
//        session.save(ujVaros);
//        session.getTransaction().commit();

        //város módosítása
        //City ct = (City) session.get(City.class, 4087);így is lehet, ha tudjuk az id-jét
//        City c = (City) session.createQuery("FROM City WHERE name=:varosNev")
//                .setString("varosNev", "Baja").uniqueResult();
//        c.setPopulation(12000);
//        session.beginTransaction();
//        session.save(c);
//        session.getTransaction().commit();


        //törlés
//        City ct = (City) session.get(City.class, 4087);//ez Baja id-ja
//        session.beginTransaction();
//        session.delete(ct);
//        session.getTransaction().commit();

//        Query q = session.createQuery("FROM City WHERE country.name=:orszagNevPar ORDER BY name ASC");
//        q.setString("orszagNevPar", orszagNev);
//        List<City> varosok = q.list();
//        for (City city : varosok) {
//            System.out.println(city.getName() + ", lakosok száma: " + city.getPopulation());
//        }

        //session.close();

        hibernate.HibernateUtil.getSessionFactory().close();
    }

}
