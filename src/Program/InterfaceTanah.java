/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.List;

/**
 *
 * @author RAMA
 */
public interface InterfaceTanah {
    void insert(Tanah tanah);
    void update(Tanah tanah , int id);
    void delete( int id);
    List<Tanah> tampil ();
}
