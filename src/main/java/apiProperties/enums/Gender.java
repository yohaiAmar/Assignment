package apiProperties.enums;

public enum Gender {

    MALE{
        @Override
        public String toString() {
            return "male";
        }
    },
    FEMALE{
        @Override
        public String toString() {
            return "female";
        }
    }
}
