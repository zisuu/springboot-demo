package ch.finecloud.demo.json;

public record Result(String formattedAddress, Geometry geometry) {
    @Override
    public String formattedAddress() {
        return formattedAddress;
    }

    @Override
    public Geometry geometry() {
        return geometry;
    }
}
