package preparation;

import static java.util.Objects.isNull;

public record Version(Integer major, Integer minor, Integer patch) implements Comparable<Version> {
    public Version {
        if (isNull(major) || (major < 0)) throw new IllegalArgumentException("majorは0以上の数です。");
        if (isNull(minor) || (minor < 0)) throw new IllegalArgumentException("minorは0以上の数です。");
        if (isNull(patch) || (patch < 0)) throw new IllegalArgumentException("patchは0以上の数です。");
    }

    public Version majorUpdate() {
        return new Version(major + 1, minor, patch);
    }

    public Version minotUpdate() {
        return new Version(major, minor + 1, patch);
    }

    public Version patchUpdate() {
        return new Version(major, minor, patch + 1);
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

    @Override
    public boolean equals(Object other) {
        Version version = (Version) other;
        return ((major.equals(version.major())) && (minor.equals(version.minor())) && (patch.equals(version.patch())));
    }

    @Override
    public int compareTo(Version other) {
        if (!major.equals(other.major())) return major.compareTo(other.major());
        if (!minor.equals(other.minor())) return minor.compareTo(other.minor());
        if (!patch.equals(other.patch())) return patch.compareTo(other.patch());
        return 0;
    }
}
