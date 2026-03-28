package creational.builder;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Computer {
    private final String brand;
    private final String cpu;
    private final String ramGB;
    private final String storageGB;
    private final boolean hasBluetooth;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.brand = builder.brand;
        this.cpu = builder.cpu;
        this.ramGB = builder.ramGB;
        this.storageGB = builder.storageGB;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    public static class Builder {
        private String brand;
        private String cpu;
        private String ramGB;
        private String storageGB;
        private boolean hasBluetooth;
        private boolean hasWifi;

        public Builder(String brand, String cpu) {
            this.brand = brand;
            this.cpu = cpu;
        }

        public Builder ramGB(String ramGB) {
            this.ramGB = ramGB;
            return this;
        }

        public Builder storageGB(String storageGB) {
            this.storageGB = storageGB;
            return this;
        }

        public Builder hasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder hasWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Computer build() {
            validate();
            return new Computer(this);
        }

        private void validate() {
            if (Objects.isNull(brand) || brand.isEmpty()) {
                throw new IllegalArgumentException("Brand is required");
            }
            if (Objects.isNull(cpu) || cpu.isEmpty()) {
                throw new IllegalArgumentException("CPU is required");
            }
        }
    }
}
