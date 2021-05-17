package service;

import dao.Dao;
import model.Manufacturer;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ManufacturerDaoImpl implements Dao<Manufacturer,Integer> {
    private final SessionFactory factory;

    public ManufacturerDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Manufacturer readById(Integer id) {
        try (Session session = factory.openSession()){
            Manufacturer manufacturer = session.get(Manufacturer.class,id);
            return manufacturer;
        }
    }

    @Override
    public List<Manufacturer> readByAll() {
        try (Session session = factory.openSession()){
            Query<Manufacturer> query = session.createQuery("FROM Manufacturer ");
            return query.list();
        }
    }
}
