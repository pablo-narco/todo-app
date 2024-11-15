class Todo {
    private int id;
    private String task;
    private boolean isCompleted;

    public Todo(int id, String task) {
        this.id = id;
        this.task = task;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return id + ". " + task + " ("
                + (isCompleted ? "Bajarildi" : "Bajarilmadi") + ")";
    }
}