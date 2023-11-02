
package J1SP0077.Form;


public abstract class Form {

    protected enum EXIT_OPTION {
        UPDATE_EXIT, LOOP_EXIT
    };

    public abstract void setup();

    public abstract EXIT_OPTION update();

    public void loop() {
        while(this.update() != EXIT_OPTION.LOOP_EXIT);
    }

}
