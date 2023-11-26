package preparation;

import static org.apache.commons.lang3.StringUtils.countMatches;

public record BinaryNumber(Integer number) {
    public Integer countNumberOfOneInBinary() {
        return countMatches(Integer.toBinaryString(number), "1");
    }
}
