package org.example.Todopractice.todoPackage;

public class ToDo {
    public Integer todoId;
    public String todoName;
    public Boolean isTodoDoneStatus;

    public ToDo(Integer todoId, String todoName, boolean isTodoDoneStatus) {
        this.todoId = todoId;
        this.todoName = todoName;
        this.isTodoDoneStatus = isTodoDoneStatus;
    }

    public ToDo() {
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean isTodoDoneStatus() {
        return isTodoDoneStatus;
    }

    public void setTodoDoneStatus(boolean todoDoneStatus) {
        isTodoDoneStatus = todoDoneStatus;
    }
}
