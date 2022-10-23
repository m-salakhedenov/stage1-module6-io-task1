package com.epam.mjc.io;

public class ProfileParser {

    private String data;

    public ProfileParser() {
    }

    public ProfileParser(String rawData) {
        this.data = rawData.strip();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Profile parse() {
        Profile profile = new Profile();

        String[] lines = data.split("\\r?\\n");

        for (String line : lines) {
            String[] keyValue = line.split("\\s*:\\s*");

            switch (keyValue[0]) {
                case "Name":
                    profile.setName(keyValue[1]);
                    break;
                case "Age":
                    profile.setAge(Integer.parseInt(keyValue[1]));
                    break;
                case "Email":
                    profile.setEmail(keyValue[1]);
                    break;
                case "Phone":
                    profile.setPhone(Long.parseLong(keyValue[1]));
                    break;
                default:
                    throw new ProfileParseException("Unexpected profile parameter: " + keyValue[0]);
            }
        }

        return profile;
    }

}
