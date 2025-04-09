public class Student {
        private int id;
        private String name;
        private String rollNo;
        private String course;
        private String email;

        public Student(String name, String rollNo, String course, String email) {
            this.name = name;
            this.rollNo = rollNo;
            this.course = course;
            this.email = email;
        }

        public Student(int id, String name, String rollNo, String course, String email) {
            this(name, rollNo, course, email);
            this.id = id;
        }


// Getters and setters
        // (Add them if needed)


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollNo() {
            return rollNo;
        }



        public void setRollNo(String rollNo) {
            this.rollNo = rollNo;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Roll No: " + rollNo +
                    ", Course: " + course + ", Email: " + email;
        }

    }


