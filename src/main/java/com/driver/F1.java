package com.driver;

public class F1 extends Car {

    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        super(name,isManual);


    }

    public void accelerate(int rate){
        int newSpeed = 0; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        setCurrentSpeed(getCurrentSpeed()+rate);
        if(getCurrentSpeed()==0){
            changeGear(1);
        }
        if(getCurrentSpeed()>50){
            changeGear(2);
        }
        if(getCurrentSpeed()>100){
            changeGear(3);
        }
        if(getCurrentSpeed()>150){
            changeGear(4);
        }
        if(getCurrentSpeed()>200){
            changeGear(5);
        }
        else{
            changeGear(6);
        }

        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            stop();
            changeGear(1);
        }
        //for all other cases, change the gear accordingly

        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
