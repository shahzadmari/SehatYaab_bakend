package com.fyp.SehatYaabBackend.dto;



public class AppointmentRequest {

        private String patientId;
        private String doctorId;
        private int timeSlotId;
        private String appointmentDate;

        private String appointmentStatus;// In String format, you can convert to LocalDate
        private String appointmentDay;
        private String appointmentType;



        public AppointmentRequest() {
        }

        public AppointmentRequest(String patientId, String doctorId, int timeSlotId, String appointmentDate,String appointmentStatus ,String appointmentDay, String appointmentType) {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.timeSlotId = timeSlotId;
            this.appointmentDate = appointmentDate;
            this.appointmentStatus = appointmentStatus;
            this.appointmentDay = appointmentDay;
            this.appointmentType = appointmentType;
        }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(String doctorId) {
            this.doctorId = doctorId;
        }

        public int getTimeSlotId() {
            return timeSlotId;
        }

        public void setTimeSlotId(int timeSlotId) {
            this.timeSlotId = timeSlotId;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public String getAppointmentDay() {
            return appointmentDay;
        }

        public void setAppointmentDay(String appointmentDay) {
            this.appointmentDay = appointmentDay;
        }

        public String getAppointmentType() {
            return appointmentType;
        }

        public void setAppointmentType(String appointmentType) {
            this.appointmentType = appointmentType;
        }

        @Override
        public String toString() {
            return "AppointmentRequest{" +
                    "patientId=" + patientId +
                    ", doctorId=" + doctorId +
                    ", timeSlotId=" + timeSlotId +
                    ", appointmentDate='" + appointmentDate + '\'' +
                    ", appointmentDay='" + appointmentDay + '\'' +
                    ", appointmentType='" + appointmentType + '\'' +
                    '}';
        }
    }


