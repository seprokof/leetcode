
class VersionControl {

    private final int badVersion;

    VersionControl(int badVersion) {
        super();
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
        return version >= badVersion;
    }

}
