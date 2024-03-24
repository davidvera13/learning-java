package io.warehouse13.learning;

import io.warehouse13.learning.consumer.specific.ChildClass;
import io.warehouse13.learning.external.utils.Logger;
import io.warehouse13.learning.generic.BaseClass;

public class Main {
    public static void main(String[] args) {
        BaseClass parent =  new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferedToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("*****************");
        childReferedToAsBase.recommendedMethod();
        System.out.println("*****************");
        child.recommendedMethod();

        // using static methods
        // Static member 'io.warehouse13.learning.generic.BaseClass.recommendedStatic()'
        // accessed via instance reference

        // hidding vs overriding
        System.out.println("*****************");
        parent.recommendedStatic();
        System.out.println("*****************");
        childReferedToAsBase.recommendedStatic();
        System.out.println("*****************");
        child.recommendedStatic();

        // les confusing....
        System.out.println("*****************");
        BaseClass.recommendedStatic();
        System.out.println("*****************");
        ChildClass.recommendedStatic();

        System.out.println("*****************");
        String xArg = "This is all I have to say about section ";
        int yArg = 13;
        StringBuilder zArg = new StringBuilder("Only saying section ");
        doXYZ(xArg, yArg, zArg);
        // immutable !
        System.out.println("After method, xArg = " + xArg);
        // we have side effect ... we don't change the stringbuilder
        // we can't reassign the stringbuilder to a new one
        // final doesn't mean immutable
        System.out.println("After method, zArg = " + zArg);

        System.out.println("*****************");
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker);
        tracker.append("Step 2 is wyz");
        Logger.logToConsole(tracker);
        System.out.println("After logging, tracker = " + tracker);

        System.out.println("*****************");
        // using to string ?
        tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(" - Step 2 is wyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);
    }

    private static void doXYZ(
            final String x,
            int y,
            final StringBuilder z) {
        final String c = x + y;
        System.out.println("c = " + c);
        // java: cannot assign a value to final variable c
        // c+= "oops, i can't do that ...";

        // java: final parameter x may not be assigned
        // x += "oops, i can't do that too...";
        z.append(y);
    }
}
