/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxpojobinding;

/**
 *
 * @author Mario
 */
public interface PojoJFXModel<T> {
    T unwrapp();
    T getPojo();
    void setPojo(T pojo);
}
