package preparation;

public enum FizzBuzzType {
    FIZZ {
        @Override
        public String execute() {
            return "Fizz";
        }
    },
    BUZZ {
        @Override
        public String execute() {
            return "Buzz";
        }
    },
    FIZZ_BUZZ {
        @Override
        public String execute() {
            return "FizzBuzz";
        }
    },
    NUMBER {
        @Override
        public String execute() {
            return "";
        }
    };

    public abstract String execute();
}
