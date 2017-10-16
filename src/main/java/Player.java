/**
 * Created by owner on 01.09.2017.
 */
public class Player {

        private String name;
        private String region;
        private String location;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }

