package Week_4;

class B extends A {
    @Override
    public void loop() {
        if(counter == 1) {
            super.loop();
        }
    }
}