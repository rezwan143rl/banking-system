public class Customer {

        private String firstName;
        private String lastName;

        public Customer() {
        }

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String FName) {
            this.firstName = FName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String LName) {
            this.lastName = lastName;
        }
    }

