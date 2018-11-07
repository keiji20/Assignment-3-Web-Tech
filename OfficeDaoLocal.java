/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Office;

/**
 *
 * @author Keiji
 */
@Local
public interface OfficeDaoLocal {

    void addOffice(Office office);

    void editOffice(String office);

    void editOffice(Office office);

    void deleteOffice(int officeId);

    void businessMethod();

    Office getOffice(int officeId);

    List<Office> getAllOffices();
    
}
