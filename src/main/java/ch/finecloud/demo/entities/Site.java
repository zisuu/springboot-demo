package ch.finecloud.demo.entities;

public record Site(int id, String address, double lat, double lng) {
    public Site(String address, double lat, double lng) {
        this(0, address, lat, lng);
    }
}
