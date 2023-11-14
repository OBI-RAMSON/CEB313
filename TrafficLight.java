public enum TrafficLight {
    RED(30),
    GREEN(45),
    YELLOW(5);

    private final int duration; // in seconds

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        System.out.println("Traffic Light Durations:");
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + ": " + light.getDuration() + " seconds");
        }
    }
}
