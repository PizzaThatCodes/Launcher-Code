package server.user;

public class TutorialUser {

    public String mcName;
    public boolean isUser;
    public boolean areWingsEnabled;
    public boolean areTophatEnabled;
    public boolean areBandanaEnabled;

    public TutorialUser(String mcName,
                        boolean isUser,
                        boolean areWingsEnabled,
                        boolean areTophatEnabled,
                        boolean areBandanaEnabled) {
        this.mcName = mcName;
        this.isUser = isUser;
        this.areWingsEnabled = areWingsEnabled;
        this.areTophatEnabled = areTophatEnabled;
        this.areBandanaEnabled = areBandanaEnabled;
    }

    public String getProperties() {
        return mcName + ":" + (isUser ? "true" : "false") +
                ":" + (areWingsEnabled ? "true" : "false") +
                ":" + (areTophatEnabled ? "true" : "false") +
                ":" + (areBandanaEnabled ? "true" : "false");
    }


    public boolean areUsingWings() {
        return areWingsEnabled;
    }

    public boolean areUsingTophat() {
        return areTophatEnabled;
    }

    public boolean areUsingBandana() {
        return areBandanaEnabled;
    }

    public String getMcName() {
        return mcName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public void setWingsEnabled(boolean enabled) {
        this.areWingsEnabled = enabled;
    }
    public void setTophatEnabled(boolean enabled) {
        this.areTophatEnabled = enabled;
    }
    public void setBandanaEnabled(boolean enabled) {
        this.areBandanaEnabled = enabled;
    }
}
