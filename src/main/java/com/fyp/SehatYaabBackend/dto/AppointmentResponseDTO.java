package com.fyp.SehatYaabBackend.dto;

public class AppointmentResponseDTO {


        private int appointmentId;
        private String patientName;
        private String doctorName;
        private int tokenno;
        private String appointmentDate;
        private String appointmentDay;
        private String appointmentType;

        public AppointmentResponseDTO(int appointmentId, String patientName, String doctorName,
                              int tokenno, String appointmentDate,
                              String appointmentDay, String appointmentType) {
            this.appointmentId = appointmentId;
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.tokenno = tokenno;
            this.appointmentDate = appointmentDate;
            this.appointmentDay = appointmentDay;
            this.appointmentType = appointmentType;
        }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTokenno() {
        return tokenno;
    }

    public void setTokenno(int tokenno) {
        this.tokenno = tokenno;
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

    // Getters and Setters
        // ...

}
