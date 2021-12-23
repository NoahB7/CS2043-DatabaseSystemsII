/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

import java.util.ArrayList;

/**
 *
 * @author noah_
 */
public interface UAInterface<Type> {
    
     ArrayList<Type> getAll();
    boolean remove(Type UA);
    boolean insert(Type UA);
}
