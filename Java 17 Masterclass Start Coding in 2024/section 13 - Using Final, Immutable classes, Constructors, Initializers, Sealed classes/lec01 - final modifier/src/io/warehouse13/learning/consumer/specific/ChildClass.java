package io.warehouse13.learning.consumer.specific;

import io.warehouse13.learning.generic.BaseClass;

public class ChildClass extends BaseClass {
    // 'recommendedMethod()' cannot override 'recommendedMethod()'
    // in 'io.warehouse13.learning.generic.BaseClass';
    // overridden method is final
    //@Override
    //public void recommendedMethod() {
    //    System.out.println("[ChildClass.recommendedMethod]: I do things the way i want...");
    //    optionalMethod();
    //}

    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

    // we can't override a private method... private is final
    private void mandatoryMethod()  {
        System.out.println("[Child.mandatoryMethod]: My own important stuff...");
    }
    public static void recommendedStatic() {
        System.out.println("[Child.recommendedStatic] BEST Way to Do it");
        optionalStatic();
        //mandatoryStatic();
    }
}
