package com.example.common;

public class MessageApproval {

    public static void approved(String approver, Purchase purchase) {
        int id = purchase.id();
        double cost = purchase.cost();
        Type type = purchase.type();

        String message = String.format("%s approved purchase (%s) with id %d that costs %.2f.%n", approver, type, id, cost);
        System.out.println(message);
    }

    public static void notApproved(String approver, Purchase purchase) {
        int id = purchase.id();

        String message = String.format("Purchase with id %d needs approval from higher position than %s.", id, approver);
        System.out.println(message);
    }

    public static void startMeeting(String approver, Purchase purchase) {
        int id = purchase.id();
        double cost = purchase.cost();
        Type type = purchase.type();

        String message = String.format("Purchase (%s) with id %d that costs %.2f requires"
                + " an approval at executive meeting.", type, id, cost);
        System.out.println(message);
        System.out.println("Starting meeting...");
    }

}

