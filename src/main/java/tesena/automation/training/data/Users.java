package tesena.automation.training.data;

public enum Users {
    NOVAK("novak.xml");

    private String fileName;

    Users(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
