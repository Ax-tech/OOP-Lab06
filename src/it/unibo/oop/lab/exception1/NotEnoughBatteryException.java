package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot tries to move
 * while its battery is empty.
 */

public class NotEnoughBatteryException extends IllegalStateException {

	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
    private final double requiredBatteryLevel;

    /**
     * @param batteryLevel
     *            current battery level
     * @param required
     *            required level to move
     */
    public NotEnoughBatteryException(final double battery, final double required) {
        super();
        this.batteryLevel = battery;
        this.requiredBatteryLevel = required;
    }

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String toString() {
        return "Can not move! Battery level (" + this.batteryLevel + ") is not enough! Battery required is: " + this.requiredBatteryLevel;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
