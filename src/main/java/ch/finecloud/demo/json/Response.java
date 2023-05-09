package ch.finecloud.demo.json;

import java.util.List;

public record Response(List<Result> results, String status) {
    public Location getLocation() {
        return results.get(0).geometry().location();
    }

    public String getFormattedAddress() {
        return results.get(0).formattedAddress();
    }
}
