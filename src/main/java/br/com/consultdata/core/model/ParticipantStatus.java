package br.com.consultdata.core.model;

public enum ParticipantStatus {

    ACTIVE,
    INACTIVE;

    public static ParticipantStatus convert(final String status) {
        if (status == null) {
            System.out.printf("teste");
        }
        return "Active".equals(status) ? ACTIVE : INACTIVE;
    }
}
