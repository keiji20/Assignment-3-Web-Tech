/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Office;

/**
 *
 * @author Keiji
 */
@Stateless
public class OfficeDao implements OfficeDaoLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addOffice(Office office) {
        em.persist(office);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void editOffice(Office office) {
        em.merge(office);
    }

    @Override
    public void deleteOffice(int officeId) {
        em.remove(getOffice(officeId));
    }

    @Override
    public Office getOffice(int officeId) {
        return em.find(Office.class, officeId);
    }

    @Override
    public List<Office> getAllOffices() {
        return em.createNamedQuery("Office.getAll").getResultList();
    }

    @Override
    public void editOffice(String office) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
