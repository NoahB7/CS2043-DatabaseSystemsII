/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2lab2_nbuchanan;

/**
 *
 * @author noah_
 */
class UAEmployee {
      
        private int ID;
        private String firstName;
        private String lastName;
        private String email;
        
        public int getID(){
            return ID;
        }
        public void setID(int ID){
            this.ID = ID;
        }
        public String getFirstName(){
            return firstName;
        }
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public void setLastName(String lastName){
            this.lastName = lastName;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
}
