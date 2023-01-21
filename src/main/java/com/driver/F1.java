package com.driver;

public class F1 extends Car {

    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        super(name,isManual);


    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getCurrentGear() {
        return super.getCurrentGear();
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
        if(getCurrentSpeed()>=1 && getCurrentSpeed()<=50){
            changeGear(1);
        }
        else if(getCurrentSpeed()>=51 && getCurrentSpeed()<=100){
            changeGear(2);
        }else if(getCurrentSpeed()>=101 && getCurrentSpeed()<=150){
            changeGear(3);
        }else if(getCurrentSpeed()>=151 && getCurrentSpeed()<=200){
            changeGear(4);
        }else if(getCurrentSpeed()>=201 && getCurrentSpeed()<=250){
            changeGear(5);
        }else if(getCurrentSpeed()>250){
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
