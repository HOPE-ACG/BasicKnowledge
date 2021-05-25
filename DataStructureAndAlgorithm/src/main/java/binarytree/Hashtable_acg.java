package binarytree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hash table based on array and linked list.This data structure saved data via
 * key-value form.Algorithm could use mapped function.
 *
 * @author ACHENGE
 */
public class Hashtable_acg {

    /**
     * The array that saved linked list or binary tree
     */
    private final Object[] obj;

    /**
     * Constructor of Hashtable_acg with {@code capacity} parameter
     * @param capacity {@code obj} array's capacity
     */
    public Hashtable_acg(int capacity) {
        this.obj = new Object[capacity];
        for(int i=0;i<obj.length;i++) {
            obj[i] = new LinkedList<Employee>();
        }
    }

    /**
     * Add information
     * @param emp employee entity
     * @return location in array
     */
    public int add(Employee emp) {
        return new Linkedlist_acg().add(emp);
    }

    /**
     * Delete information
     * @param id employee id
     * @return whether had been deleted
     */
    public boolean delete(int id) {
        return new Linkedlist_acg().delete(id);
    }

    /**
     * Present all employee
     */
    public void present(){
        new Linkedlist_acg().present();
    }

    /**
     * Linked list class is used to save based layer data
     */
    final class Linkedlist_acg {

        /**
         * Add information
         * @param emp employee entity
         * @return location in array
         */
        public int add(Employee emp) {
            int num = hashFun(emp.id);
            if(obj[num] instanceof LinkedList) {
                ((LinkedList<Employee>) obj[num]).add(emp);
            }
            return num;
        }

        /**
         * Delete information
         * @param id employee id
         * @return whether had been deleted
         */
        public boolean delete(int id) {
            int num = hashFun(id);
            if(obj[num] instanceof LinkedList) {
                LinkedList<?> list =  (LinkedList<?>) obj[num];
                Iterator<?> iterator = list.iterator();
                if(iterator.hasNext()) {
                    Object obj = iterator.next();
                    if(obj instanceof Employee) {
                        Employee e = (Employee) obj;
                        if(e.id == id) {
                            list.remove(e);
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Present all employee
         */
        public void present (){
            int count = 1;
            for(Object o:obj){
                if(o instanceof LinkedList) {
                    LinkedList<?> list = (LinkedList<?>)o;
                    System.out.println("No."+count+" linked list:");
                        Iterator<?> iterator = list.iterator();
                        if(iterator.hasNext()) {
                            Object obj = iterator.next();
                            if(obj instanceof Employee) {
                                Employee e = (Employee) obj;
                                System.out.println("\tname:"+e.name+";age"+e.age+";phone"+e.phone);
                            }
                        }
                }
                count++;
            }
        }

        /**
         * Hash function.Calculating the location of employee in linked list
         * @param id employee number
         * @return location in array
         */
        public int hashFun(int id) {
            return id % obj.length;
        }
    }

    /**
     * Entity class
     */
    public final static class Employee {
        /**
         * employee id
         */
        private final int id;

        /**
         * employee name
         */
        private final String name;

        /**
         * employee age
         */
        private final int age;

        /**
         * employee phone
         */
        private final String phone;

        /**
         * Constructor of entity
         * @param name employee name
         * @param age employee age
         * @param phone employee phone
         */
        public Employee(int id,String name, int age, String phone) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.phone = phone;
        }
    }
}
