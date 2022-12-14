package com.example.main;

import com.example.handlers.*;

/**
 * Used to generate chain of approval.
 * DO NOT MODIFY.
 */
public class ApprovalChainGenerator {
    private ApprovalChainGenerator() {
    }
    public static Approver generate(Approver manager) {
        Approver director = new Director();
        Approver vicePresident = new VicePresident();
        Approver president = new President();

        return manager
                .registerNext(director)
                .registerNext(vicePresident)
                .registerNext(president)
                .registerNext(ExecutiveMeeting.getInstance());
    }

}