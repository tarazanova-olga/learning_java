package rest;


public class Issue {
    private int id;
    private String subject;
    private String description;
    private String state_name;

    public int getId() {

        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Issue withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (subject != null ? !subject.equals(issue.subject) : issue.subject != null) return false;
        return description != null ? description.equals(issue.description) : issue.description == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", state_name='" + state_name + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState_name() {
        return state_name;
    }

    public Issue withState_name(String state_name) {
        this.state_name = state_name;
        return this;
    }
}
