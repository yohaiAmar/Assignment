package apiProperties.enums;

public enum Statuses {

    INACTIVE{
        @Override
        public String toString() {
            return "inactive";
        }
    },
    ACTIVE{
        @Override
        public String toString() {
            return "active";
        }
    }
}
